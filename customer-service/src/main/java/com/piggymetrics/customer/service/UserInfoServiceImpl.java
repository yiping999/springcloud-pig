package com.piggymetrics.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.piggymetrics.customer.domain.UserInfo;
import com.piggymetrics.customer.repository.UserInfoJpaRepository;
import com.piggymetrics.customer.repository.UserInfoRepository;


@Service
@Transactional
public class UserInfoServiceImpl implements UserInfoService
{
    @Autowired
    private UserInfoJpaRepository userJpaRepository;
    @Autowired
    private UserInfoRepository userRepository;

    public List<UserInfo> findAll()
    {
        return userJpaRepository.findAll();
    }

    public List<UserInfo> findByName(String name)
    {
        List<UserInfo> userList1 = userRepository.findByName1(name);
        List<UserInfo> userList2 = userRepository.findByName2(name);
        List<UserInfo> userList3 = userRepository.findByNameAndAddress(name, "3");
        System.out.println("userLisInfot1:" + userList1);
        System.out.println("userList2:" + userList2);
        System.out.println("userList3:" + userList3);
        return userRepository.findByName(name);
    }

    public void saveUser(UserInfo book)
    {
        userJpaRepository.save(book);
    }

    @Cacheable("users")
    public UserInfo findOne(long id)
    {
        System.out.println("Cached Pages");
        return userJpaRepository.findOne(id);
    }

    public void delete(long id)
    {
        userJpaRepository.delete(id);
    }
}
