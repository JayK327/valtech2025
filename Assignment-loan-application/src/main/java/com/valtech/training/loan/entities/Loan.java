package com.valtech.training.loan.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Loan {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "loan_seq")
	@SequenceGenerator(name = "loan_seq",sequenceName = "loanseq",allocationSize = 1)
	private long id;
	private String name;
	@Column(nullable = false,unique = true)
	private String pancard;
	private String address;
	private int cibil;
	private double income;
	private double assestValue;
	private double approvedAmount;
	private String status;
	
	public Loan() {
		
	}

	public Loan(String name, String pancard, String address, int cibil, double income, double assestValue,
			String status) {
		super();
		this.name = name;
		this.pancard = pancard;
		this.address = address;
		this.cibil = cibil;
		this.income = income;
		this.assestValue = assestValue;
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCibil() {
		return cibil;
	}

	public void setCibil(int cibil) {
		this.cibil = cibil;
	}

	public double getIncome() {
		return income;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public double getAssestValue() {
		return assestValue;
	}

	public void setAssestValue(double assestValue) {
		this.assestValue = assestValue;
	}

	public double getApprovedAmount() {
		return approvedAmount;
	}

	public void setApprovedAmount(double approvedAmount) {
		this.approvedAmount = approvedAmount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", name=" + name + ", pancard=" + pancard + ", address=" + address + ", cibil="
				+ cibil + ", income=" + income + ", assestValue=" + assestValue + ", approvedAmount=" + approvedAmount
				+ ", status=" + status + "]";
	}

}
