package com.hackathon.models;

public class UpdateLoan {
	private int applicationId;
	private String status;
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public UpdateLoan(int applicationId, String status) {
		super();
		this.applicationId = applicationId;
		this.status = status;
	}
	
	
}
