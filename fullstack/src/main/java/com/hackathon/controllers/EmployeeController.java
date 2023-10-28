package com.hackathon.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.errors.CustomError;
import com.hackathon.exceptions.CustomerLoginException;
import com.hackathon.models.Customer;
import com.hackathon.models.Employee;
import com.hackathon.models.UserLogin;
import com.hackathon.services.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping(path = "/employee/register")
	public ResponseEntity<Object> register(@RequestBody Employee employee) {
		Employee e = service.register(employee);
		return ResponseEntity.status(200).body(e);
	}

	@PostMapping(path = "/employee/login")
	public ResponseEntity<Object> login(@RequestBody	 UserLogin user) {
		Employee employee;
		try {
			employee = service.login(user);
			return ResponseEntity.status(200).body(employee);
		} catch (CustomerLoginException e) {
			e.printStackTrace();
			return ResponseEntity.status(404).body(new CustomError(true, e.getMessage()));
		}
	}
}
