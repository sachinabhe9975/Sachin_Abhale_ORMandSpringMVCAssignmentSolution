package com.greatlearning.customer_management.service;

import java.util.List;

import com.greatlearning.customer_management.entity.Customer;

public interface CustomerService {

	public List<Customer> findAll();

	public void save(Customer b);

	public Customer findById(Integer id);

	public void delete(Customer b);

}
