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
package com.commerce4j.model.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.commerce4j.model.dao.UserDAO;
import com.commerce4j.model.dto.CountryDTO;
import com.commerce4j.model.dto.UserDTO;

/**
 * Spring/JDBC Implementation for the {@link UserDAO} interface.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class UserDAOImpl extends JdbcDaoSupport implements UserDAO {
	
	private RowMapper userRowMapper;
	
	/**
	 * Constructor, Creates a new type instance of {@link UserDAOImpl}.
	 */
	public UserDAOImpl() {
		super();
		userRowMapper = new UserRowMapper();
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.UserDAO#findById(long)
	 */
	public UserDTO findById(long userId) {
		
		String sql = "SELECT " +
				"u.user_id,u.user_name, u.user_pass, u.email_address,u.firstname, " +
				"u.lastname,u.creation_date,u.active,u.cell_phone, " +
				"c.country_id,c.iso,c.country_name,user_guid " +
				"FROM c4j_users u " +
				"INNER JOIN c4j_countries c ON c.country_id = u.country_id " +
				"WHERE user_id = ?";		
		
		Long[] params = {userId};
		return (UserDTO) getJdbcTemplate().queryForObject(sql, params, userRowMapper);
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.UserDAO#countByUserName(java.lang.String)
	 */
	public Integer countByUserName(String userName) {
		
		String sql = "SELECT COUNT(*) FROM c4j_users WHERE user_name = ?";
		return getJdbcTemplate().queryForInt(sql, new Object[] {userName});
		
	}
	
	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.UserDAO#countByEmail(java.lang.String)
	 */
	public Integer countByEmail(String eMail) {
		
		String sql = "SELECT COUNT(*) FROM c4j_users WHERE email_address = ?";
		return getJdbcTemplate().queryForInt(sql, new Object[] {eMail});
		
	}

	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.UserDAO#save(com.commerce4j.model.dto.UserDTO)
	 */
	public UserDTO save(UserDTO userDTO) {

		String sql = "INSERT INTO c4j_users   " +
		"(user_name, user_pass, email_address,firstname," +
		"lastname,cell_phone,country_id,creation_date,user_guid, active)  " +
		"values (?,?,?,?,?,?,?,?,?,?)";
		
		// build the SQL Update parameters
		Object params[] = {
                    userDTO.getUserName(),
                    userDTO.getUserPass(),
                    userDTO.getEmailAddress(),
                    userDTO.getFirstName(),
                    userDTO.getLastName(),
                    userDTO.getCellPhone(),
                    userDTO.getCountry().getCountryId(),
                    new Date(),
                    // added guid
                    userDTO.getGuid(),
                    userDTO.getActive()
		};
                

                
		// we're going to use a SqlUpdate helper in order
		// to retrieve the populated last insert id after
		// the sql update.
		SqlUpdate su = new SqlUpdate();
		su.setDataSource(getDataSource());
		su.setSql(sql);
		su.declareParameter(new SqlParameter(Types.VARCHAR));
		su.declareParameter(new SqlParameter(Types.VARCHAR));
		su.declareParameter(new SqlParameter(Types.VARCHAR));
		su.declareParameter(new SqlParameter(Types.VARCHAR));
		su.declareParameter(new SqlParameter(Types.VARCHAR));
		su.declareParameter(new SqlParameter(Types.VARCHAR));
		su.declareParameter(new SqlParameter(Types.INTEGER));
		su.declareParameter(new SqlParameter(Types.TIMESTAMP));
                su.declareParameter(new SqlParameter(Types.VARCHAR));
		su.declareParameter(new SqlParameter(Types.SMALLINT));
		su.setReturnGeneratedKeys(true);
		su.compile();
		
		// get the generated key
		KeyHolder keyHolder = new GeneratedKeyHolder();
		su.update(params, keyHolder);
		long userId = keyHolder.getKey().longValue();

		if (userId > 0) {
			userDTO = findById(userId);
		}
		
		return userDTO;
	}


	/* (non-Javadoc)
	 * @see com.commerce4j.model.dao.UserDAO#save(com.commerce4j.model.dto.UserDTO)
	 */
	public UserDTO update(UserDTO userDTO) {

            String sql = "UPDATE c4j_users   " +
            "SET user_name = ?, user_pass = ?, " +
            "email_address = ?,firstname = ?," +
            "lastname = ?,cell_phone = ?,country_id = ?,user_guid = ?, active = ?  " +
            "WHERE user_id = ? ";

            // update user
            Object[] args = {
                userDTO.getUserName(),
                userDTO.getUserPass(),
                userDTO.getEmailAddress(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getCellPhone(),
                userDTO.getCountry().getCountryId(),
                userDTO.getGuid(),
                userDTO.getActive(),
                userDTO.getUserId()
            };
            getJdbcTemplate().update(sql, args);

            return findById(userDTO.getUserId());
        }
        
	/*
	 * Entity RowMapper 
	 */
	class UserRowMapper implements RowMapper {

		/* (non-Javadoc)
		 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
		 */
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			
			CountryDTO country = new CountryDTO();
			country.setCountryId(rs.getInt("country_id"));
			country.setCountryName(rs.getString("country_name"));
			country.setIso(rs.getString("iso"));
			
			UserDTO user = new UserDTO();
			user.setUserId(rs.getLong("user_id"));
			user.setUserName(rs.getString("user_name"));
			user.setUserPass(rs.getString("user_pass"));
			user.setEmailAddress(rs.getString("email_address"));
			user.setLastName(rs.getString("lastname"));
			user.setFirstName(rs.getString("firstname"));
			user.setActive(rs.getInt("active"));
			user.setCreationDate(rs.getTimestamp("creation_date"));
			user.setCellPhone(rs.getString("cell_phone"));
                        user.setGuid(rs.getString("user_guid"));
			return user;
		}
		
	}

}
