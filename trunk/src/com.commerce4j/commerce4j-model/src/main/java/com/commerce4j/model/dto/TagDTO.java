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
public class TagDTO {

	private ItemDTO item;
	private String tag;
	
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
	 * JavaBean Getter, Gets the tag current value.
	 * @return The tag current value.
	 */
	public String getTag() {
		return tag;
	}
	/**
	 * JavaBean Setter, Sets value to tag.
	 * @param tag The value of tag to set.
	 */
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	
	
}
