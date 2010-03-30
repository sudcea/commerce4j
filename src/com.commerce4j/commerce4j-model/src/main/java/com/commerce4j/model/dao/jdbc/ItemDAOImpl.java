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

import com.commerce4j.model.dao.ItemDAO;
import com.commerce4j.model.dto.ItemDTO;
import com.commerce4j.model.dto.StoreDTO;
import com.commerce4j.model.dto.TypeDTO;
import com.commerce4j.model.dto.UserDTO;

/**
 * Spring/JDBC Implementation for the {@link ItemDAO} interface.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class ItemDAOImpl extends JdbcDaoSupport implements ItemDAO {
	
	private RowMapper rowMapper;
	

	/**
	 * Constructor, Creates a new type instance of {@link ItemDAOImpl}.
	 */
	public ItemDAOImpl() {
		super();
		rowMapper = new ItemMapper();
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.ItemDAO#findAllByCategory(java.lang.Integer)
	 */
	public List<ItemDTO> findAllByCategory(Integer categoryId) {
		String sql = "SELECT " +
				"  it.item_id, " +
				"  it.item_sku, " +
				"  it.created, " +
				"  it.item_title, " +
				"  it.item_desc, " +
				"  it.status, " +
				"  it.item_price, " +
				"  tp.type_id, " +
				"  tp.type_name, " +
				"  tp.type_desc, " +
				"  us.user_id, " +
				"  us.user_name, " +
				"  us.firstname, " +
				"  us.lastname, " +
				"  us.email_address, " +
				"  st.store_id, " +
				"  st.store_name " +
				" FROM c4j_items it " +
				" INNER JOIN c4j_stores st on st.store_id = it.store_id " +
				" INNER JOIN c4j_users us on us.user_id = it.user_id " +
				" INNER JOIN c4j_items_type tp on tp.type_id = it.type_id ";
				 

		
		@SuppressWarnings("unchecked")
		List<ItemDTO> l = getJdbcTemplate().query(sql, rowMapper);

		return l;
	}
	
	/*
	 * Entity Row Mapper.
	 */
	class ItemMapper implements RowMapper {

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			StoreDTO store = new StoreDTO();
			store.setStoreId(rs.getInt("store_id"));
			store.setStoreName(rs.getString("store_name"));
			
			UserDTO user = new UserDTO();
			user.setUserId(rs.getLong("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setEmailAddress(rs.getString("email_address"));
			user.setLastName(rs.getString("lastname"));
			user.setFirstName(rs.getString("firstname"));
			
			TypeDTO type = new TypeDTO();
			type.setTypeId(rs.getInt("type_id"));
			type.setTypeName(rs.getString("type_name"));
			type.setTypeDesc(rs.getString("type_desc"));
			
			ItemDTO item = new ItemDTO();
			item.setItemId(rs.getLong("item_id"));
			item.setItemTitle(rs.getString("item_title"));
			item.setItemDesc(rs.getString("item_desc"));
			item.setItemPrice(rs.getDouble("item_price"));
			item.setCreated(rs.getDate("created"));
			item.setStatus(rs.getInt("status"));
			item.setItemSku(rs.getString("item_sku"));
			
			item.setStore(store);
			item.setUser(user);
			item.setType(type);

			return item;
		}
		
	}

}
