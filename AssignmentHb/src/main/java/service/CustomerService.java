package service;

import java.util.List;

import entity.Customer;

public interface CustomerService {
	void save(Customer customer);

	Customer get(int id);

	void update(Customer customer);

	void delete(int id);

	List<Customer> getAll();
}
