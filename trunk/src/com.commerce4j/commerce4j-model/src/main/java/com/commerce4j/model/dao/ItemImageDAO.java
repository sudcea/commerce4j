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

/**
 *  Data Access Object for item image management.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public interface ItemImageDAO {
	
	/**
	 * Check if the item image exists, by it's key.
	 * 
	 * @param itemId The Item unique key.
	 * @param imageIndex The Image index.
	 * @return <code>true</code> if exists, <code>false</code> otherwise.
	 */
	public boolean exists(Integer itemId, Integer imageIndex);
	
	/**
	 * Get the image bytes array, by it's key.
	 * 
	 * 
	 * @param itemId he Item unique key.
	 * @param imageIndex The Image index.
	 * @return The item image byte array.
	 */
	public byte[] findImageAsBytes(Integer itemId, Integer imageIndex);
	
}
