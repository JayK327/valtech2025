package com.valtech.training.loan.webservices;

import javax.jws.WebService;

@WebService
public interface LoanServiceWS {

	String applyLoan(String name, String panCard, String address, int cibilScore, double income, double assetValue,String status);

	String processLoan(Long id);

}