package com.hackathon.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.hackathon.models.LoanApplication;

public interface LoanApplicationDao extends JpaRepository<LoanApplication, Integer> {
	@Query("select l from LoanApplication l where l.customerId = ?1")
	public List<LoanApplication> getAllLoansByCustomerId(int id);
}
