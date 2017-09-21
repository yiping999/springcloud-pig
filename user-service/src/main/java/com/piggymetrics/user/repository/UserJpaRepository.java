package com.piggymetrics.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.piggymetrics.user.domain.User;


public interface UserJpaRepository extends JpaRepository<User,Long> {

}
