package com.valtech.training.assignment.services;

import java.util.List;

import com.valtech.training.assignment.entities.Customer;
import com.valtech.training.assignment.vos.CustomerVO;

public interface CustomerService {
	
	CustomerVO save(CustomerVO customerVO);

	CustomerVO update(CustomerVO customerVO);

	void delete(int id);
	
	CustomerVO get(int id);
	
	List<CustomerVO> getAll();

}
