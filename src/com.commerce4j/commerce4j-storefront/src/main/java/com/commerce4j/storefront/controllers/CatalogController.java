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

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.web.servlet.ModelAndView;

import com.commerce4j.model.dso.ItemDSO;
import com.commerce4j.model.dto.CategoryDTO;
import com.commerce4j.model.dto.ItemDTO;
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
		
		return mav ;
	}
	
	public ModelAndView detail(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("detail");
		
		// browse categories by parent
		String sItemId = request.getParameter("item");
		if (StringUtils.isNotEmpty(sItemId)) {
			Integer itemId = new Integer(sItemId);
			
			
			// display product listing
			ItemDSO itemDSO = (ItemDSO) getApplicationContext().getBean("itemDSO");
			ItemDTO itemDTO = itemDSO.findById(itemId);
			mav.addObject("item", itemDTO);
			
			
			// verify images
			String sql = "SELECT COUNT(*) from c4j_items_images  " +
			"WHERE item_id = ?";
			Object[] params = {itemId};
			int numOfImages = getJdbcTemplate().queryForInt(sql, params);
			mav.addObject("numOfImages", numOfImages);
			
		}
		
		return mav ;
	}
	
	
	public void lastAddedItems(
			HttpServletRequest request, HttpServletResponse response
	) {


		Map<String, Object> responseModel = new HashMap<String, Object>();
		response.setContentType("application/json");	
		Gson gson = new GsonBuilder().create();
		
		String sFirst = request.getParameter("first");
		String sMax = request.getParameter("max");
		
		ItemDSO itemDSO = (ItemDSO) getApplicationContext().getBean("itemDSO");
		List<ItemDTO> lastItems = itemDSO.findAllByLastAddition(null, new Integer(sMax), new Integer(sFirst));
		

		responseModel.put("responseCode", SUCCESS);
		responseModel.put("responseMessage", "Login Completo");
		responseModel.put("listings", lastItems);
		
		// serialize output
		try {

			OutputStreamWriter os = new OutputStreamWriter(response.getOutputStream());
			String data = gson.toJson(responseModel);
			os.write(data);
			os.flush();
			os.close();
		} catch (IOException e) {
			logger.fatal(e);
		}
	}
	
		
	
	public void image(HttpServletRequest request, HttpServletResponse response) 
	throws IOException {
		
		
		
		// browse categories by parent
		String sItemId = request.getParameter("item");
		String sImageIndex = request.getParameter("image");
		if (StringUtils.isNotEmpty(sItemId) && StringUtils.isNotEmpty(sImageIndex)) {
			Integer itemId = new Integer(sItemId);
			Integer imageIndex = new Integer(sImageIndex);
			
			
			String sql = "SELECT COUNT(*) from c4j_items_images  " +
			"WHERE item_id = ?";
			int numOfImages = getJdbcTemplate().queryForInt(sql, new Object[] {itemId});
			if (numOfImages > 0) {
				sql = "SELECT image_data from c4j_items_images  " +
						"WHERE item_id = ? and image_index = ?";
				byte[] bytes = (byte[]) getJdbcTemplate().queryForObject(
					sql, new Object[] {itemId, imageIndex}, new RowMapper() {
					final DefaultLobHandler lobHandler = new DefaultLobHandler();
					public byte[] mapRow(ResultSet rs, int rowNum)
					throws SQLException {					
			            return lobHandler.getBlobAsBytes(rs, "image_data"); 
					}
					
				});
				response.setContentType("image/jpeg");
				for (int i = 0; i < bytes.length; i++) {
			        response.getOutputStream().write(bytes[i]);
			    }
			}
			
		}
		
		
	}
	

}
