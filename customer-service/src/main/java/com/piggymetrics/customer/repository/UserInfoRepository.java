package com.piggymetrics.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.piggymetrics.customer.domain.UserInfo;

public interface UserInfoRepository extends Repository<UserInfo, Long>
{

    List<UserInfo> findByNameAndAddress(String name, String address);

    @Query(value = "from UserInfo u where u.name=:name")
    List<UserInfo> findByName1(@Param("name") String name);

    @Query(value = "select * from #{#entityName} u where u.name=?1", nativeQuery = true)
    List<UserInfo> findByName2(String name);

    List<UserInfo> findByName(String name);
}
