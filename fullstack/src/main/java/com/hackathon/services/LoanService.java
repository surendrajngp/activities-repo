package com.hackathon.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hackathon.daos.LoanApplicationDao;
import com.hackathon.daos.LoanDao;
import com.hackathon.models.Loan;
import com.hackathon.models.LoanApplication;
import com.hackathon.models.LoanApplicationObject;
import com.hackathon.models.UpdateLoan;

import jakarta.transaction.Transactional;

@Service("loanService")
public class LoanService implements LoanServiceInterface {

	@Autowired
	LoanApplicationDao loanApplication;

	@Autowired
	LoanDao loansDto;

	@Override
	public List<Loan> getAllLoans() {
		return loansDto.findAll();
	}

	@Override
	@Transactional
	public LoanApplication applyLoan(LoanApplicationObject application) {
		LoanApplication laa = new LoanApplication(application.getStatus());
		laa.setCustomerId(application.getCustomerId());
		laa.setLoanId(application.getLoanId());
		LoanApplication app = loanApplication.save(laa);
		System.out.println(application);
		return app;
	}
	
	@Override
	public List<LoanApplication> getApplidLoansByCustomerId(int id){
		return loanApplication.getAllLoansByCustomerId(id);
	}
	
	@Override
	public List<LoanApplication> getAllLoanApplications() {
		return loanApplication.findAll();
	}
	
	@Override
	public LoanApplication update(LoanApplication application) {
		return loanApplication.save(application);
	}

	
	
}
