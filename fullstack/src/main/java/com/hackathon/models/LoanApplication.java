package com.hackathon.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "loan_applications")
public class LoanApplication {
	@Id
	@Column(name = "application_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int applicationId;

	@JoinColumn(name = "customer_id")
	private int customerId;

	@JoinColumn(name = "loan_id")
	private int loanId;

	@Column(name = "status")
	private String status;

	public LoanApplication(String status) {
		super();
		this.status = status;
	}

	public LoanApplication() {
		super();
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoanApplication(int applicationId, int customerId, int loanId, String status) {
		super();
		this.applicationId = applicationId;
		this.customerId = customerId;
		this.loanId = loanId;
		this.status = status;
	}
	
	
}
