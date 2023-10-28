package com.hackathon.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hackathon.models.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.email = ?1")
	public Customer findByEmail(String email);

}
