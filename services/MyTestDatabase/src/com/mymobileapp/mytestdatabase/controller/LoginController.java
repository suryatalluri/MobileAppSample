/*Copyright (c) 2015-2016 wavemaker.com All Rights Reserved.
 This software is the confidential and proprietary information of wavemaker.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with wavemaker.com*/

package com.mymobileapp.mytestdatabase.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.mymobileapp.mytestdatabase.service.LoginService;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wordnik.swagger.annotations.*;
import com.mymobileapp.mytestdatabase.*;
import com.mymobileapp.mytestdatabase.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Login.
 * @see com.mymobileapp.mytestdatabase.Login
 */
@RestController(value = "MyTestDatabase.LoginController")
@RequestMapping("/MyTestDatabase/Login")
@Api(description = "Exposes APIs to work with Login resource.", value = "LoginController")
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    @Qualifier("MyTestDatabase.LoginService")
    private LoginService loginService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Login instances matching the search criteria.")
    public Page<Login> findLogins(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Logins list");
        return loginService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Login instances.")
    public Page<Login> getLogins(Pageable pageable) {
        LOGGER.debug("Rendering Logins list");
        return loginService.findAll(pageable);
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the Login instance associated with the given id.")
    public Login getLogin(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Login with id: {}", id);
        Login instance = loginService.findById(id);
        LOGGER.debug("Login details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the Login instance associated with the given id.")
    public boolean deleteLogin(@PathVariable("id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Login with id: {}", id);
        Login deleted = loginService.delete(id);
        return deleted != null;
    }

    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the Login instance associated with the given id.")
    public Login editLogin(@PathVariable("id") Integer id, @RequestBody Login instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Login with id: {}", instance.getId());
        instance.setId(id);
        instance = loginService.update(instance);
        LOGGER.debug("Login details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new Login instance.")
    public Login createLogin(@RequestBody Login instance) {
        LOGGER.debug("Create Login with information: {}", instance);
        instance = loginService.create(instance);
        LOGGER.debug("Created Login with information: {}", instance);
        return instance;
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setLoginService(LoginService service) {
        this.loginService = service;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Login instances.")
    public Long countAllLogins() {
        LOGGER.debug("counting Logins");
        Long count = loginService.countAll();
        return count;
    }
}
