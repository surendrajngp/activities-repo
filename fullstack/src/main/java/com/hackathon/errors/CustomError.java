package com.hackathon.errors;

public class CustomError {
	private boolean error;
	private String message;

	public CustomError(boolean error, String message) {
		super();
		this.setError(error);
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}
	
}
