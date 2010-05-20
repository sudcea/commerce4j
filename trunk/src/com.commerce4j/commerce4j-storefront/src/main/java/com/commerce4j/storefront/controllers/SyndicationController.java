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

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.commerce4j.model.dao.BrandDAO;
import com.commerce4j.model.dao.TagDAO;
import com.commerce4j.model.dso.ItemDSO;
import com.commerce4j.model.dto.BrandDTO;
import com.commerce4j.model.dto.CategoryDTO;
import com.commerce4j.model.dto.ItemDTO;
import com.commerce4j.model.dto.TagCountDTO;
import com.commerce4j.storefront.web.CatalogSyndication;
import com.commerce4j.storefront.web.StoreSyndication;

/**
 * Syndication Controller, implements most of the Store API synditacion methods.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class SyndicationController extends BaseController 
implements StoreSyndication<ModelAndView>, CatalogSyndication<ModelAndView>{

	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.controllers.BaseController#unspecified(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected ModelAndView unspecified(HttpServletRequest request, HttpServletResponse response) {
		return version(request, response);
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.web.StoreSyndication#version(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView version(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("jsonView");
		
		mav.addObject("name", getString("c4j.module.name"));
		mav.addObject("version", getString("c4j.module.version"));
		mav.addObject("timestamp", System.currentTimeMillis());
		
		return mav;
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.web.CatalogSyndication#findAllCategoriesRecursively(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView findAllCategoriesRecursively(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("jsonView");
		
		List<CategoryDTO> categories = new LinkedList<CategoryDTO>();
		getCategoryDSO().fetchChildrenByParent(categories, 1, null);
		
		// add data to model
		mav.addObject("responseCode", SUCCESS);
		mav.addObject("responseMessage", "Login Completo");
		mav.addObject("categories", categories);
		
		return mav;
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.web.CatalogSyndication#findLastAddedItems(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView findLastAddedItems(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("jsonView");
		
		String sFirst = request.getParameter("first");
		String sMax = request.getParameter("max");
		
		ItemDSO itemDSO = (ItemDSO) getApplicationContext().getBean("itemDSO");
		List<ItemDTO> lastItems = itemDSO.findAllByLastAddition(null, new Integer(sMax), new Integer(sFirst));
		
		// add data to model
		mav.addObject("responseCode", SUCCESS);
		mav.addObject("responseMessage", "Login Completo");
		mav.addObject("listings", lastItems);
		
		return mav;
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.web.CatalogSyndication#findFeaturedBrands(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView findFeaturedBrands(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("jsonView");
		
		BrandDAO brandDAO = (BrandDAO) getApplicationContext().getBean("brandDAO");
		List<BrandDTO> brands = brandDAO.findAllFeatured();
		

		mav.addObject("responseCode", SUCCESS);
		mav.addObject("responseMessage", "Login Completo");
		mav.addObject("brands", brands);
		
		return mav;
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.web.CatalogSyndication#countAllTagsByName(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView countAllTagsByName(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("jsonView");
		
		TagDAO tagDAO = (TagDAO) getApplicationContext().getBean("tagDAO");
		List<TagCountDTO> tags = tagDAO.countAllTagsByName();
		

		mav.addObject("responseCode", SUCCESS);
		mav.addObject("responseMessage", "Login Completo");
		mav.addObject("tags", tags);
		
		return mav;
	}
	
	
	

}
