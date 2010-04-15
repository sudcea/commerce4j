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
package com.commerce4j.model.dso.jdbc;

import java.util.List;

import com.commerce4j.model.dao.ItemDAO;
import com.commerce4j.model.dso.ItemDSO;
import com.commerce4j.model.dto.ItemDTO;

/**
 * JDBC Implementation for the {@link ItemDSO} business object.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class ItemDSOImpl implements ItemDSO {
	
	private ItemDAO itemDAO;
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dso.ItemDSO#findById(java.lang.Integer)
	 */
	public ItemDTO findById(Integer itemId) {
		return itemDAO.findById(itemId);
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.model.dso.ItemDSO#findAllByCategory(java.lang.Integer)
	 */
	public List<ItemDTO> findAllByCategory(Integer categoryId) {
		return itemDAO.findAllByCategory(categoryId);
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dso.ItemDSO#findAllByLastAddition(java.lang.Integer)
	 */
	public List<ItemDTO> findAllByLastAddition(Integer categoryId, Integer max, Integer first) {
		// TODO Auto-generated method stub
		return itemDAO.findAllByLastAddition(categoryId, max, first);
	}

	/**
	 * JavaBean Getter, Gets the itemDAO current value.
	 * @return The itemDAO current value.
	 */
	public ItemDAO getItemDAO() {
		return itemDAO;
	}

	/**
	 * JavaBean Setter, Sets value to itemDAO.
	 * @param itemDAO The value of itemDAO to set.
	 */
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	

	
	
	

}
