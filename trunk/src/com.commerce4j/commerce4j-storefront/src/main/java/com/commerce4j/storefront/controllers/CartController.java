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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.commerce4j.model.dso.ItemDSO;
import com.commerce4j.model.dto.CartDTO;
import com.commerce4j.model.dto.ItemDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class CartController extends BaseController {

	private ItemDSO itemDSO;
	
	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.controllers.BaseController#unspecified(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView unspecified(HttpServletRequest request, HttpServletResponse response) {
		return cart(request,response);
	}
	
	
	/**
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView cart(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("cart");
		
		
		return mav;
	}
	
	/**
	 * @param request
	 * @param response
	 */
	public void add(HttpServletRequest request, HttpServletResponse response) {
		
			
		Gson gson = new GsonBuilder().create();
		List<Message> errors = new ArrayList<Message>();
		Map<String, Object> responseModel = new HashMap<String, Object>();
		
		
		String item = request.getParameter("item");
		String quantity = request.getParameter("quantity");
		
		if (StringUtils.isEmpty(item)) {
			errors.add(newError("item", getString("errors.notEmpty"), new Object[] {"item"}));
		}
		
		// find item
		ItemDTO itemDTO = itemDSO.findById(new Integer(item));
		if (item == null)
			errors.add(newError("item", getString("errors.notEmpty"), new Object[] {"item"}));
		
		// check cart in session
		if (request.getSession().getAttribute("cart") == null) {
			request.getSession().setAttribute("cart", new ArrayList<CartDTO>());
		}
		@SuppressWarnings("unchecked")
		List<CartDTO> cartEntries = (List<CartDTO>) request.getSession().getAttribute("cart");
		
		// create cart entry
		String cartId = request.getSession().getId();
		Integer iQuantity = new Integer(quantity);
		Double subtotal = itemDTO.getItemPrice() * iQuantity;
		CartDTO cartDTO = new CartDTO(cartId, itemDTO, iQuantity, subtotal);
		cartEntries.add(cartDTO);
		
		// persist session
		request.getSession().setAttribute("cart", cartEntries);
		
		// fill response model
		if (errors.isEmpty()) {
			responseModel.put("responseCode", SUCCESS);
			responseModel.put("responseMessage", "Item Added to Cart");
		} else {
			responseModel.put("responseCode", FAILURE);
			responseModel.put("responseMessage", "Error, item was not added");
			responseModel.put("errors", errors);
		}
		
	
		// serialize output
		try {
			response.setContentType("application/json");
			OutputStreamWriter os = new OutputStreamWriter(response.getOutputStream());
			String data = gson.toJson(responseModel);
			os.write(data);
			os.flush();
			os.close();
		} catch (IOException e) {
			logger.fatal(e);
		}
	}


	/**
	 * JavaBean Getter, Gets the itemDSO current value.
	 * @return The itemDSO current value.
	 */
	public ItemDSO getItemDSO() {
		return itemDSO;
	}


	/**
	 * JavaBean Setter, Sets value to itemDSO.
	 * @param itemDSO The value of itemDSO to set.
	 */
	public void setItemDSO(ItemDSO itemDSO) {
		this.itemDSO = itemDSO;
	}
	
	
	

}
