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
 * Category Data Transfer Object.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class CategoryDTO extends AbstractBaseDTO {
	
	private Integer categoryId;
	private String description;
	private String tooltip;
	private CategoryDTO parent;
	private Integer status;
	private StoreDTO store;
	
	
	
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
	/**
	 * JavaBean Getter, Gets the categoryId current value.
	 * @return The categoryId current value.
	 */
	public Integer getCategoryId() {
		return categoryId;
	}
	/**
	 * JavaBean Setter, Sets value to categoryId.
	 * @param categoryId The value of categoryId to set.
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	/**
	 * JavaBean Getter, Gets the tooltip current value.
	 * @return The tooltip current value.
	 */
	public String getTooltip() {
		return tooltip;
	}
	/**
	 * JavaBean Setter, Sets value to tooltip.
	 * @param tooltip The value of tooltip to set.
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	/**
	 * JavaBean Getter, Gets the parent current value.
	 * @return The parent current value.
	 */
	public CategoryDTO getParent() {
		return parent;
	}
	/**
	 * JavaBean Setter, Sets value to parent.
	 * @param parent The value of parent to set.
	 */
	public void setParent(CategoryDTO parent) {
		this.parent = parent;
	}
	/**
	 * JavaBean Getter, Gets the status current value.
	 * @return The status current value.
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * JavaBean Setter, Sets value to status.
	 * @param status The value of status to set.
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
