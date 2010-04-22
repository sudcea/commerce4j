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
 * Brand Data Transfer Object.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class BrandDTO extends AbstractBaseDTO {
	
	private Integer brandId;
	private String brandName;
	private Integer featured;
	
	
	
	/**
	 * JavaBean Getter, Gets the brandId current value.
	 * @return The brandId current value.
	 */
	public Integer getBrandId() {
		return brandId;
	}
	/**
	 * JavaBean Setter, Sets value to brandId.
	 * @param brandId The value of brandId to set.
	 */
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	/**
	 * JavaBean Getter, Gets the brandName current value.
	 * @return The brandName current value.
	 */
	public String getBrandName() {
		return brandName;
	}
	/**
	 * JavaBean Setter, Sets value to brandName.
	 * @param brandName The value of brandName to set.
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	/**
	 * JavaBean Getter, Gets the featured current value.
	 * @return The featured current value.
	 */
	public Integer getFeatured() {
		return featured;
	}
	/**
	 * JavaBean Setter, Sets value to featured.
	 * @param featured The value of featured to set.
	 */
	public void setFeatured(Integer featured) {
		this.featured = featured;
	}
	
	

}
