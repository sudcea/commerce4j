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
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class CartDTO {
	private String cartId;
	private ItemDTO item;
	private Integer cartQuantity;
	private Double cartSubTotal;
	private Date dateAdded;
	
	
	
	/**
	 * Constructor, Creates a new type instance of CartDTO.
	 * @param item
	 * @param cartQuantity
	 * @param cartSubTotal
	 */
	public CartDTO(String cartId, ItemDTO item, Integer cartQuantity, Double cartSubTotal) {
		super();
		this.cartId = cartId;
		this.item = item;
		this.cartQuantity = cartQuantity;
		this.cartSubTotal = cartSubTotal;
		this.dateAdded = new Date();
	}
	
	/**
	 * JavaBean Getter, Gets the cartId current value.
	 * @return The cartId current value.
	 */
	public String getCartId() {
		return cartId;
	}
	/**
	 * JavaBean Setter, Sets value to cartId.
	 * @param cartId The value of cartId to set.
	 */
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	/**
	 * JavaBean Getter, Gets the item current value.
	 * @return The item current value.
	 */
	public ItemDTO getItem() {
		return item;
	}
	/**
	 * JavaBean Setter, Sets value to item.
	 * @param item The value of item to set.
	 */
	public void setItem(ItemDTO item) {
		this.item = item;
	}
	/**
	 * JavaBean Getter, Gets the cartQuantity current value.
	 * @return The cartQuantity current value.
	 */
	public Integer getCartQuantity() {
		return cartQuantity;
	}
	/**
	 * JavaBean Setter, Sets value to cartQuantity.
	 * @param cartQuantity The value of cartQuantity to set.
	 */
	public void setCartQuantity(Integer cartQuantity) {
		this.cartQuantity = cartQuantity;
	}
	/**
	 * JavaBean Getter, Gets the cartSubTotal current value.
	 * @return The cartSubTotal current value.
	 */
	public Double getCartSubTotal() {
		return cartSubTotal;
	}
	/**
	 * JavaBean Setter, Sets value to cartSubTotal.
	 * @param cartSubTotal The value of cartSubTotal to set.
	 */
	public void setCartSubTotal(Double cartSubTotal) {
		this.cartSubTotal = cartSubTotal;
	}
	/**
	 * JavaBean Getter, Gets the dateAdded current value.
	 * @return The dateAdded current value.
	 */
	public Date getDateAdded() {
		return dateAdded;
	}
	/**
	 * JavaBean Setter, Sets value to dateAdded.
	 * @param dateAdded The value of dateAdded to set.
	 */
	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}
	
	
	
	
}
