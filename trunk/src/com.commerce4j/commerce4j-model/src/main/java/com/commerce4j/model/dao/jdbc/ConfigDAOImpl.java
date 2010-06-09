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

import com.commerce4j.model.dao.ConfigDAO;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author carlos.quijano
 */
public class ConfigDAOImpl extends JdbcDaoSupport implements ConfigDAO {

    /*
     */
    public String findById(String param) {
        String sql = "SELECT config_value FROM c4j_config " +
                "WHERE config_id = ?";
        return (String) getJdbcTemplate().queryForObject(sql, String.class);

    }

}
