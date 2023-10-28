package com.hackathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.errors.CustomError;
import com.hackathon.exceptions.CustomerLoginException;
import com.hackathon.models.Customer;
import com.hackathon.models.UserLogin;
import com.hackathon.services.CustomerServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerServiceInterface service;

	@PostMapping(path = "/customer/register", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> registerCustomer(@RequestBody Customer customer) {
		Customer customer2 = service.register(customer);
		return ResponseEntity.status(200).body(customer2);
	}

	@GetMapping(path = "/customers", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getAllCustomers() {
		List<Customer> customers = service.fetchAllCustomers();
		return ResponseEntity.status(200).body(customers);
	}

	@PostMapping(path = "/customer/login", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> loginCustomer(@RequestBody UserLogin user) {
		Customer customer2;
		try {
			customer2 = service.login(user);
			return ResponseEntity.status(200).body(customer2);
		} catch (CustomerLoginException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body(new CustomError(true, e.getMessage()));
		}
	}
	
	@GetMapping(path = "/customer/{email}")
	public ResponseEntity<Object> getCustomerByEmail(@PathVariable String email) {
		Customer customer = service.findCustomerByEmail(email);
		return ResponseEntity.status(200).body(customer);
	}
}
