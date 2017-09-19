package com.piggymetrics.customer.service;

import java.util.List;

import com.piggymetrics.customer.domain.UserInfo;

public interface UserInfoService
{
    public List<UserInfo> findAll();

    public void saveUser(UserInfo book);
   
    public UserInfo findOne(long id);

    public void delete(long id);

    public List<UserInfo> findByName(String name);

}