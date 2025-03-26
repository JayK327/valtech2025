package com.valtech.training.loan.webservices;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.valtech.training.loan.entities.Loan;
import com.valtech.training.loan.repos.LoanRepo;
import com.valtech.training.loan.services.LoanService;

@WebService(endpointInterface = "com.valtech.training.loan.webservices.LoanServiceWS", name = "LoanService", portName = "LoanServicePort")
public class LoanServiceImplWS implements LoanServiceWS {

	@Autowired
	private LoanRepo loanRepo;

	private LoanService loanService;

	public LoanServiceImplWS(LoanService loanservice) {
		this.loanService = loanservice;
	}

	@Override
	public String applyLoan(String name, String panCard, String address, int cibilScore, double income,
			double assetValue,String status) {
		Loan loanApplication = new Loan();
		loanApplication.setName(name);
		loanApplication.setPancard(panCard);
		loanApplication.setAddress(address);
		loanApplication.setCibil(cibilScore);
		loanApplication.setIncome(income);
		loanApplication.setAssestValue(assetValue);
		loanApplication.setStatus(status);
		loanRepo.save(loanApplication);
		return String.valueOf(loanApplication.getId());

	}

	@Override
	public String processLoan(Long id) {
		Loan loanApplication = loanRepo.findById(id).orElseThrow(() -> new RuntimeException("Customer not Found!!!"));
		double approvedAmount = 0;
	    double maxLoanValue = 5 * loanApplication.getIncome(); // Max loan approved = 5 times income

		if (loanApplication.getCibil() < 600) {
			loanApplication.setStatus("REJECTED!!");
			loanRepo.save(loanApplication);
			return "Low Cibil score";
		} else if (loanApplication.getCibil() < 700) {
			// 50% of the asset value
			approvedAmount = 0.50 * loanApplication.getAssestValue();
			// Ensure approvedAmount doesn't exceed max loan value
	        approvedAmount = Math.min(approvedAmount, maxLoanValue);
			loanApplication.setApprovedAmount(approvedAmount);
			loanApplication.setStatus("PARTIAL LOAN APPROVED!!");
			loanRepo.save(loanApplication);
		} else if (loanApplication.getCibil() < 900) {
			approvedAmount = 0.75 * loanApplication.getAssestValue();
			loanApplication.setApprovedAmount(approvedAmount);
			// Ensure approvedAmount doesn't exceed max loan value
	        approvedAmount = Math.min(approvedAmount, maxLoanValue); 
			loanApplication.setStatus("APPROVED!!");
			loanRepo.save(loanApplication);
		}
		return "Approved Amount " + approvedAmount;
	}

}
