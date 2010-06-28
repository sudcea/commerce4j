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

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.commerce4j.model.dao.UserDAO;
import com.commerce4j.model.dto.CategoryDTO;
import com.commerce4j.model.dto.HelpDTO;
import com.commerce4j.model.dto.UserDTO;

import com.mysql.jdbc.*;

/**
 * Home Page MultiAction Controller.
 * 
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
		
	/**
	 * Home Action, this is the default action.
	 * 
	 * @param request The {@link HttpServletRequest} object for this action.
	 * @param response The {@link HttpServletResponse} object for this action.
	 * @return The {@link ModelAndView} instance for this action.
	 */
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		
		// declare locales
		Map<String, Object> model;
		List<CategoryDTO> categories;
		
		// init locals
		model = new HashMap<String, Object>();
		categories = getCategoryDSO().findRootCategories(1);
		
		// find the store categories 
		if (categories != null && !categories.isEmpty()) {
			model.put("categories", categories);
		}

		// return mav
		return new ModelAndView("home", model);
	}
	
	/**
	 * Welcome Action, welcomes new users to the store
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) {
		
		// declare locales
		ModelAndView mav = home(request, response);
		
		// init locals
		String uid = request.getParameter("uid");
		if (StringUtils.isNotEmpty(uid) && StringUtils.isNumeric(uid)) {
			Integer userId = new Integer(uid);
			UserDAO userDAO = (UserDAO) getBean("userDAO");
			UserDTO userDTO = userDAO.findById(userId);
			mav.addObject("user", userDTO);
		}

		// return mav
		return mav;
	}

        /**
         * Help Action, Helps the new User or Viewer by FAQ's
         *
         */
        public ModelAndView help(HttpServletRequest request, HttpServletResponse response){
            Map<String, Object> model;

            model = new HashMap<String, Object>();
            List<HelpDTO> help = getHelpDso().findAllFaqs();
            if(help != null && !help.isEmpty())
            {
                model.put("help", help);
            }
            return new ModelAndView("help", model);

        }


}
