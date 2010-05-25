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
package com.commerce4j.storefront.model;

import java.util.Date;

import com.commerce4j.model.dto.StoreDTO;
import com.commerce4j.model.dto.UserDTO;
import java.io.Serializable;
/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class RegistrationInfo implements Serializable {
	
	/**
	 * Serial UID. 
	 */
	private static final long serialVersionUID = 4701928455796218557L;
	
	private UserDTO user;
	private StoreDTO store;
	private String url;
	private Date created;
	

	/**
	 * JavaBean Getter, Gets the created current value.
	 * @return The created current value.
	 */
	public Date getCreated() {
		return created;
	}
	/**
	 * JavaBean Setter, Sets value to created.
	 * @param created The value of created to set.
	 */
	public void setCreated(Date created) {
		this.created = created;
	}
	/**
	 * JavaBean Getter, Gets the user current value.
	 * @return The user current value.
	 */
	public UserDTO getUser() {
		return user;
	}
	/**
	 * JavaBean Setter, Sets value to user.
	 * @param user The value of user to set.
	 */
	public void setUser(UserDTO user) {
		this.user = user;
	}
	/**
	 * JavaBean Getter, Gets the url current value.
	 * @return The url current value.
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * JavaBean Setter, Sets value to url.
	 * @param url The value of url to set.
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * JavaBean Getter, Gets the store current value.
	 * @return The store current value.
	 */
	public StoreDTO getStore() {
		return store;
	}
	/**
	 * JavaBean Setter, Sets value to store.
	 * @param store The value of store to set.
	 */
	public void setStore(StoreDTO store) {
		this.store = store;
	}
	
	
}
