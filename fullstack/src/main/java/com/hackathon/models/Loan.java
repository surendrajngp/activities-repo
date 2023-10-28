package com.hackathon.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "loans")
public class Loan {
	@Id
	@Column(name = "loan_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int loanId;

	@Column(name = "loan_type")
	private String loanType;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	public int getLoanId() {
		return loanId;
	}

	public void setLoanId(int loanId) {
		this.loanId = loanId;
	}

	public Loan(String loanType) {
		super();
		this.loanType = loanType;
	}

	public Loan() {
		super();
	}

	@Override
	public int hashCode() {
		return Objects.hash(loanId, loanType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return loanId == other.loanId && Objects.equals(loanType, other.loanType);
	}

	
}
