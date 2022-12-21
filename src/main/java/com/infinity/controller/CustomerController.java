package com.infinity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.model.Customer;
import com.infinity.service.CustomerServiceImpl;

@RestController
@RequestMapping(path = "customers")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerService;

	@GetMapping
	public List<Customer> getAllCustomer() {
		return customerService.getAllCustomer();
	}

	@PostMapping
	public void createCustomer(@RequestBody Customer customer) {
		customerService.createCustomer(customer);
	}

	@PutMapping(path = "{customerId}")
	public void makeOrder(@PathVariable("customerId") int customerId) {
		Customer existingCustomer = customerService.getCustomerById(customerId);
		existingCustomer.setCustomerOrderCount(existingCustomer.getCustomerOrderCount() + 1);
		customerService.makeOrder(existingCustomer);
	}

}
