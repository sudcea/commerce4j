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

import com.commerce4j.model.dao.TagDAO;
import com.commerce4j.model.dto.TagCountDTO;
import com.commerce4j.model.dto.TagDTO;

/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class TagDAOImpl extends JdbcDaoSupport implements TagDAO {
	
	private RowMapper rowMapper;


	/**
	 * Constructor, Creates a new type instance of {@link ItemDAOImpl}.
	 */
	public TagDAOImpl() {
		super();
		rowMapper = new TagMapper();
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.TagDAO#findAllTagsByItem(java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")
	public List<TagDTO> findAllTagsByItem(Integer itemId) {
		
		String sql = "SELECT it.item_id, tag.tag FROM c4j_items_tags tag " +
				"INNER JOIN c4j_items it ON it.item_id = tag.item_id " +
				"WHERE it.item_id = ?";
		
		Integer[] params = {itemId};
		return getJdbcTemplate().query(sql, params, rowMapper);
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.TagDAO#countAllTagsByName()
	 */
	@SuppressWarnings("unchecked")
	public List<TagCountDTO> countAllTagsByName() {
		String sql = "SELECT tag, count(*) counter FROM c4j_items_tags c " +
					"GROUP BY tag ";
		return getJdbcTemplate().query(sql, new TagCountMapper());
	}
	
	class TagMapper implements RowMapper {

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			TagDTO dto = new TagDTO();
			dto.setTag(rs.getString("tag"));
			return dto;
		}
		
	}
	
	class TagCountMapper implements RowMapper {

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			
			TagDTO tag = new TagDTO();
			tag.setTag(rs.getString("tag"));
			
			TagCountDTO dto = new TagCountDTO(tag, rs.getInt("counter"));
			
			return dto;
		}
		
	}

	
}
