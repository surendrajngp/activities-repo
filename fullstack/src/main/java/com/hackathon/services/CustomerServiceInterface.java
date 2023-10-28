package com.hackathon.services;

import java.util.List;

import com.hackathon.exceptions.CustomerLoginException;
import com.hackathon.models.Customer;
import com.hackathon.models.UserLogin;

public interface CustomerServiceInterface {

	Customer register(Customer customer);

	List<Customer> fetchAllCustomers();

	Customer login(UserLogin user) throws CustomerLoginException;

	Customer findCustomerByEmail(String email);

}