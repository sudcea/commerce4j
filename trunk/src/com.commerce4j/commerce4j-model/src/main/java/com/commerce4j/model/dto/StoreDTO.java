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
package com.commerce4j.model.dto;

/**
 * Store Data Transfer Object.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class StoreDTO extends AbstractBaseDTO {
	
	private Integer storeId;
	private String description;
	private String storeName;
	private String storeUrl;
	
	
	
	/**
	 * JavaBean Getter, Gets the storeUrl current value.
	 * @return The storeUrl current value.
	 */
	public String getStoreUrl() {
		return storeUrl;
	}
	/**
	 * JavaBean Setter, Sets value to storeUrl.
	 * @param storeUrl The value of storeUrl to set.
	 */
	public void setStoreUrl(String storeUrl) {
		this.storeUrl = storeUrl;
	}
	/**
	 * JavaBean Getter, Gets the storeName current value.
	 * @return The storeName current value.
	 */
	public String getStoreName() {
		return storeName;
	}
	/**
	 * JavaBean Setter, Sets value to storeName.
	 * @param storeName The value of storeName to set.
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	/**
	 * JavaBean Getter, Gets the storeId current value.
	 * @return The storeId current value.
	 */
	public Integer getStoreId() {
		return storeId;
	}
	/**
	 * JavaBean Setter, Sets value to storeId.
	 * @param storeId The value of storeId to set.
	 */
	public void setStoreId(Integer storeId) {
		this.storeId = storeId;
	}
	/**
	 * JavaBean Getter, Gets the description current value.
	 * @return The description current value.
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * JavaBean Setter, Sets value to description.
	 * @param description The value of description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
