package com.valtech.training.loan;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.loan.entities.Loan;
import com.valtech.training.loan.repos.LoanRepo;
import com.valtech.training.loan.webservices.LoanServiceImplWS;
import com.valtech.training.loan.webservices.LoanServiceWS;

@SpringBootTest
class AssigmentLoanApplicationTests {

	@Test
	void contextLoads() {
	}

    @Autowired
    private LoanRepo loanRepo;  

    @Autowired
    private LoanServiceWS loanServiceWS; 
    
    @BeforeEach
    public void setUp() {
        loanRepo.deleteAll();
    }
    
    @Test
    public void testApplyLoan() {
        String loanId = loanServiceWS.applyLoan("A", "ABCDE1234F", "P", 750, 50000, 200000,"PENDING");
        assertNotNull(loanId);

        Loan loan = loanRepo.findById(Long.valueOf(loanId)).orElseThrow(() -> new RuntimeException("Loan not found"));
        assertEquals("PENDING", loan.getStatus());  
    }

    @Test
    public void testProcessLoan_RejectLowCibilScore() {
       
        Loan loan =new Loan("B", "ADFFS1234F", "Q", 550, 100000, 30000, "Pending");
        // Low CIBIL score
        loanRepo.save(loan); 

       
        String result = loanServiceWS.processLoan(loan.getId());

        assertEquals("Low Cibil score", result);  // Loan should be rejected
        Loan updatedLoan = loanRepo.findById(loan.getId()).orElseThrow(() -> new RuntimeException("Loan not found"));
        assertEquals("REJECTED!!", updatedLoan.getStatus());  // Status should be 'REJECTED!!'
    }

    @Test
    public void testProcessLoan_PartialApproval() {
        // Given
        Loan loan =new Loan("C", "GJDKE7634F", "R", 650, 100000, 30000, "Pending");
        // CIBIL between 600 and 700
        loanRepo.save(loan); 

        String result = loanServiceWS.processLoan(loan.getId());

        assertEquals("Approved Amount 50000.0", result);  // Loan approved for 50% of asset value
        Loan updatedLoan = loanRepo.findById(loan.getId()).orElseThrow(() -> new RuntimeException("Loan not found"));
        assertEquals("PARTIAL LOAN APPROVED!!", updatedLoan.getStatus());  // Status should be 'PARTIAL LOAN APPROVED!!'
        assertEquals(50000.0, updatedLoan.getApprovedAmount());  // Check the approved amount
    }

    @Test
    public void testProcessLoan_FullApproval() {
        Loan loan=(new Loan("D", "JSKTR4643D", "S", 750, 100000, 30000, "Pending"));
        // CIBIL between 700 and 900
        
        loanRepo.save(loan);
        String result = loanServiceWS.processLoan(loan.getId());

        assertEquals("Approved Amount 75000.0", result);  // Loan approved for 75% of asset value
        Loan updatedLoan = loanRepo.findById(loan.getId()).orElseThrow(() -> new RuntimeException("Loan not found"));
        assertEquals("APPROVED!!", updatedLoan.getStatus());  // Status should be 'APPROVED!!'
        assertEquals(75000.0, updatedLoan.getApprovedAmount());  // Check the approved amount
    }



}
