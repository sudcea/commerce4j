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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


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

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("login");
		
		return mav;
	}
	
	public void processLogin(
			HttpServletRequest request, HttpServletResponse response
	) {


		Map<String, Object> responseModel = new HashMap<String, Object>();
		response.setContentType("application/json");	
		Gson gson = new GsonBuilder().create();

		String userName = request.getParameter("userName");
		String userPass = request.getParameter("userPass");
		
		List<Message> errors = new ArrayList<Message>();
		if (StringUtils.isEmpty(userName)) {
			errors.add(newError("userName", getString("errors.notEmpty"), new Object[] {getString("login.userName")}));
		}
		
		if (StringUtils.isEmpty(userPass)) {
			errors.add(newError("userPass", getString("errors.notEmpty"), new Object[] {getString("login.userPass")}));
		}
		
		
		if (errors.isEmpty()) {
			
			
			responseModel.put("responseCode", SUCCESS);
			responseModel.put("responseMessage", "Login Completo");
		} else {
			responseModel.put("responseCode", FAILURE);
			responseModel.put("responseMessage", "Login Incompleto, favor verificar");
			responseModel.put("errors", errors);
		}
		
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
	
	public void processRegistration(
			HttpServletRequest request, HttpServletResponse response
	) {


		Map<String, Object> responseModel = new HashMap<String, Object>();
		response.setContentType("application/json");	
		Gson gson = new GsonBuilder().create();

		String userName = request.getParameter("userName");
		String emailAddress = request.getParameter("emailAddress");
		String userPass = request.getParameter("userPass");
		String confirmPassword = request.getParameter("confirmPassword");
		String firstName = request.getParameter("firstName");
		String countryId = request.getParameter("countryId");
		String lastName = request.getParameter("lastName");
		String cellPhone = request.getParameter("cellPhone");
		String acceptTermAndConditions = request.getParameter("acceptTermAndConditions");
		
		List<Message> errors = new ArrayList<Message>();
		if (StringUtils.isEmpty(userName)) {
			errors.add(newError("userName", getString("errors.notEmpty"), new Object[] {getString("register.userName")}));
		}
		
		if (StringUtils.isEmpty(emailAddress)) {
			errors.add(newError("emailAddress", getString("errors.notEmpty"), new Object[] {getString("register.emailAddress")}));
		}
		
		if (StringUtils.isEmpty(userPass)) {
			errors.add(newError("userPass", getString("errors.notEmpty"), new Object[] {getString("register.userPass")}));
		}
		
		if (StringUtils.isEmpty(firstName)) {
			errors.add(newError("firstName", getString("errors.notEmpty"), new Object[] {getString("register.firstName")}));
		}
		
		if (StringUtils.isEmpty(cellPhone)) {
			errors.add(newError("cellPhone", getString("errors.notEmpty"), new Object[] {getString("register.cellPhone")}));
		}
		
		if (StringUtils.isEmpty(countryId)) {
			errors.add(newError("countryId", getString("errors.notEmpty"), new Object[] {getString("register.countryId")}));
		}
		
		if (StringUtils.isEmpty(lastName)) {
			errors.add(newError("lastName", getString("errors.notEmpty"), new Object[] {getString("register.lastName")}));
		}
		
		if (!StringUtils.equalsIgnoreCase(acceptTermAndConditions, "true")) {
			errors.add(newError("acceptTermAndConditions", getString("errors.acceptTermAndConditions")));
		}
		
		if (StringUtils.isEmpty(confirmPassword)) {
			errors.add(newError("confirmPassword", getString("errors.notEmpty"), new Object[] {getString("register.confirmPassword")}));
		}
		
		if (!StringUtils.equals(userPass, confirmPassword)) {
			errors.add(newError("userPass", getString("errors.passwordDoesNotMatch") ));
		}
		
		
		// validate user name
		if (!getProfileDSO().isUserValid(userName)) {
			errors.add(newError("userName", getString("errors.userAlreadyExists"), new Object[] {userName}));	
		}
		
		// validate emailAddress
		if (!getProfileDSO().isEmailValid(emailAddress)) {
			errors.add(newError("emailAddress", getString("errors.emailAlreadyExists"), new Object[] {emailAddress}));	
		}
		
		
		
		if (errors.isEmpty()) {
			
			long userId = getProfileDSO().registerUser(
					userName, userPass, 
					emailAddress, firstName,  
					lastName, cellPhone, new Integer(countryId)
			);
			
			if (logger.isDebugEnabled())
				logger.debug("REGISTERED UID @ " + userId);
			
			responseModel.put("responseCode", SUCCESS);
			responseModel.put("responseMessage", "Registro Completo");
			responseModel.put("userId", userId);
			
		} else {
			responseModel.put("responseCode", FAILURE);
			responseModel.put("responseMessage", "Registro Incompleto, favor verificar");
			responseModel.put("errors", errors);
		}
		
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
	
	

}
