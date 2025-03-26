package com.valtech.training.loan.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.valtech.training.loan.entities.Loan;

@Repository
public interface LoanRepo extends JpaRepository<Loan, Long> {

}
