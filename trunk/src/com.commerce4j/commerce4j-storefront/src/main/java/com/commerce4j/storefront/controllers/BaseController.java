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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.commerce4j.model.dso.CategoryDSO;
import com.commerce4j.model.dso.ProfileDSO;
import com.commerce4j.model.dto.CartDTO;


/**
 * Abstract Base MultiActionController.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public abstract class BaseController extends MultiActionController {
	
	static final String SUCCESS = "success";
	static final String FAILURE = "failure";
	static final ResourceBundle bundle = ResourceBundle.getBundle("i18n");
	
	private JdbcTemplate jdbcTemplate;
	private CategoryDSO categoryDSO;
	private ProfileDSO profileDSO;
	

	/**
	 * @param request
	 * @param response
	 * @return
	 */
	protected abstract ModelAndView unspecified(HttpServletRequest request, HttpServletResponse response);
	
	/**
	 * JavaBean Getter, Gets the jdbcTemplate current value.
	 * @return The jdbcTemplate current value.
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * JavaBean Setter, Sets value to jdbcTemplate.
	 * @param jdbcTemplate The value of jdbcTemplate to set.
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * JavaBean Getter, Gets the categoryDSO current value.
	 * @return The categoryDSO current value.
	 */
	public CategoryDSO getCategoryDSO() {
		return categoryDSO;
	}

	/**
	 * JavaBean Setter, Sets value to categoryDSO.
	 * @param categoryDSO The value of categoryDSO to set.
	 */
	public void setCategoryDSO(CategoryDSO categoryDSO) {
		this.categoryDSO = categoryDSO;
	}

	/**
	 * JavaBean Getter, Gets the profileDSO current value.
	 * @return The profileDSO current value.
	 */
	public ProfileDSO getProfileDSO() {
		return profileDSO;
	}

	/**
	 * JavaBean Setter, Sets value to profileDSO.
	 * @param profileDSO The value of profileDSO to set.
	 */
	public void setProfileDSO(ProfileDSO profileDSO) {
		this.profileDSO = profileDSO;
	}
	
	protected String getString(String key) {
		return bundle.getString(key);
	}
	
	/**
	 * @param request
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected List<CartDTO> getCart(HttpServletRequest request) {
		// check cart in session
		if (request.getSession().getAttribute("cart") == null) {
			request.getSession().setAttribute("cart", new ArrayList<CartDTO>());
		}
		return (List<CartDTO>) request.getSession().getAttribute("cart");
	}
	
	/**
	 * @param key
	 * @param value
	 * @return
	 */
	protected Message newError(String key, String value) {
		return new Message("ERROR", key, value);
	}
	
	protected Message newError(String key, String value, Object[] replace) {
		return new Message("ERROR", key, MessageFormat.format(value, replace));
	}
	
	

	
	class Message {
		private String key;
		private String type;
		private String value;
		
		
		/**
		 * Constructor, Creates a new type instance of Message.
		 * @param key
		 * @param type
		 * @param value
		 */
		public Message(String type, String key, String value) {
			super();
			this.key = key;
			this.type = type;
			this.value = value;
		}
		/**
		 * JavaBean Getter, Gets the key current value.
		 * @return The key current value.
		 */
		public String getKey() {
			return key;
		}
		/**
		 * JavaBean Setter, Sets value to key.
		 * @param key The value of key to set.
		 */
		public void setKey(String key) {
			this.key = key;
		}
		/**
		 * JavaBean Getter, Gets the type current value.
		 * @return The type current value.
		 */
		public String getType() {
			return type;
		}
		/**
		 * JavaBean Setter, Sets value to type.
		 * @param type The value of type to set.
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * JavaBean Getter, Gets the value current value.
		 * @return The value current value.
		 */
		public String getValue() {
			return value;
		}
		/**
		 * JavaBean Setter, Sets value to value.
		 * @param value The value of value to set.
		 */
		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
	
	
	
}
