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
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class CountryDTO {
	private Integer countryId;
	private String iso;
	private String countryName;
	
	
	/**
	 * Constructor, Creates a new type instance of CountryDTO.
	 */
	public CountryDTO() {
		super();
	}
	
	
	/**
	 * Constructor, Creates a new type instance of CountryDTO.
	 * @param countryId
	 * @param iso
	 * @param countryName
	 */
	public CountryDTO(Integer countryId, String iso, String countryName) {
		super();
		this.countryId = countryId;
		this.iso = iso;
		this.countryName = countryName;
	}


	/**
	 * JavaBean Getter, Gets the countryId current value.
	 * @return The countryId current value.
	 */
	public Integer getCountryId() {
		return countryId;
	}
	/**
	 * JavaBean Setter, Sets value to countryId.
	 * @param countryId The value of countryId to set.
	 */
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	/**
	 * JavaBean Getter, Gets the iso current value.
	 * @return The iso current value.
	 */
	public String getIso() {
		return iso;
	}
	/**
	 * JavaBean Setter, Sets value to iso.
	 * @param iso The value of iso to set.
	 */
	public void setIso(String iso) {
		this.iso = iso;
	}
	/**
	 * JavaBean Getter, Gets the countryName current value.
	 * @return The countryName current value.
	 */
	public String getCountryName() {
		return countryName;
	}
	/**
	 * JavaBean Setter, Sets value to countryName.
	 * @param countryName The value of countryName to set.
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	
}
