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
public class TagCountDTO {

	private TagDTO tag;
	private Integer counter;

	/**
	 * Constructor, Creates a new type instance of TagCloudDTO.
	 * @param tag
	 * @param counter
	 */
	public TagCountDTO(TagDTO tag, Integer counter) {
		super();
		this.tag = tag;
		this.counter = counter;
	}
	
	/**
	 * JavaBean Getter, Gets the tag current value.
	 * @return The tag current value.
	 */
	public TagDTO getTag() {
		return tag;
	}
	/**
	 * JavaBean Setter, Sets value to tag.
	 * @param tag The value of tag to set.
	 */
	public void setTag(TagDTO tag) {
		this.tag = tag;
	}
	/**
	 * JavaBean Getter, Gets the counter current value.
	 * @return The counter current value.
	 */
	public Integer getCounter() {
		return counter;
	}
	/**
	 * JavaBean Setter, Sets value to counter.
	 * @param counter The value of counter to set.
	 */
	public void setCounter(Integer counter) {
		this.counter = counter;
	}
	
	
}
