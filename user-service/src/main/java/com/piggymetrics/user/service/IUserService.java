package com.piggymetrics.user.service;

import java.util.List;

import com.piggymetrics.user.domain.User;

public interface IUserService
{
    public List<User> findAll();

    public void saveUser(User book);

   
    public User findOne(long id);

    public void delete(long id);

    public List<User> findByName(String name);

}
