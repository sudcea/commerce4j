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
package com.commerce4j.storefront.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.commerce4j.model.dso.ItemDSO;
import com.commerce4j.model.dto.CategoryDTO;
import com.commerce4j.model.dto.ItemDTO;


/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class CatalogController extends BaseController  {

	
	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.controllers.BaseController#unspecified(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView unspecified(HttpServletRequest request, HttpServletResponse response) {
		return all(request,response);
	}
	
	public ModelAndView all(HttpServletRequest request, HttpServletResponse response) {
	
		return new ModelAndView("catalog");
	}
	
	public ModelAndView browse(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("catalog");
		Integer storeId = 1;
		
		// browse categories by parent
		String sCategoryId = request.getParameter("c");
		if (StringUtils.isNotEmpty(sCategoryId)) {
			Integer categoryId = new Integer(sCategoryId);
			CategoryDTO category = getCategoryDSO().findCategoryById(categoryId);
			List<CategoryDTO> categories = getCategoryDSO().findCategoriesByParent(storeId, categoryId);
			mav.addObject("category", category);
			mav.addObject("categories", categories);
			
			
			// display product listings
			ItemDSO itemDSO = (ItemDSO) getApplicationContext().getBean("itemDSO");
			List<ItemDTO> listings = itemDSO.findAllByCategory(categoryId);
			mav.addObject("listings", listings);
			
		}
		
		return mav ;
	}
	

}
