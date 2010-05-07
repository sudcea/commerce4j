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
package com.commerce4j.model.dso.jdbc;

import com.commerce4j.model.dao.UserDAO;
import com.commerce4j.model.dso.ProfileDSO;
import com.commerce4j.model.dto.CountryDTO;
import com.commerce4j.model.dto.UserDTO;

/**
 * JDBC Implementation for the {@link ProfileDSO} business object.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class ProfileDSOImpl implements ProfileDSO {

	private UserDAO userDAO;
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dso.ProfileDSO#registerUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer)
	 */
	public Long registerUser(
			String userName, String userPass,
			String emailAddress, String firstName, String lastName,
			Integer countryId
	) {
		
		CountryDTO country = new CountryDTO();
		country.setCountryId(countryId);
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserName(userName);
		userDTO.setUserPass(userPass);
		userDTO.setEmailAddress(emailAddress);
		userDTO.setFirstName(firstName);
		userDTO.setLastName(lastName);
		userDTO.setActive(1);
		userDTO.setCountry(country);
		
		userDTO = userDAO.save(userDTO);
		
		
		return userDTO.getUserId();
	}

	/**
	 * JavaBean Getter, Gets the userDAO current value.
	 * @return The userDAO current value.
	 */
	public UserDAO getUserDAO() {
		return userDAO;
	}

	/**
	 * JavaBean Setter, Sets value to userDAO.
	 * @param userDAO The value of userDAO to set.
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	

}
