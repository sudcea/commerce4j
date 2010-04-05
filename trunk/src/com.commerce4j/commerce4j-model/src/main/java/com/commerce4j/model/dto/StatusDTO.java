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
public class StatusDTO {
	private Integer statusId;
	private String statusName;
	/**
	 * JavaBean Getter, Gets the statusId current value.
	 * @return The statusId current value.
	 */
	public Integer getStatusId() {
		return statusId;
	}
	/**
	 * JavaBean Setter, Sets value to statusId.
	 * @param statusId The value of statusId to set.
	 */
	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}
	/**
	 * JavaBean Getter, Gets the statusName current value.
	 * @return The statusName current value.
	 */
	public String getStatusName() {
		return statusName;
	}
	/**
	 * JavaBean Setter, Sets value to statusName.
	 * @param statusName The value of statusName to set.
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	
}
