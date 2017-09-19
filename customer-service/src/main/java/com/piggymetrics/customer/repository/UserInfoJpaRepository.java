package com.piggymetrics.customer.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.piggymetrics.customer.domain.UserInfo;


public interface UserInfoJpaRepository extends JpaRepository<UserInfo,Long> {

}