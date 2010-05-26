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
package com.commerce4j.storefront.utils.gmail;

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.commerce4j.storefront.utils.SendMail;

/**
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class SendMailImpl implements SendMail {
	
	private static final String SMTP_HOST_NAME = "smtp.gmail.com";
	private static final String SMTP_PORT = "465";
	private static final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	
	private String username;
	private String password;

	/* (non-Javadoc)
	 * @see com.commerce4j.storefront.utils.SendMail#sendMessage(java.lang.String, java.lang.String[], java.lang.String, java.lang.String)
	 */
	public void sendMessage(
			String from, String recipients[], 
			String subject, String message 
	) throws MessagingException {
		
		// Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		boolean debug = true;

		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_HOST_NAME);
		props.put("mail.smtp.auth", "true");
		props.put("mail.debug", "true");
		props.put("mail.smtp.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.port", SMTP_PORT);
		props.put("mail.smtp.socketFactory.class", SSL_FACTORY);
		props.put("mail.smtp.socketFactory.fallback", "false");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		session.setDebug(debug);
		Message msg = new MimeMessage(session);
		InternetAddress addressFrom = new InternetAddress(from);
		msg.setFrom(addressFrom);

		InternetAddress[] addressTo = new InternetAddress[recipients.length];
		for (int i = 0; i < recipients.length; i++) {
			addressTo[i] = new InternetAddress(recipients[i]);
		}
		msg.setRecipients(Message.RecipientType.TO, addressTo);

		// Setting the Subject and Content Type
		msg.setSubject(subject);
		msg.setContent(message, "text/html");
		Transport.send(msg);
	}

	/**
	 * JavaBean Getter, Gets the username current value.
	 * @return The username current value.
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * JavaBean Setter, Sets value to username.
	 * @param username The value of username to set.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * JavaBean Getter, Gets the password current value.
	 * @return The password current value.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * JavaBean Setter, Sets value to password.
	 * @param password The value of password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

}
