package com.hackathon.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.models.Loan;
import com.hackathon.models.LoanApplication;
import com.hackathon.models.LoanApplicationObject;
import com.hackathon.models.UpdateLoan;
import com.hackathon.services.LoanServiceInterface;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class LoanController {

	@Autowired
	LoanServiceInterface service;

	@GetMapping("/availableLoans")
	public ResponseEntity<Object> getAllAvailableLoans() {
		List<Loan> loans = service.getAllLoans();
		return ResponseEntity.status(200).body(loans);
	}

	@PostMapping(path = "/applyLoan", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> applyLoan(@RequestBody LoanApplicationObject application) {
		LoanApplication app = service.applyLoan(application);
		return ResponseEntity.status(200).body(app);
	}

	@GetMapping("/getAppliedLoans/{id}")
	public ResponseEntity<Object> getLoansApplied(@PathVariable int id) {
		List<LoanApplication> loans = service.getApplidLoansByCustomerId(id);
		return ResponseEntity.status(200).body(loans);
	}
	
	@GetMapping("/getAllLoanApplications")
	public ResponseEntity<Object> getAllApplications() {
		List<LoanApplication> loans = service.getAllLoanApplications();
		return ResponseEntity.status(200).body(loans);
	}
	
	@PostMapping(path = "/updateLoanApplication", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> updateLoan(@RequestBody LoanApplication application) {
		LoanApplication app = service.update(application);
		return ResponseEntity.status(200).body(app);
	}
	
}
