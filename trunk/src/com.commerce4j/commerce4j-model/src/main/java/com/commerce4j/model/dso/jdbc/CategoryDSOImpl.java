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

import com.commerce4j.model.dao.CategoryDAO;
import com.commerce4j.model.dso.CategoryDSO;
import com.commerce4j.model.dto.CategoryDTO;

/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class CategoryDSOImpl implements CategoryDSO {
	
	private CategoryDAO categoryDAO;
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dso.CategoryDSO#findRootCategories()
	 */
	public List<CategoryDTO> findRootCategories(Integer storeId) {
		return categoryDAO.findCategoryByParent(storeId, null);
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dso.CategoryDSO#findCategoriesByParent(java.lang.Integer, java.lang.Integer)
	 */
	public List<CategoryDTO> findCategoriesByParent(Integer storeId, Integer categoryId) {
		return categoryDAO.findCategoryByParent(storeId, categoryId);
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.model.dso.CategoryDSO#findCategoryById(java.lang.Integer)
	 */
	public CategoryDTO findCategoryById(Integer categoryId) {
		return categoryDAO.findByCategoryById(categoryId);
	}

	/**
	 * JavaBean Getter, Gets the categoryDAO current value.
	 * @return The categoryDAO current value.
	 */
	public CategoryDAO getCategoryDAO() {
		return categoryDAO;
	}

	/**
	 * JavaBean Setter, Sets value to categoryDAO.
	 * @param categoryDAO The value of categoryDAO to set.
	 */
	public void setCategoryDAO(CategoryDAO categoryDAO) {
		this.categoryDAO = categoryDAO;
	}

	
	
	

}
