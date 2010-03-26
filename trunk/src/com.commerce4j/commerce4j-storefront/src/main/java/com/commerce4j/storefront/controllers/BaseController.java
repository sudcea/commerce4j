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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.commerce4j.model.dso.CategoryDSO;
import com.commerce4j.model.dso.ProfileDSO;


/**
 * 
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public abstract class BaseController extends MultiActionController {
	
	static final String SUCCESS = "success";
	
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
	
	
	
}
