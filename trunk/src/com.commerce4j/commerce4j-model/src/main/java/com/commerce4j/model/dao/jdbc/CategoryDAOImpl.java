/**
 * Copyright 2010 Commerce4J.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.commerce4j.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.commerce4j.model.dao.CategoryDAO;
import com.commerce4j.model.dto.CategoryDTO;
import com.commerce4j.model.dto.StoreDTO;

/**
 * Spring/JDBC Implementation for the {@link CategoryDAO} interface.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class CategoryDAOImpl extends JdbcDaoSupport implements CategoryDAO {
	
	private RowMapper rowMapper;
	
	/**
	 * Constructor, Creates a new type instance of {@link CategoryDAOImpl}.
	 */
	public CategoryDAOImpl() {
		super();
		rowMapper = new CategoryMapper();
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.CategoryDAO#findByCategoryId(java.lang.Integer)
	 */
	public CategoryDTO findByCategoryById(Integer categoryId) {
		String sql = "SELECT " +
		"cat.category_id,  cat.description, " +
		"par.category_id as par_category_id,  par.description as par_description, " +
		"cat.status, cat.tooltip, " +
		"sto.store_id, sto.store_name, sto.store_desc " +
		"FROM c4j_categories cat " +
		"INNER JOIN c4j_stores sto ON sto.store_id = cat.store_id " +
		"LEFT JOIN c4j_categories par ON par.category_id = cat.parent_id " +
		" WHERE  cat.category_id = ? ";
		
		Object[] params = {categoryId};
		return (CategoryDTO) getJdbcTemplate().queryForObject(sql, params, rowMapper);
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.CategoryDAO#findCategoryByParent(java.lang.Integer, java.lang.Integer)
	 */
	public List<CategoryDTO> findCategoryByParent(Integer storeId, Integer parentId) {
		
		String sql = "SELECT " +
		"cat.category_id,  cat.description, " +
		"par.category_id as par_category_id,  par.description as par_description, " +
		"cat.status, cat.tooltip, " +
		"sto.store_id, sto.store_name, sto.store_desc " +
		"FROM c4j_categories cat " +
		"INNER JOIN c4j_stores sto ON sto.store_id = cat.store_id " +
		"LEFT JOIN c4j_categories par ON par.category_id = cat.parent_id " +
		" WHERE  cat.store_id = ? ";
		
		Object[] params = null;
		if (parentId == null) {
			params = new Object[] {storeId};
			sql += " AND cat.parent_id is null ";
		} else {
			params = new Object[] {storeId, parentId};
			sql += " AND cat.parent_id = ? ";
		}
		 
		sql += " ORDER BY cat.position" +
				" ";

		
		@SuppressWarnings("unchecked")
		List<CategoryDTO> l = getJdbcTemplate().query(sql, params, rowMapper);

		return l;
	}
	
	/*
	 * Entity Row Mapper 
	 */
	class CategoryMapper implements RowMapper {

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			StoreDTO store = new StoreDTO();
			store.setStoreName(rs.getString("sto.store_name"));
			store.setDescription(rs.getString("sto.store_desc"));
			store.setStoreId(rs.getInt("store_id"));
			
			CategoryDTO parent = new CategoryDTO();
			parent.setCategoryId(rs.getInt("par_category_id"));
			parent.setDescription(rs.getString("par_description"));
			
			CategoryDTO dto = new CategoryDTO();
			dto.setCategoryId(rs.getInt("category_id"));
			dto.setDescription(rs.getString("description"));
			dto.setStatus(rs.getInt("status"));
			dto.setTooltip(rs.getString("tooltip"));
			dto.setStore(store);
			dto.setParent(parent);

			return dto;
		}
		
	}

	
	
	
	
	

}
