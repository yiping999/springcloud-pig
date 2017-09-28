package com.piggymetrics.customer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.piggymetrics.customer.CustomerApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CustomerApplication.class)
@WebAppConfiguration
public class CustomerServiceApplicationTests {

	@Test
	public void contextLoads() {

	}

}
