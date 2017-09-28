package com.piggymetrics.user.repository;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Currency;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.piggymetrics.user.domain.*;
import com.piggymetrics.user.UserApplication;

//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootTest(classes = UserApplication.class)
//public class UserRepositoryTest {
//
//	@Autowired
//	private UserJpaRepository repository;
//
//	@Test
//	public void shouldFindAccountByName() {
//
//		User user = new User();
//		user.setId(6);
//		user.setName("test1");
//		user.setAddress("SH 123 street");
//		repository.save(user);
//
//		User found = repository.findOne(new Long(6));
//		assertEquals(user.getId(), found.getId());
//		assertEquals(user.getName(), found.getName());
//		assertEquals(user.getAddress(), found.getAddress());
//
//	}
//
//
//}
