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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import javax.xml.transform.TransformerException;

import junit.framework.TestCase;

import com.commerce4j.model.dto.CountryDTO;
import com.commerce4j.model.dto.StoreDTO;
import com.commerce4j.model.dto.UserDTO;
import com.commerce4j.storefront.model.RegistrationInfo;
import com.thoughtworks.xstream.XStream;

/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class MailTemplateTest extends TestCase {
	
	/**
	 * @throws IOException 
	 * @throws TransformerException 
	 * 
	 */
	public void testWelcomeTemplate() throws IOException, TransformerException {
		
		
		UserDTO user = new UserDTO();
		user.setActive(1);
		user.setCellPhone("78778030");
		user.setCountry(new CountryDTO(1, "SV", "El Salvador"));
		user.setCreationDate(new Date());
		user.setEmailAddress("carlos.quijano@gmail.com");
		user.setFirstName("Carlos");
		user.setLastName("Quijano");
		user.setUserName("cquijano");
		
		StoreDTO store = new StoreDTO();
		store.setStoreId(1);
		store.setStoreName("Commerce4J StoreFront");
		store.setStoreUrl("http://www.commerce4j.org/");
		
		RegistrationInfo info = new RegistrationInfo();
		info.setUser(user);
		info.setStore(store);
		info.setUrl("http://localhost/13asdasdasdsdas");


		try {
                    XStream xstream = new XStream();
                    File xmlFile = File.createTempFile("user", "xml");
                    xstream.alias("registration", RegistrationInfo.class);
                    xstream.toXML(info, new FileOutputStream(xmlFile));
                    System.out.println(xstream.toXML(info));

                    javax.xml.transform.Source xmlSource;
                    javax.xml.transform.Source xsltSource;
                    javax.xml.transform.Result result;

                    xmlSource = new javax.xml.transform.stream.StreamSource(
                            xmlFile
                    );

                    xsltSource =
                            new javax.xml.transform.stream.StreamSource(
                            getClass().getResourceAsStream("/templates/welcome_mail.xsl")
                    );
                    
                    result = new javax.xml.transform.stream.StreamResult(
                            System.out
                    );

                    // create an instance of TransformerFactory
                    javax.xml.transform.TransformerFactory transFact =
                            javax.xml.transform.TransformerFactory.newInstance();

                    javax.xml.transform.Transformer trans =
                            transFact.newTransformer(xsltSource);

                    trans.transform(xmlSource, result);
                    
                } catch (Exception e) {

                }
		
	}
	
	
	

}
