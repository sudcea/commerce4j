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
package com.commerce4j.storefront.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Store API, global store related web syndication.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 * @param <M> The parameterized return model type.
 */
public interface StoreSyndication<M> {

	/**
	 * Get's the store name, version and timestamp information.
	 * 
	 * @param request The {@link HttpServletRequest} object for this action.
	 * @param response The {@link HttpServletResponse} object for this action.
	 * @return The store name, version and timestamp information.
	 */
	public M version(HttpServletRequest request, HttpServletResponse response);
	
	
}
