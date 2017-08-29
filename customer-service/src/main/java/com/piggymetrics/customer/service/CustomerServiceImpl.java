package com.piggymetrics.customer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.piggymetrics.customer.client.AuthServiceClient;
import com.piggymetrics.customer.client.StatisticsServiceClient;
import com.piggymetrics.customer.domain.Customer;
import com.piggymetrics.customer.domain.Currency;
import com.piggymetrics.customer.domain.Saving;
import com.piggymetrics.customer.domain.User;
import com.piggymetrics.customer.repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class CustomerServiceImpl implements CustomerService {

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private StatisticsServiceClient statisticsClient;

	@Autowired
	private AuthServiceClient authClient;

	@Autowired
	private CustomerRepository repository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer findByName(String customerName) {
		Assert.hasLength(customerName);
		return repository.findByName(customerName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Customer create(User user) {

		Customer existing = repository.findByName(user.getUsername());
		Assert.isNull(existing, "account already exists: " + user.getUsername());

		authClient.createUser(user);

		Saving saving = new Saving();
		saving.setAmount(new BigDecimal(0));
		saving.setCurrency(Currency.getDefault());
		saving.setInterest(new BigDecimal(0));
		saving.setDeposit(false);
		saving.setCapitalization(false);

		Customer customer = new Customer();
		customer.setName(user.getUsername());
		customer.setLastSeen(new Date());
		customer.setSaving(saving);

		repository.save(customer);

		log.info("new account has been created: " + customer.getName());

		return customer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void saveChanges(String name, Customer update) {

		Customer costomer = repository.findByName(name);
		Assert.notNull(costomer, "can't find account with name " + name);

		costomer.setIncomes(update.getIncomes());
		costomer.setExpenses(update.getExpenses());
		costomer.setSaving(update.getSaving());
		costomer.setNote(update.getNote());
		costomer.setLastSeen(new Date());
		repository.save(costomer);

		log.debug("account {} changes has been saved", name);

		statisticsClient.updateStatistics(name, costomer);
	}
}
