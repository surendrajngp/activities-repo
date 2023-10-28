package com.hackathon.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.daos.CustomerDao;
import com.hackathon.exceptions.CustomerLoginException;
import com.hackathon.models.Customer;
import com.hackathon.models.UserLogin;

import jakarta.transaction.Transactional;

@Service("customerService")
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	CustomerDao dao;

	@Override
	@Transactional
	public Customer register(Customer customer) {
		return dao.save(customer);
	}

	@Override
	public List<Customer> fetchAllCustomers() {
		return dao.findAll();
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public Customer login(UserLogin user) throws CustomerLoginException {
		Customer customer = dao.findByEmail(user.getEmail());

		if (customer == null) {
			throw new CustomerLoginException("Invalid Email Id or Customer Does Not Exists");
		} else if (!customer.getPassword().equals(user.getPassword())) {
			throw new CustomerLoginException("Invalid Password");
		} else {
			return customer;
		}
	}
}
