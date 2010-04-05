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
public class CurrencyDTO extends AbstractBaseDTO {
	
	private Integer currencyId;
	private String currencyName;
	private String currencySymbol;
	private String currencyAbrev;
	
	/**
	 * JavaBean Getter, Gets the currencyId current value.
	 * @return The currencyId current value.
	 */
	public Integer getCurrencyId() {
		return currencyId;
	}
	/**
	 * JavaBean Setter, Sets value to currencyId.
	 * @param currencyId The value of currencyId to set.
	 */
	public void setCurrencyId(Integer currencyId) {
		this.currencyId = currencyId;
	}
	/**
	 * JavaBean Getter, Gets the currencyName current value.
	 * @return The currencyName current value.
	 */
	public String getCurrencyName() {
		return currencyName;
	}
	/**
	 * JavaBean Setter, Sets value to currencyName.
	 * @param currencyName The value of currencyName to set.
	 */
	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	/**
	 * JavaBean Getter, Gets the currencySymbol current value.
	 * @return The currencySymbol current value.
	 */
	public String getCurrencySymbol() {
		return currencySymbol;
	}
	/**
	 * JavaBean Setter, Sets value to currencySymbol.
	 * @param currencySymbol The value of currencySymbol to set.
	 */
	public void setCurrencySymbol(String currencySymbol) {
		this.currencySymbol = currencySymbol;
	}
	/**
	 * JavaBean Getter, Gets the currencyAbrev current value.
	 * @return The currencyAbrev current value.
	 */
	public String getCurrencyAbrev() {
		return currencyAbrev;
	}
	/**
	 * JavaBean Setter, Sets value to currencyAbrev.
	 * @param currencyAbrev The value of currencyAbrev to set.
	 */
	public void setCurrencyAbrev(String currencyAbrev) {
		this.currencyAbrev = currencyAbrev;
	}
	
	

}
