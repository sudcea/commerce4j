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
 * User Data Transfer Object.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class UserDTO {
	
    private Long userId;
    private String userName;
    private String userPass;
    private String emailAddress;
    private String firstName;
    private String lastName;
    private CountryDTO country;
    private Date creationDate;
    private Integer active;
    private String cellPhone;

    private String guid;

    /**
     * Constructor, Creates a new type instance of UserDTO.
     */
    public UserDTO() {
            super();
    }

    /**
     * JavaBean Getter, Gets the userId current value.
     * @return The userId current value.
     */
    public Long getUserId() {
            return userId;
    }

    /**
     * JavaBean Setter, Sets value to userId.
     * @param userId The value of userId to set.
     */
    public void setUserId(Long userId) {
            this.userId = userId;
    }

    /**
     * JavaBean Getter, Gets the userName current value.
     * @return The userName current value.
     */
    public String getUserName() {
            return userName;
    }

    /**
     * JavaBean Setter, Sets value to userName.
     * @param userName The value of userName to set.
     */
    public void setUserName(String userName) {
            this.userName = userName;
    }

    /**
     * JavaBean Getter, Gets the userPass current value.
     * @return The userPass current value.
     */
    public String getUserPass() {
            return userPass;
    }

    /**
     * JavaBean Setter, Sets value to userPass.
     * @param userPass The value of userPass to set.
     */
    public void setUserPass(String userPass) {
            this.userPass = userPass;
    }

    /**
     * JavaBean Getter, Gets the emailAddress current value.
     * @return The emailAddress current value.
     */
    public String getEmailAddress() {
            return emailAddress;
    }

    /**
     * JavaBean Setter, Sets value to emailAddress.
     * @param emailAddress The value of emailAddress to set.
     */
    public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
    }

    /**
     * JavaBean Getter, Gets the firstName current value.
     * @return The firstName current value.
     */
    public String getFirstName() {
            return firstName;
    }

    /**
     * JavaBean Setter, Sets value to firstName.
     * @param firstName The value of firstName to set.
     */
    public void setFirstName(String firstName) {
            this.firstName = firstName;
    }

    /**
     * JavaBean Getter, Gets the lastName current value.
     * @return The lastName current value.
     */
    public String getLastName() {
            return lastName;
    }

    /**
     * JavaBean Setter, Sets value to lastName.
     * @param lastName The value of lastName to set.
     */
    public void setLastName(String lastName) {
            this.lastName = lastName;
    }

    /**
     * JavaBean Getter, Gets the country current value.
     * @return The country current value.
     */
    public CountryDTO getCountry() {
            return country;
    }

    /**
     * JavaBean Setter, Sets value to country.
     * @param country The value of country to set.
     */
    public void setCountry(CountryDTO country) {
            this.country = country;
    }

    /**
     * JavaBean Getter, Gets the creationDate current value.
     * @return The creationDate current value.
     */
    public Date getCreationDate() {
            return creationDate;
    }

    /**
     * JavaBean Setter, Sets value to creationDate.
     * @param creationDate The value of creationDate to set.
     */
    public void setCreationDate(Date creationDate) {
            this.creationDate = creationDate;
    }

    /**
     * JavaBean Getter, Gets the active current value.
     * @return The active current value.
     */
    public Integer getActive() {
            return active;
    }

    /**
     * JavaBean Setter, Sets value to active.
     * @param active The value of active to set.
     */
    public void setActive(Integer active) {
            this.active = active;
    }

    /**
     * @return the cellPhone
     */
    public String getCellPhone() {
            return cellPhone;
    }

    /**
     * @param cellPhone the cellPhone to set
     */
    public void setCellPhone(String cellPhone) {
            this.cellPhone = cellPhone;
    }

    /**
     * @return the guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * @param guid the guid to set
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }
		
}
