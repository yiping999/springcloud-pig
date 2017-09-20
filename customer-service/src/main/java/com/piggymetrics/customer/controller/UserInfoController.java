package com.piggymetrics.customer.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.piggymetrics.customer.domain.UserInfo;
import com.piggymetrics.customer.service.UserInfoService;


@RestController
//@RequestMapping(value = "/userinfos")
public class UserInfoController
{
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private UserInfoService userService;

    @RequestMapping(value = "/add/{id}/{name}/{address}")
    public UserInfo addUser(@PathVariable int id, @PathVariable String name,
        @PathVariable String address)
    {
        UserInfo user = new UserInfo();
        user.setId(id);
        user.setName(name);
        user.setAddress(address);
        userService.saveUser(user);
        return user;
    }

    @RequestMapping(value = "/delete/{id}")
    public void deleteBook(@PathVariable int id)
    {
        userService.delete(id);
    }

    @RequestMapping(value = "/")
    public List<UserInfo> getBooks()
    {
    	
    	log.info("get getBooks: ");
        return userService.findAll();
    }

    @RequestMapping(value = "/{id}")
    public UserInfo getUser(@PathVariable int id)
    {
    	log.info("get book id: " + id);
        UserInfo user = userService.findOne(id);
        return user;
    }

    @RequestMapping(value = "/search/name/{name}")
    public List<UserInfo> getBookByName(@PathVariable String name)
    {
    	log.info("get book name: " + name);
        List<UserInfo> users = userService.findByName(name);
        return users;
    }

}