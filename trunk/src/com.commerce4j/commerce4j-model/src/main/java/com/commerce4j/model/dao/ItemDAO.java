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
package com.commerce4j.model.dao;

import java.util.List;

import com.commerce4j.model.dto.CategoryDTO;
import com.commerce4j.model.dto.ItemDTO;

/**
 * Data Access Object for the {@link ItemDTO} entity.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public interface ItemDAO {
	
	public ItemDTO findById(Integer itemId);
	
	/**
	 * Get a {@link ItemDTO} entity list by it's category.
	 * 
	 * @param categoryId The {@link CategoryDTO} primary key.
	 * @return A {@link ItemDTO} entity list or <code>null</code>.
	 */
	public List<ItemDTO> findAllByCategory(Integer categoryId);
	
	
	public List<ItemDTO> findAllByLastAddition(Integer categoryId, Integer max, Integer first);
	
}
