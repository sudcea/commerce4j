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
import com.commerce4j.model.dto.BrandDTO;
import com.commerce4j.model.dto.CurrencyDTO;
import com.commerce4j.model.dto.ItemDTO;
import com.commerce4j.model.dto.StatusDTO;
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
	 * @see com.commerce4j.model.dao.ItemDAO#findById(java.lang.Integer)
	 */
	public ItemDTO findById(Integer itemId) {
		String sql = "SELECT " +
		"  it.item_id, " +
		"  it.item_sku, " +
		"  it.created, " +
		"  it.item_title, " +
		"  it.item_desc, " +
		"  it.item_status, " +
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
		"  st.store_name, " +
		"  su.status_name, " +
		"  cu.currency_abrev, " +
		"  cu.currency_symbol, " +
		"  br.brand_id, " +
		"  br.brand_name, " +
		"  br.featured " +
		" FROM c4j_items it " +
		" INNER JOIN c4j_stores st on st.store_id = it.store_id " +
		" INNER JOIN c4j_users us on us.user_id = it.user_id " +
		" INNER JOIN c4j_items_type tp on tp.type_id = it.type_id " +
		" INNER JOIN c4j_currencies cu ON it.currency_id = cu.currency_id " +
		" INNER JOIN c4j_status su ON su.status_id = it.status_id " +
		" LEFT JOIN c4j_brands br ON br.brand_id = it.brand_id " +
		" WHERE it.item_id = ?";

		Integer[] params = {itemId};
		return (ItemDTO) getJdbcTemplate().queryForObject(sql, params, rowMapper);
		
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
				"  it.item_status, " +
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
				"  st.store_name, " +
				"  su.status_name, " +
				"  cu.currency_abrev, " +
				"  cu.currency_symbol, " +
				"  br.brand_id, " +
				"  br.brand_name, " +
				"  br.featured " +
				" FROM c4j_items it " +
				" INNER JOIN c4j_stores st on st.store_id = it.store_id " +
				" INNER JOIN c4j_users us on us.user_id = it.user_id " +
				" INNER JOIN c4j_items_type tp on tp.type_id = it.type_id " +
				" INNER JOIN c4j_items_categories ct ON ct.item_id = it.item_id " +
				" INNER JOIN c4j_currencies cu ON it.currency_id = cu.currency_id " +
				" INNER JOIN c4j_status su ON su.status_id = it.status_id " +
				" LEFT JOIN c4j_brands br ON br.brand_id = it.brand_id " +
				" WHERE ct.category_id = ?";


		Integer[] params = {categoryId};
		@SuppressWarnings("unchecked")
		List<ItemDTO> l = getJdbcTemplate().query(sql, params,rowMapper);

		return l;
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.ItemDAO#findAllByLastAddition(java.lang.Integer)
	 */
	public List<ItemDTO> findAllByLastAddition(Integer categoryId, Integer max, Integer first) {
		
		first = (first == null || first == 0) ? 0 : first;
		max = (max == null || max == 0) ? 4 : max;
		
		String sql = "SELECT " +
		"  it.item_id, " +
		"  it.item_sku, " +
		"  it.created, " +
		"  it.item_title, " +
		"  it.item_desc, " +
		"  it.item_status, " +
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
		"  st.store_name, " +
		"  su.status_name, " +
		"  cu.currency_abrev, " +
		"  cu.currency_symbol, " +
		"  br.brand_id, " +
		"  br.brand_name, " +
		"  br.featured " +
		" FROM c4j_items it " +
		" INNER JOIN c4j_stores st on st.store_id = it.store_id " +
		" INNER JOIN c4j_users us on us.user_id = it.user_id " +
		" INNER JOIN c4j_items_type tp on tp.type_id = it.type_id " +
		" INNER JOIN c4j_currencies cu ON it.currency_id = cu.currency_id " +
		" INNER JOIN c4j_status su ON su.status_id = it.status_id " +
		" LEFT JOIN c4j_brands br ON br.brand_id = it.brand_id " +
		" ORDER BY it.created DESC " +
		" LIMIT ?,?";

		Object[] params = {first, max};
		@SuppressWarnings("unchecked")
		List<ItemDTO> l = getJdbcTemplate().query(sql, params, rowMapper);
		
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
			
			CurrencyDTO currency  = new CurrencyDTO();
			currency.setCurrencySymbol(rs.getString("currency_symbol"));
			currency.setCurrencyAbrev(rs.getString("currency_abrev"));
			
			StatusDTO status = new StatusDTO();
			status.setStatusName(rs.getString("status_name"));
			
			BrandDTO brand = new BrandDTO();
			brand.setBrandId(rs.getInt("brand_id"));
			brand.setBrandName(rs.getString("brand_name"));
			brand.setFeatured(rs.getInt("featured"));
			
			ItemDTO item = new ItemDTO();
			item.setItemId(rs.getLong("item_id"));
			item.setItemTitle(rs.getString("item_title"));
			item.setItemDesc(rs.getString("item_desc"));
			item.setItemPrice(rs.getDouble("item_price"));
			item.setCreated(rs.getDate("created"));
			item.setItemStatus(rs.getInt("item_status"));
			item.setItemSku(rs.getString("item_sku"));
			
			
			item.setBrand(brand);
			item.setStore(store);
			item.setUser(user);
			item.setType(type);
			item.setCurrency(currency);
			item.setStatus(status);

			return item;
		}
		
	}

	

	

}
