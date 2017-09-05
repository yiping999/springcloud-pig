package com.piggymetrics.customer.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.piggymetrics.customer.domain.Customer;
import com.piggymetrics.customer.domain.User;
import com.piggymetrics.customer.service.CustomerService;

//@Api(tags="用户管理")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	
//	  @ApiOperation("用户详情")
	@PreAuthorize("#oauth2.hasScope('server') or #name.equals('demo')")
	@RequestMapping(path = "/{name}", method = RequestMethod.GET)
	public Customer getCustomerByName(@PathVariable String name) {
		return customerService.findByName(name);
	}

	@RequestMapping(path = "/current", method = RequestMethod.GET)
	public Customer getCurrentCustomer(Principal principal) {
		return customerService.findByName(principal.getName());
	}

	@RequestMapping(path = "/current", method = RequestMethod.PUT)
	public void saveCurrentCustomer(Principal principal, @Valid @RequestBody Customer customer) {
		customerService.saveChanges(principal.getName(), customer);
	}

	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Customer createNewCustomer(@Valid @RequestBody User user) {
		return customerService.create(user);
	}
}
