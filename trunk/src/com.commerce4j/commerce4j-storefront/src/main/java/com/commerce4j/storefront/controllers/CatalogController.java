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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.commerce4j.model.dao.BrandDAO;
import com.commerce4j.model.dao.ItemDAO;
import com.commerce4j.model.dao.ItemImageDAO;
import com.commerce4j.model.dao.TagDAO;
import com.commerce4j.model.dso.ItemDSO;
import com.commerce4j.model.dto.BrandDTO;
import com.commerce4j.model.dto.CategoryDTO;
import com.commerce4j.model.dto.ItemDTO;
import com.commerce4j.model.dto.TagDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


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
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView all(HttpServletRequest request, HttpServletResponse response) {
	
		return new ModelAndView("catalog");
	}
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView browse(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("catalog");
		Integer storeId = 1;
		
		// browse categories by parent
		String sCategoryId = request.getParameter("c");
		String tag = request.getParameter("tag");
		
		// find by category
		if (StringUtils.isNotEmpty(sCategoryId)) {
			Integer categoryId = new Integer(sCategoryId);
			CategoryDTO category = getCategoryDSO().findCategoryById(categoryId);
			List<CategoryDTO> categories = getCategoryDSO().findCategoriesByParent(storeId, categoryId);
			mav.addObject("category", category);
			mav.addObject("categories", categories);
			if (categories == null || categories.isEmpty()) {
				mav.addObject("categories", null);	
			}
			
			// display product listings
			ItemDSO itemDSO = (ItemDSO) getApplicationContext().getBean("itemDSO");
			List<ItemDTO> listings = itemDSO.findAllByCategory(categoryId);
			mav.addObject("listings", listings);
			
		}
		
		// find by tags
		if (StringUtils.isNotEmpty(tag)) {
			ItemDAO itemDAO = (ItemDAO) getApplicationContext().getBean("itemDAO");
			List<ItemDTO> listings = itemDAO.findAllByTag(tag, 10, 0);
			mav.addObject("listings", listings);
		}
		
		return mav ;
	}
	
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("detail");
		
		// browse categories by parent
		String sItemId = request.getParameter("item");
		if (StringUtils.isNotEmpty(sItemId)) {
			Integer itemId = new Integer(sItemId);
			
			
			// add item to mav
			ItemDSO itemDSO = (ItemDSO) getApplicationContext().getBean("itemDSO");
			ItemDTO itemDTO = itemDSO.findById(itemId);
			mav.addObject("item", itemDTO);
			
			// add tags to mav
			TagDAO tagDAO = (TagDAO) getApplicationContext().getBean("tagDAO");
			List<TagDTO> tags = tagDAO.findAllTagsByItem(itemId);
			mav.addObject("tags", tags);
			
			
			
		}
		
		return mav ;
	}

	
	/**
	 * @param request
	 * @param response
	 */
	public void featuredBrands(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> responseModel = new HashMap<String, Object>();
		response.setContentType(HTTP_HEADER_JSON);	
		Gson gson = new GsonBuilder().create();
		

		
		BrandDAO brandDAO = (BrandDAO) getApplicationContext().getBean("brandDAO");
		List<BrandDTO> brands = brandDAO.findAllFeatured();
		

		responseModel.put("responseCode", SUCCESS);
		responseModel.put("responseMessage", "Login Completo");
		responseModel.put("brands", brands);
		
		// serialize output
		try {

			OutputStreamWriter os = new OutputStreamWriter(response.getOutputStream(), "UTF8");
			String data = gson.toJson(responseModel);
			os.write(data);
			
			os.flush();
			os.close();
		} catch (IOException e) {
			logger.fatal(e);
		}
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void image(HttpServletRequest request, HttpServletResponse response) 
	throws IOException {

		// browse categories by parent
		String sItemId = request.getParameter("item");
		String sImageIndex = request.getParameter("image");
		if (StringUtils.isNotEmpty(sItemId) && StringUtils.isNotEmpty(sImageIndex)) {
			Integer itemId = new Integer(sItemId);
			Integer imageIndex = new Integer(sImageIndex);
			
			// verify image existence  
			ItemImageDAO itemImageDAO = (ItemImageDAO) getBean("itemImageDAO");
			
			// get image from db if exists or not available
			byte[] bytes = (
					itemImageDAO.exists(itemId, imageIndex)) ? 
					itemImageDAO.findImageAsBytes(itemId, imageIndex) : 
					getNotAvailableImage();

			// retrieve from cache and finally write bytes to response
			response.setContentType("image/jpeg");
			for (int i = 0; i < bytes.length; i++) {
		        response.getOutputStream().write(bytes[i]);
		    }
			
			
		}
		
		
	}
	
	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	public void brandImage(HttpServletRequest request, HttpServletResponse response) 
	throws IOException {
		
		// get brand dao
		BrandDAO brandDAO = (BrandDAO) getBean("brandDAO");
		
		// browse categories by parent
		String sBrandId = request.getParameter("brand");
		if (StringUtils.isNotEmpty(sBrandId)) {
			Integer brandId = new Integer(sBrandId);
			BrandDTO brandDTO = brandDAO.findById(brandId);
			if (brandDTO != null) {
				// get image from db if exists or not available
				byte[] bytes = brandDAO.findImageAsBytes(brandId);

				// retrieve from cache and finally write bytes to response
				for (int i = 0; i < bytes.length; i++) {
			        response.getOutputStream().write(bytes[i]);
			    }
			}
			
		}
		
		
	}

	
	/**
	 * @return
	 */
	protected byte[] getNotAvailableImage() {
		byte[] bytes = null;
		String path = "/images/img_not_available.png";
		File f = new File(getServletContext().getRealPath(path));
		if (f.exists()) {
			try {
				bytes = new byte[(int) f.length()];
				FileInputStream fs = new FileInputStream(f);
				fs.read(bytes);
				fs.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				if (logger.isErrorEnabled())
					logger.error(e);
			} catch (IOException e) {
				e.printStackTrace();
				if (logger.isErrorEnabled())
					logger.error(e);
			}
		}
		return bytes;
	}
	

}
