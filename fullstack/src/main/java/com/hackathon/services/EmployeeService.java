package com.hackathon.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.daos.EmployeeDao;
import com.hackathon.exceptions.CustomerLoginException;
import com.hackathon.models.Customer;
import com.hackathon.models.Employee;
import com.hackathon.models.UserLogin;

import jakarta.transaction.Transactional;

@Service("employeeService")
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	@Transactional
	public Employee register(Employee employee) {
		return dao.save(employee);
	}

	public Employee login(UserLogin user) throws CustomerLoginException {
		Employee employee = dao.findByEmail(user.getEmail());

		if (employee == null) {
			throw new CustomerLoginException("Invalid Email Id or Customer Does Not Exists");
		} else if (!employee.getPassword().equals(user.getPassword())) {
			throw new CustomerLoginException("Invalid Password");
		} else {
			return employee;
		}
	}
}
