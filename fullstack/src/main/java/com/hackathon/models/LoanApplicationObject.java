package com.hackathon.models;

public class LoanApplicationObject {
	private int customerId;
	private int loanId;
	private String status;

	public LoanApplicationObject(int customerId, int loanId, String status) {
		super();
		this.customerId = customerId;
		this.loanId = loanId;
		this.status = status;
	}

	public LoanApplicationObject() {
		super();
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

}
