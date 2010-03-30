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
package com.commerce4j.model.dso;

import java.util.List;

import com.commerce4j.model.dto.CategoryDTO;

/**
 * Category Data Service Object, the business layer that manage 
 * all the category operations.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public interface CategoryDSO {
	
	/**
	 * Get a {@link CategoryDTO} entity object by it's primary key.
	 * 
	 * @param categoryId The entity primary key
	 * @return A {@link CategoryDTO} entity object or <code>null</code>.
	 */
	public CategoryDTO findCategoryById(Integer categoryId);
	
	/**
	 * Get a root {@link CategoryDTO} list by store. A category is 
	 * considered root when it's parent id is null or empty.
	 * 
	 * @param storeId The store primary key.
	 * @return A {@link CategoryDTO} root entity list or <code>null</code>.
	 */
	public List<CategoryDTO> findRootCategories(Integer storeId);
	
	/**
	 * Get a child {@link CategoryDTO} list by store and parent.
	 * @return A {@link CategoryDTO} child entity list or <code>null</code>.
	 */
	public List<CategoryDTO> findCategoriesByParent(Integer storeId, Integer categoryId);
	
}
