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

package org.commerce4j.storefront.test;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Ignatiues
 */
public class C4jDBHelper {

	private JdbcTemplate jdbcTemplate;

	/**
	 * @param jdbcTemplate
	 */
	public C4jDBHelper(JdbcTemplate jdbcTemplate) {
		// super();
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Clears the database. Deletes all data from all tables.
	 */
	public void clearDatabase() {
		System.out.println("+++++++++++++++++++++++" + this.toString());

		// jdbcTemplate.update("update c4j_stores set store_id =22 ");
		// jdbcTemplate.update("update c4j_categories set store_id = ''");
		// jdbcTemplate.update("update c4j_items set item_id = null");
		// jdbcTemplate.update("update c4j_items_categories set category_id = null");
		// this.jdbcTemplate.update("update c4j_items_categories set item_id = null");

		this.jdbcTemplate.batchUpdate(new String[] {
				"delete from c4j_blocks",
				"delete from c4j_brands",
				"delete from c4j_cart",
				// "delete from c4j_stores",
				// "delete from c4j_categories",
				"delete from c4j_config",
				"delete from c4j_countries",
				"delete from c4j_currencies",
				"delete from c4j_help",
				// "delete from c4j_items",
				"delete from c4j_items_categories",
				"delete from c4j_items_comments",
				"delete from c4j_items_images", "delete from c4j_items_rating",
				"delete from c4j_items_tags", "delete from c4j_items_type",
				"delete from c4j_states", "delete from c4j_status",
				"delete from c4j_users", "delete from c4j_users_messages" });
	}

}
