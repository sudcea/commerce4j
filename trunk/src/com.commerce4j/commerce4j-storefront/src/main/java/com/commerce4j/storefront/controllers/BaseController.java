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
package com.commerce4j.storefront.controllers;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.commerce4j.model.dso.CategoryDSO;
import com.commerce4j.model.dso.HelpDSO;
import com.commerce4j.model.dso.ItemDSO;
import com.commerce4j.model.dso.ProfileDSO;
import com.commerce4j.model.dso.jdbc.HelpDSOImpl;
import com.commerce4j.model.dto.CartDTO;
import java.io.InputStream;
import java.io.Writer;


/**
 * Abstract Base MultiActionController.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public abstract class BaseController extends MultiActionController {
	
	/**
	 * Action Success default constant string.
	 */
	public static final String SUCCESS = "success";
	
	/**
	 * Action Failure default constant string.
	 */
	public static final String FAILURE = "failure";
	
	/**
	 * HTTP Header for the JSON encoding.
	 */
	public static final String HTTP_HEADER_JSON =  "application/json";
	
	/**
	 * Web Application Resource Bundle instance.
	 */
	public static final ResourceBundle bundle = ResourceBundle.getBundle("i18n");
	
	
	
	private JdbcTemplate jdbcTemplate;
	private CategoryDSO categoryDSO;
	private ProfileDSO profileDSO;
	private ItemDSO itemDSO;
        private HelpDSO helpDso;
	
	/**
	 * Constructor, Creates a new type instance of BaseController.
	 */
	public BaseController() {
		super();
	}
	
	/**
	 * Default unspecified action, any multiaction controller must 
	 * have a default.
	 * 
	 * @param request The {@link HttpServletRequest} object for this action.
	 * @param response The {@link HttpServletResponse} object for this action.
	 * @return The {@link ModelAndView} instance for this action.
	 */
	protected abstract ModelAndView unspecified(
			HttpServletRequest request, HttpServletResponse response
	);
	
	/**
	 * Get a String from ResourceBundle.
	 * 
	 * @param key The key to look the String for.
	 * @return A String value object from the resource bundle. 
	 */
	protected String getString(String key) {
		return bundle.getString(key);
	}
	
	/**
	 * Get a Bean from the Application Context.
	 * 
	 * @param id The bean identifier.
	 * @return The requested bean object.
	 */
	protected Object getBean(String id) {
		return getWebApplicationContext().getBean(id);
	}
	
	/**
	 * Get the current session shopping cart. If no is yet available
	 * then an empty cart is returned.
	 * 
	 * @param request The {@link HttpServletRequest} object for this action.
	 * @return The current session shopping cart list.
	 */
	@SuppressWarnings("unchecked")
	protected List<CartDTO> getCart(HttpServletRequest request) {
		
		// check cart in session
		if (request.getSession().getAttribute("cart") == null) {
			request.getSession().setAttribute("cart", new ArrayList<CartDTO>());
		}
		
		return (List<CartDTO>) request.getSession().getAttribute("cart");
	}

        protected void xslTransform(InputStream xml, InputStream xsl, Writer out) 
        throws TransformerConfigurationException, TransformerException {
            // create sources
            javax.xml.transform.Source xmlSource = new javax.xml.transform.stream.StreamSource(xml);
            javax.xml.transform.Source xsltSource = new javax.xml.transform.stream.StreamSource(xsl);
            javax.xml.transform.Result result = new javax.xml.transform.stream.StreamResult(out);
            // create an instance of TransformerFactory
            javax.xml.transform.TransformerFactory transFact = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer trans = transFact.newTransformer(xsltSource);
            trans.transform(xmlSource, result);
        }
	
	/**
	 * Creates a new Error {@link Message} object. This object is used
	 * to wrap a key-value message object.
	 * 
	 * @param key The message unique key. 
	 * @param value The message value.
	 * @return A new Error {@link Message} object.
	 */
	protected Message newError(String key, String value) {
		return new Message("ERROR", key, value);
	}
	
	/**
	 * Creates a new Error {@link Message} object. This object is used
	 * to wrap a key-value message object.
	 * 
	 * @param key The message unique key. 
	 * @param value The message value.
	 * @param replace The message replace values.
	 * @return
	 */
	protected Message newError(String key, String value, Object[] replace) {
		return new Message("ERROR", key, MessageFormat.format(value, replace));
	}

	/**
	 * Message Object Simple Implementation.
	 */
	class Message {
		
		private String key;
		private String type;
		private String value;
		
		
		/**
		 * Constructor, Creates a new type instance of Message.
		 * 
		 * @param key The message unique key.
		 * @param type The message type.
		 * @param value The message value.
		 */
		public Message(String type, String key, String value) {
			super();
			this.key = key;
			this.type = type;
			this.value = value;
		}
		
		/**
		 * JavaBean Getter, Gets the key current value.
		 * @return The key current value.
		 */
		public String getKey() {
			return key;
		}
		/**
		 * JavaBean Setter, Sets value to key.
		 * @param key The value of key to set.
		 */
		public void setKey(String key) {
			this.key = key;
		}
		/**
		 * JavaBean Getter, Gets the type current value.
		 * @return The type current value.
		 */
		public String getType() {
			return type;
		}
		/**
		 * JavaBean Setter, Sets value to type.
		 * @param type The value of type to set.
		 */
		public void setType(String type) {
			this.type = type;
		}
		/**
		 * JavaBean Getter, Gets the value current value.
		 * @return The value current value.
		 */
		public String getValue() {
			return value;
		}
		/**
		 * JavaBean Setter, Sets value to value.
		 * @param value The value of value to set.
		 */
		public void setValue(String value) {
			this.value = value;
		}
		
		
	}
	
	/**
	 * JavaBean Getter, Gets the jdbcTemplate current value.
	 * @return The jdbcTemplate current value.
	 */
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * JavaBean Setter, Sets value to jdbcTemplate.
	 * @param jdbcTemplate The value of jdbcTemplate to set.
	 */
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * JavaBean Getter, Gets the categoryDSO current value.
	 * @return The categoryDSO current value.
	 */
	public CategoryDSO getCategoryDSO() {
		return categoryDSO;
	}

	/**
	 * JavaBean Setter, Sets value to categoryDSO.
	 * @param categoryDSO The value of categoryDSO to set.
	 */
	public void setCategoryDSO(CategoryDSO categoryDSO) {
		this.categoryDSO = categoryDSO;
	}

	/**
	 * JavaBean Getter, Gets the profileDSO current value.
	 * @return The profileDSO current value.
	 */
	public ProfileDSO getProfileDSO() {
		return profileDSO;
	}

	/**
	 * JavaBean Setter, Sets value to profileDSO.
	 * @param profileDSO The value of profileDSO to set.
	 */
	public void setProfileDSO(ProfileDSO profileDSO) {
		this.profileDSO = profileDSO;
	}
	
	/**
	 * JavaBean Getter, Gets the itemDSO current value.
	 * @return The itemDSO current value.
	 */
	public ItemDSO getItemDSO() {
		return itemDSO;
	}

	/**
	 * JavaBean Setter, Sets value to itemDSO.
	 * @param itemDSO The value of itemDSO to set.
	 */
	public void setItemDSO(ItemDSO itemDSO) {
		this.itemDSO = itemDSO;
	}

    public HelpDSO getHelpDso() {
        return helpDso;
    }

    public void setHelpDso(HelpDSO helpDso) {
        this.helpDso = helpDso;
    }
        

	
}
