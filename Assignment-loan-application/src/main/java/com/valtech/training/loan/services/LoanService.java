package com.valtech.training.loan.services;

public interface LoanService {

	String applyLoan(String name, String panCard, String address, int cibilScore, double income, double assetValue);

	String processLoan(Long id);

}