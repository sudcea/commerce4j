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
package com.commerce4j.model.dao;

import java.util.List;

import com.commerce4j.model.dto.BrandDTO;

/**
 * Data Access Object for the {@link BrandDTO} entity.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public interface BrandDAO {

	/**
	 * Get a {@link BrandDTO} entity object by it's primary key.
	 * 
	 * @param brandId The brand primary key.
	 * @return The brand DTO or null.
	 */
	public BrandDTO findById(Integer brandId);
	
	/**
	 * Find all brands.
	 * 
	 * @return A brand List object.
	 */
	public List<BrandDTO> findAll();
	
	/**
	 * Find all featured brands.
	 * 
	 * @return All featured brands List object.
	 */
	public List<BrandDTO> findAllFeatured();
	
	
	/**
	 * Get the brand image bytes array, by it's key.
	 * 
	 * @param brandId The brand unique key.
	 * @return The brand image byte array.
	 */
	public byte[] findImageAsBytes(Integer brandId);
}
