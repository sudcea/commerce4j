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


/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class ProfileController extends BaseController {

	
	
	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.controllers.BaseController#unspecified(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ModelAndView unspecified(HttpServletRequest request, HttpServletResponse response) {
		return profile(request,response);
	}
	
	
	public ModelAndView profile(HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mav = new ModelAndView("profile");
		
		
		return mav;
	}
	
	@SuppressWarnings("unchecked")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("register");
		
		// user localization
		java.util.Locale locale = request.getLocale();
		String iso3country = locale.getISO3Country();
		if (StringUtils.isNotEmpty(iso3country)) {
			if (logger.isDebugEnabled()) logger.debug(iso3country);
			mav.addObject("iso3country",iso3country);
		}
		
		String sql ="Select * From c4j_countries Order By country_name";
		List countries = getJdbcTemplate().queryForList(sql);
		mav.addObject("countries",countries);
		
		return mav;
	}
	
	
	public ModelAndView completeRegistration(
			HttpServletRequest request, HttpServletResponse response
	) {

		
		String userName = request.getParameter("userName");
		String emailAddress = request.getParameter("emailAddress");
		String userPass = request.getParameter("userPass");
		String firstName = request.getParameter("firstName");
		Integer countryId = new Integer(request.getParameter("countryId"));
		String lastName = request.getParameter("lastName");
		
		long userId = getProfileDSO().registerUser(
				userName, userPass, 
				emailAddress, firstName, 
				lastName, countryId
		);
		if (logger.isDebugEnabled())
			logger.debug("REGISTERED UID @ " + userId);
		
		return register(request, response);
	}
	
	

}
