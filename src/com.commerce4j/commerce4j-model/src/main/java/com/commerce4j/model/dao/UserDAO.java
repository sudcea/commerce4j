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

import com.commerce4j.model.dto.UserDTO;

/**
 * Data Access Object for the {@link UserDTO} entity.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public interface UserDAO {
	
	/**
	 * Get a {@link UserDTO} entity object by it's primary key.
	 * 
	 * @param userId The {@link UserDTO} primary key.
	 * @return A {@link UserDTO} entity object or <code>null</code>
	 */
	public UserDTO findById(long userId);
	
	/**
	 * Saves a new {@link UserDTO} in the persistence layer.
	 * 
	 * @param userDTO The {@link UserDTO} instance to insert.
	 * @return The {@link UserDTO} persisted instance.
	 */
	public UserDTO save(UserDTO userDTO);

        /**
	 * Updates a existent {@link UserDTO} in the persistence layer.
	 *
	 * @param userDTO The {@link UserDTO} instance to update.
	 * @return The {@link UserDTO} persisted instance.
	 */
	public UserDTO update(UserDTO userDTO);

	/**
	 * Count number of users by username.
	 * 
	 * @param userName The userName to count for.
	 * @return The number of users by user name.
	 */
	public Integer countByUserName(String userName);
	
	/**
	 * Count number of users by email.
	 * @param eMail The eMail to count for. 
	 * @return The number of users by email address.
	 */
	public Integer countByEmail(String eMail);
	
}
