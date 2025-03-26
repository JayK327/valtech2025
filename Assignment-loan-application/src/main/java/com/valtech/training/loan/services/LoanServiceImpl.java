package com.valtech.training.loan.services;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.valtech.training.loan.entities.Loan;
import com.valtech.training.loan.repos.LoanRepo;

@Service
public class LoanServiceImpl implements LoanService {
	
	@Autowired
	private LoanRepo loanRepo;
	
	@Override
	public String applyLoan(String name, String panCard, String address, int cibilScore, double income, double assetValue) {
		Loan application = new Loan();
		application.setName(name);
		application.setPancard(panCard);
		application.setAddress(address);
		application.setCibil(cibilScore);
		application.setIncome(income);
		application.setAssestValue(assetValue);
		application.setStatus("Pending");
		loanRepo.save(application);
		return String.valueOf(application.getId());
		
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
