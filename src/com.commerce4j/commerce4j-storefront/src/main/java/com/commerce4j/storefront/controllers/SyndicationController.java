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

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import com.commerce4j.model.dao.BrandDAO;
import com.commerce4j.model.dao.ConfigDAO;
import com.commerce4j.model.dao.TagDAO;
import com.commerce4j.model.dao.UserDAO;
import com.commerce4j.model.dso.ItemDSO;
import com.commerce4j.model.dto.BrandDTO;
import com.commerce4j.model.dto.CategoryDTO;
import com.commerce4j.model.dto.ItemDTO;
import com.commerce4j.model.dto.StoreDTO;
import com.commerce4j.model.dto.TagCountDTO;
import com.commerce4j.model.dto.UserDTO;
import com.commerce4j.storefront.model.RegistrationInfo;
import com.commerce4j.storefront.utils.EmailValidator;
import com.commerce4j.storefront.utils.SendMail;
import com.commerce4j.storefront.web.CatalogSyndication;
import com.commerce4j.storefront.web.ProfileSyndication;
import com.commerce4j.storefront.web.StoreSyndication;
import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;

/**
 * Syndication Controller, implements most of the Store API synditacion methods.
 * 
 * @author carlos.quijano
 * @version $Revision$ $Date$
 */
public class SyndicationController extends BaseController
        implements
        StoreSyndication<ModelAndView>, CatalogSyndication<ModelAndView>,
        ProfileSyndication<ModelAndView> {

    /* (non-Javadoc)
     * @see com.commerce4j.storefront.controllers.BaseController#unspecified(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected ModelAndView unspecified(HttpServletRequest request, HttpServletResponse response) {
        return version(request, response);
    }

    /* (non-Javadoc)
     * @see com.commerce4j.storefront.web.StoreSyndication#version(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView version(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("jsonView");

        mav.addObject("name", getString("c4j.module.name"));
        mav.addObject("version", getString("c4j.module.version"));
        mav.addObject("timestamp", System.currentTimeMillis());

        return mav;
    }

    /* (non-Javadoc)
     * @see com.commerce4j.storefront.web.CatalogSyndication#findAllCategoriesRecursively(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView findAllCategoriesRecursively(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("jsonView");

        List<CategoryDTO> categories = new LinkedList<CategoryDTO>();
        getCategoryDSO().fetchChildrenByParent(categories, 1, null);

        // add data to model
        mav.addObject("responseCode", SUCCESS);
        mav.addObject("responseMessage", "Login Completo");
        mav.addObject("categories", categories);

        return mav;
    }

    /* (non-Javadoc)
     * @see com.commerce4j.storefront.web.CatalogSyndication#findLastAddedItems(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView findLastAddedItems(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("jsonView");

        String sFirst = request.getParameter("first");
        String sMax = request.getParameter("max");

        ItemDSO itemDSO = (ItemDSO) getApplicationContext().getBean("itemDSO");
        List<ItemDTO> lastItems = itemDSO.findAllByLastAddition(null, new Integer(sMax), new Integer(sFirst));

        // add data to model
        mav.addObject("responseCode", SUCCESS);
        mav.addObject("responseMessage", "Login Completo");
        mav.addObject("listings", lastItems);

        return mav;
    }

    /* (non-Javadoc)
     * @see com.commerce4j.storefront.web.CatalogSyndication#findFeaturedBrands(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView findFeaturedBrands(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("jsonView");

        BrandDAO brandDAO = (BrandDAO) getApplicationContext().getBean("brandDAO");
        List<BrandDTO> brands = brandDAO.findAllFeatured();


        mav.addObject("responseCode", SUCCESS);
        mav.addObject("responseMessage", "Login Completo");
        mav.addObject("brands", brands);

        return mav;
    }

    /* (non-Javadoc)
     * @see com.commerce4j.storefront.web.CatalogSyndication#countAllTagsByName(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    public ModelAndView countAllTagsByName(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("jsonView");

        TagDAO tagDAO = (TagDAO) getApplicationContext().getBean("tagDAO");
        List<TagCountDTO> tags = tagDAO.countAllTagsByName();


        mav.addObject("responseCode", SUCCESS);
        mav.addObject("responseMessage", "Login Completo");
        mav.addObject("tags", tags);

        return mav;
    }

    public ModelAndView login(
            HttpServletRequest request, HttpServletResponse response
    ) {


        ModelAndView mav = new ModelAndView("jsonView");


        String userName = request.getParameter("userName");
        String userPass = request.getParameter("userPass");

        List<Message> errors = new ArrayList<Message>();
        if (StringUtils.isEmpty(userName)) {
            errors.add(newError("userName", getString("errors.notEmpty"), new Object[]{getString("login.userName")}));
        }

        if (StringUtils.isEmpty(userPass)) {
            errors.add(newError("userPass", getString("errors.notEmpty"), new Object[]{getString("login.userPass")}));
        }


        if (errors.isEmpty()) {


            mav.addObject("responseCode", SUCCESS);
            mav.addObject("responseMessage", "Login Completo");
        } else {
            mav.addObject("responseCode", FAILURE);
            mav.addObject("responseMessage", "Login Incompleto, favor verificar");
            mav.addObject("errors", errors);
        }

        return mav;
    }

    /*
     *
     */
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mav = new ModelAndView("jsonView");

        String userName = request.getParameter("userName");
        String emailAddress = request.getParameter("emailAddress");
        String userPass = request.getParameter("userPass");
        String confirmPassword = request.getParameter("confirmPassword");
        String firstName = request.getParameter("firstName");
        String countryId = request.getParameter("countryId");
        String lastName = request.getParameter("lastName");
        String cellPhone = request.getParameter("cellPhone");
        String acceptTermAndConditions = request.getParameter("acceptTermAndConditions");

        List<Message> errors = new ArrayList<Message>();


        // validate countryId
        if (StringUtils.isBlank(countryId)) {
            errors.add(newError("countryId", getString("errors.notEmpty"), new Object[]{getString("register.countryId")}));
        }


        // validate user
        if (StringUtils.isEmpty(userName)) {
            errors.add(newError("userName", getString("errors.notEmpty"), new Object[]{getString("register.userName")}));
        } else {
            // validate user name existence
            if (!getProfileDSO().isUserValid(userName)) {
                errors.add(newError("userName", getString("errors.userAlreadyExists"), new Object[]{userName}));
            }
        }

        // validate email address
        if (StringUtils.isEmpty(emailAddress)) {
            errors.add(newError("emailAddress", getString("errors.notEmpty"), new Object[]{getString("register.emailAddress")}));
        } else {

            // validate emailAddress format
            if (!EmailValidator.validate(emailAddress)) {
                errors.add(newError("emailAddress", getString("errors.emailInvalidFormat"), new Object[]{emailAddress}));
            } else {
                // validate emailAddress existence
                if (!getProfileDSO().isEmailValid(emailAddress)) {
                    errors.add(newError("emailAddress", getString("errors.emailAlreadyExists"), new Object[]{emailAddress}));
                }
            }

        }

        // validate password
        if (StringUtils.isEmpty(userPass)) {
            errors.add(newError("userPass", getString("errors.notEmpty"), new Object[]{getString("register.userPass")}));
        }

        if (StringUtils.isEmpty(firstName)) {
            errors.add(newError("firstName", getString("errors.notEmpty"), new Object[]{getString("register.firstName")}));
        }

        if (StringUtils.isEmpty(cellPhone)) {
            errors.add(newError("cellPhone", getString("errors.notEmpty"), new Object[]{getString("register.cellPhone")}));
        }

        if (StringUtils.isEmpty(countryId)) {
            errors.add(newError("countryId", getString("errors.notEmpty"), new Object[]{getString("register.countryId")}));
        }

        if (StringUtils.isEmpty(lastName)) {
            errors.add(newError("lastName", getString("errors.notEmpty"), new Object[]{getString("register.lastName")}));
        }

        if (!StringUtils.equalsIgnoreCase(acceptTermAndConditions, "true")) {
            errors.add(newError("acceptTermAndConditions", getString("errors.acceptTermAndConditions")));
        }

        if (StringUtils.isEmpty(confirmPassword)) {
            errors.add(newError("confirmPassword", getString("errors.notEmpty"), new Object[]{getString("register.confirmPassword")}));
        }

        if (!StringUtils.equals(userPass, confirmPassword)) {
            errors.add(newError("userPass", getString("errors.passwordDoesNotMatch")));
        }

        // proceed to registration, if no errors found.
        if (errors.isEmpty()) {

            // create a user and get the newly generated user id,
            // this user by default is disabled, need to
            // validate after registration
            long userId = getProfileDSO().registerUser(
                    userName, userPass,
                    emailAddress, firstName,
                    lastName, cellPhone, new Integer(countryId));

            // generate unique id key for after registration validation
            UUID uid = UUID.randomUUID();

            if (logger.isDebugEnabled()) {
                logger.debug("REGISTERED UID @ " + userId);
            }


            // data objets
            UserDAO userDAO = (UserDAO) getBean("userDAO");
            UserDTO userDTO = userDAO.findById(userId);
            ConfigDAO configDAO = (ConfigDAO) getBean("configDAO");

            // send confirmation mail
            try {

                String storeName = configDAO.findById("STORE_NAME");
                String storeURL = configDAO.findById("STORE_URL");
                String from = configDAO.findById("REGISTRATION_MAIL_FROM");
                String subject = configDAO.findById("REGISTRATION_MAIL_SUBJECT");
                String url = storeURL
                        + "/profile.jspa?aid=confirm&uid="
                        + uid.toString();


                // get store
                StoreDTO store = new StoreDTO();
                store.setStoreId(1);
                store.setStoreName(storeName);
                store.setStoreUrl(storeURL);

                // build registration information object
                RegistrationInfo info = new RegistrationInfo();
                info.setUser(userDTO);
                info.setStore(store);
                info.setUrl(url);

                // serializae registration object to XML
                File inputFile = File.createTempFile("UID" + userId, "xml");
                XStream xstream = new XStream();
                xstream.alias("registration", RegistrationInfo.class);
                xstream.toXML(info, new FileOutputStream(inputFile));

                // transform xml object source to html mail output
                StringWriter outWriter = new StringWriter();
                xslTransform(
                        new FileInputStream(inputFile),
                        getClass().getResourceAsStream("/templates/welcome_mail.xsl"),
                        outWriter);

                // send mail using mailer implementation
                SendMail mailer = (SendMail) getBean("mailer");
                mailer.sendMessage(
                        from, new String[]{emailAddress},
                        subject, outWriter.getBuffer().toString());
            } catch (Exception e) {
                e.printStackTrace();
                if (logger.isErrorEnabled()) {
                    logger.error(e);
                }
            }

            // all ok, send nice response
            mav.addObject("responseCode", SUCCESS);
            mav.addObject("responseMessage", "Registro Completo");
            mav.addObject("userId", userId);

        } else {

            // something wron, send failure response
            mav.addObject("responseCode", FAILURE);
            mav.addObject("responseMessage", "Registro Incompleto, favor verificar");
            mav.addObject("errors", errors);
        }

        return mav;

    }
}
