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

import java.util.Date;

/**
 * Item Data Transfer Object.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class ItemDTO extends AbstractBaseDTO {
	
	private Long itemId;
	private String itemTitle;
	private String itemDesc;
	private Date created;
	private Integer itemStatus;
	private Double itemPrice;
	private String itemSku;
	
	private UserDTO user;
	private StoreDTO store;
	private TypeDTO type;
	private CurrencyDTO currency;
	private StatusDTO status;
	private BrandDTO brand;
	
	
	
	/**
	 * JavaBean Getter, Gets the brand current value.
	 * @return The brand current value.
	 */
	public BrandDTO getBrand() {
		return brand;
	}
	/**
	 * JavaBean Setter, Sets value to brand.
	 * @param brand The value of brand to set.
	 */
	public void setBrand(BrandDTO brand) {
		this.brand = brand;
	}
	/**
	 * JavaBean Setter, Sets value to status.
	 * @param status The value of status to set.
	 */
	public void setStatus(StatusDTO status) {
		this.status = status;
	}
	/**
	 * JavaBean Getter, Gets the currency current value.
	 * @return The currency current value.
	 */
	public CurrencyDTO getCurrency() {
		return currency;
	}
	/**
	 * JavaBean Setter, Sets value to currency.
	 * @param currency The value of currency to set.
	 */
	public void setCurrency(CurrencyDTO currency) {
		this.currency = currency;
	}
	/**
	 * JavaBean Getter, Gets the itemSku current value.
	 * @return The itemSku current value.
	 */
	public String getItemSku() {
		return itemSku;
	}
	/**
	 * JavaBean Setter, Sets value to itemSku.
	 * @param itemSku The value of itemSku to set.
	 */
	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
	}
	/**
	 * JavaBean Getter, Gets the itemId current value.
	 * @return The itemId current value.
	 */
	public Long getItemId() {
		return itemId;
	}
	/**
	 * JavaBean Setter, Sets value to itemId.
	 * @param itemId The value of itemId to set.
	 */
	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}
	/**
	 * JavaBean Getter, Gets the itemTitle current value.
	 * @return The itemTitle current value.
	 */
	public String getItemTitle() {
		return itemTitle;
	}
	/**
	 * JavaBean Setter, Sets value to itemTitle.
	 * @param itemTitle The value of itemTitle to set.
	 */
	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}
	/**
	 * JavaBean Getter, Gets the itemDesc current value.
	 * @return The itemDesc current value.
	 */
	public String getItemDesc() {
		return itemDesc;
	}
	/**
	 * JavaBean Setter, Sets value to itemDesc.
	 * @param itemDesc The value of itemDesc to set.
	 */
	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
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
	 * JavaBean Getter, Gets the itemStatus current value.
	 * @return The itemStatus current value.
	 */
	public Integer getItemStatus() {
		return itemStatus;
	}
	/**
	 * JavaBean Setter, Sets value to itemStatus.
	 * @param itemStatus The value of itemStatus to set.
	 */
	public void setItemStatus(Integer itemStatus) {
		this.itemStatus = itemStatus;
	}
	/**
	 * JavaBean Getter, Gets the status current value.
	 * @return The status current value.
	 */
	public StatusDTO getStatus() {
		return status;
	}
	/**
	 * JavaBean Getter, Gets the itemPrice current value.
	 * @return The itemPrice current value.
	 */
	public Double getItemPrice() {
		return itemPrice;
	}
	/**
	 * JavaBean Setter, Sets value to itemPrice.
	 * @param itemPrice The value of itemPrice to set.
	 */
	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
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
	 * JavaBean Getter, Gets the type current value.
	 * @return The type current value.
	 */
	public TypeDTO getType() {
		return type;
	}
	/**
	 * JavaBean Setter, Sets value to type.
	 * @param type The value of type to set.
	 */
	public void setType(TypeDTO type) {
		this.type = type;
	}
	
	

}
