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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.commerce4j.model.dto.CategoryDTO;

/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class HomeController extends BaseController {
	
	

	
	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.controllers.BaseController#unspecified(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView unspecified(HttpServletRequest request, HttpServletResponse response) {
		return home(request,response);
	}
	
	
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> model = new HashMap<String, Object>();
		List<CategoryDTO> categories = getCategoryDSO().findRootCategories(1);
		
		if (categories != null && !categories.isEmpty())
			model.put("categories", categories);
		
		return new ModelAndView("home", model);
	}
	
	



	
	
	
	
	
}
