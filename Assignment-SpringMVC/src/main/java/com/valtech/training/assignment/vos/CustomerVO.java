package com.valtech.training.assignment.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.assignment.entities.Customer;
import com.valtech.training.assignment.entities.Customer.CustomerStatus;

public record CustomerVO(int cusId, String name, int age, String address, String permanentAddress, String cusStatus) {
	
	public static CustomerVO from(Customer c) {
		String status = c.getCusStatus().name();
		return new CustomerVO(c.getCusId(), c.getName(), c.getAge(), c.getAddress(), c.getPermanentAddress(), status);
	}
	
	public Customer to() {
		CustomerStatus status = CustomerStatus.valueOf(cusStatus);
		Customer c = new Customer(cusId, name, age, permanentAddress, address, status);
		return c;
	}

	public static List<CustomerVO> from(List<Customer> customer){
		return customer.stream().map(cus -> CustomerVO.from(cus)).collect(Collectors.toList());
	}
}
