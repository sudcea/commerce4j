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

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * Abstract Base Data Transfer Object. This object is designed
 * in order to serve as a parent for DTO's child objects.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public abstract class AbstractBaseDTO {
	
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
            return ToStringBuilder.reflectionToString(this);
    }
	
}
