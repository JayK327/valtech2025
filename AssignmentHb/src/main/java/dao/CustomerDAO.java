package dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Customer;
import utils.HibernateUtils;


public interface CustomerDAO {
	void save(Customer customer);
	Customer get(long id);
	void update(Customer customer);
	void delete(int id);
	
	List<Customer> getAll();

}
