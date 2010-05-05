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

import com.commerce4j.model.dao.BrandDAO;
import com.commerce4j.model.dto.BrandDTO;

/**
 * Spring/JDBC Implementation for the {@link BrandDAO} interface.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class BrandDAOImpl extends JdbcDaoSupport implements BrandDAO {
	
	private RowMapper rowMapper;

	
	/**
	 * Constructor, Creates a new type instance of BrandDAOImpl.
	 */
	public BrandDAOImpl() {
		super();
		rowMapper = new BrandRowMapper();
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.BrandDAO#findAll()
	 */
	@SuppressWarnings("unchecked")
	public List<BrandDTO> findAll() {
		String sql = "SELECT brand_id, brand_name, featured " +
				"FROM c4j_brands ";
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.BrandDAO#findAllFeatured()
	 */
	@SuppressWarnings("unchecked")
	public List<BrandDTO> findAllFeatured() {
		String sql = "SELECT brand_id, brand_name, featured " +
				"FROM c4j_brands WHERE featured = ?";
		return getJdbcTemplate().query(sql, new Object[] {1}, rowMapper);
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.BrandDAO#findById(java.lang.Integer)
	 */
	public BrandDTO findById(Integer brandId) {
		
		String sql = "SELECT brand_id, brand_name, featured " +
		"FROM c4j_brands WHERE featured = ?";
		
		return (BrandDTO) getJdbcTemplate().queryForObject(sql, new Object[] {1}, rowMapper);
	}
	
	/**
	 * Brand Row Mapper.
	 */
	private class BrandRowMapper implements RowMapper {

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			BrandDTO dto = new BrandDTO();
			dto.setBrandId(rs.getInt("brand_id"));
			dto.setBrandName(rs.getString("brand_name"));
			dto.setFeatured(rs.getInt("featured"));
			return dto;
		}
		
	}

}
