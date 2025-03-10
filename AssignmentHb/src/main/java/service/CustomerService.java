package service;

import java.util.List;

import entity.Customer;

public interface CustomerService {
	void save(Customer customer);

	Customer get(long id);

	void update(Customer customer);

	void delete(long id);

	List<Customer> getAll();
}
