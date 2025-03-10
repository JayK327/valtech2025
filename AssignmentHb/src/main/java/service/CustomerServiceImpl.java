package service;

import java.util.List;

import dao.CustomerDAO;
import entity.Customer;

public class CustomerServiceImpl implements CustomerService {

	private CustomerDAO customerDAO;
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}
	
	
	@Override
	public void save(Customer customer) {
		customerDAO.save(customer);
	}

	@Override
	public Customer get(long id) {
		return customerDAO.get(id);
	}

	@Override
	public void update(Customer customer) {
		customerDAO.update(customer);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		customerDAO.delete(id);
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return customerDAO.getAll();
	}

}
