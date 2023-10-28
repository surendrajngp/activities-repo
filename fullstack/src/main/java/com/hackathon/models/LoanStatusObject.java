package com.hackathon.models;

public class LoanStatusObject {
	private Loan loan;
	private String status;

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LoanStatusObject(Loan loan, String status) {
		super();
		this.loan = loan;
		this.status = status;
	}

}
