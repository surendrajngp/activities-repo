package com.hackathon.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hackathon.models.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.emailId = ?1")
	public Employee findByEmail(String email);
}
