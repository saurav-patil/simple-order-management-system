package com.infinity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.model.Customer;
import com.infinity.repository.CustomerRepository;

@Service
public class CustomerServiceImpl {

	@Autowired
	private CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void makeOrder(Customer customer) {
		customerRepository.save(customer);
	}
	
	public Customer getCustomerById(int customerId) {
		return customerRepository.findById(customerId).get();
	}

	public List<Customer> getAllCustomer() {
		return customerRepository.findAll();
	}
		
}
