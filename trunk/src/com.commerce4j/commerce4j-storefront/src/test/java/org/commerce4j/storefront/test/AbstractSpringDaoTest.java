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

import org.springframework.test.AbstractTransactionalDataSourceSpringContextTests;

/**
 *
 * @author Ignatiues
 */
public abstract class AbstractSpringDaoTest extends
		AbstractTransactionalDataSourceSpringContextTests
	{

		private C4jDBHelper c4jDbHelper;

		protected String[] getConfigLocations()
			{
				return new String[] { "applicationContextTest.xml" };
			}

		/*
		 * (non-Javadoc)
		 *
		 * @see
		 * org.springframework.test.AbstractTransactionalSpringContextTests#
		 * onSetUpInTransaction()
		 */
		@Override
		protected void onSetUpInTransaction() throws Exception
			{
				// TODO Auto-generated method stub
				// super.onSetUpInTransaction();
				setTemplatesInTransaction();
				c4jDbHelper = new C4jDBHelper(jdbcTemplate);
				System.out.println("Calling clear Database()");
				c4jDbHelper.clearDatabase();

			}

		private void setTemplatesInTransaction()
			{
				// TODO Auto-generated method stub

			}

	}
