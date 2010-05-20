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

import com.commerce4j.model.dto.TagCountDTO;
import com.commerce4j.model.dto.TagDTO;

/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public interface TagDAO {
	
	/**
	 * Find all tags sorted by name for a particular Item. 
	 * 
	 * @param itemId The item primary key.
	 * @return A {@link TagDTO} entity list or <code>null</code> if empty. 
	 */
	public List<TagDTO> findAllTagsByItem(Integer itemId);
	
	/**
	 * @return
	 */
	public List<TagCountDTO> countAllTagsByName();
}
