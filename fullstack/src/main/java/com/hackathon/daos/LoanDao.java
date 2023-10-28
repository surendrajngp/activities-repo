package com.hackathon.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackathon.models.Loan;

public interface LoanDao extends JpaRepository<Loan, Integer> {

}
