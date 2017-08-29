package com.piggymetrics.customer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.piggymetrics.customer.domain.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, String> {

	Customer findByName(String name);

}
