package com.hackathon.services;

import java.util.List;

import com.hackathon.models.Loan;
import com.hackathon.models.LoanApplication;
import com.hackathon.models.LoanApplicationObject;
import com.hackathon.models.UpdateLoan;

public interface LoanServiceInterface {

	List<Loan> getAllLoans();

	LoanApplication applyLoan(LoanApplicationObject application);

	List<LoanApplication> getApplidLoansByCustomerId(int id);

	List<LoanApplication> getAllLoanApplications();

	LoanApplication update(LoanApplication application);

}