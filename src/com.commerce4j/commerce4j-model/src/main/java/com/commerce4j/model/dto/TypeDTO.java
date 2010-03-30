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
 * Item Type Data Transfer Object.
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class TypeDTO extends AbstractBaseDTO {
	
	private Integer typeId;
	private String typeName;
	private String typeDesc;
	

	/**
	 * Constructor, Creates a new type instance of {@link TypeDTO}.
	 */
	public TypeDTO() {
		super();
	}
	
	
	
	/**
	 * Constructor, Creates a new type instance of {@link TypeDTO}.
	 * 
	 * @param typeId
	 * @param typeName
	 * @param typeDesc
	 */
	public TypeDTO(Integer typeId, String typeName, String typeDesc) {
		super();
		
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeDesc = typeDesc;
	}



	/**
	 * JavaBean Getter, Gets the typeId current value.
	 * @return The typeId current value.
	 */
	public Integer getTypeId() {
		return typeId;
	}
	/**
	 * JavaBean Setter, Sets value to typeId.
	 * @param typeId The value of typeId to set.
	 */
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	/**
	 * JavaBean Getter, Gets the typeName current value.
	 * @return The typeName current value.
	 */
	public String getTypeName() {
		return typeName;
	}
	/**
	 * JavaBean Setter, Sets value to typeName.
	 * @param typeName The value of typeName to set.
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	/**
	 * JavaBean Getter, Gets the typeDesc current value.
	 * @return The typeDesc current value.
	 */
	public String getTypeDesc() {
		return typeDesc;
	}
	/**
	 * JavaBean Setter, Sets value to typeDesc.
	 * @param typeDesc The value of typeDesc to set.
	 */
	public void setTypeDesc(String typeDesc) {
		this.typeDesc = typeDesc;
	}
	
	
	
}
