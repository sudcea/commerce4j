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
package com.commerce4j.storefront.utils.postmark;

import com.commerce4j.storefront.utils.SendMail;
import com.postmark.java.PostmarkClient;
import com.postmark.java.PostmarkException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 * SendMail using PostMark service.
 *
 * @author carlos.quijano
 */
public class SendMailImpl implements SendMail {

    private String token;

    /**
     *
     */
    public SendMailImpl() {
       
    }

    
    public void sendMessage(String from, String[] recipients, String subject, String message)
    throws MessagingException {
        
        try {
            PostmarkClient pmClient = new PostmarkClient(token);
            pmClient.sendMessage(from, recipients[0], null, null, subject, message, true, null);
        } catch (PostmarkException ex) {
            Logger.getLogger(SendMailImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    /**
     *
     * @return
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     */
    public void setToken(String token) {
        this.token = token;
    }



}
