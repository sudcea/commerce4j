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

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.lob.DefaultLobHandler;

import com.commerce4j.model.dao.ItemImageDAO;

/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class ItemImageDAOImpl extends JdbcDaoSupport implements ItemImageDAO {

	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.ItemImageDAO#exists(java.lang.Integer, java.lang.Integer)
	 */
	public boolean exists(Integer itemId, Integer imageIndex) {
		// verify image existence  
		String sql = "SELECT COUNT(*) from c4j_items_images  " +
		"WHERE item_id = ? and image_index = ?";
		int numOfImages = getJdbcTemplate().queryForInt(
				sql, new Object[] {itemId, imageIndex}
		);
		return (numOfImages == 1) ? true : false;
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.ItemImageDAO#findImageAsBytes(java.lang.Integer, java.lang.Integer)
	 */
	public byte[] findImageAsBytes(Integer itemId, Integer imageIndex) {
		// if  found, grab it from database
		String sql = "SELECT image_data from c4j_items_images  " +
				"WHERE item_id = ? and image_index = ?";
		byte[] bytes = (byte[]) getJdbcTemplate().queryForObject(
			sql, new Object[] {itemId, imageIndex}, new RowMapper() {
			final DefaultLobHandler lobHandler = new DefaultLobHandler();
			public byte[] mapRow(ResultSet rs, int rowNum)
			throws SQLException {					
	            return lobHandler.getBlobAsBytes(rs, "image_data"); 
			}
			
		});
		
		return bytes;
	}

}
