package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
//import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import entity.Customer;
import utils.HibernateUtils;

public class CustomerDAOImpl implements CustomerDAO {
	
//	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Customer customer) {
		new HibernateTemplate(sessionFactory).save(customer);
	}
	@Override
	public Customer get(long id) {
		return new HibernateTemplate(sessionFactory).load(Customer.class,id);
	}
	@Override
	public void update(Customer customer) {
		new HibernateTemplate(sessionFactory).update(customer);
		
	}
	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));		
	}
	@Override
	public List<Customer> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Customer c");
	}

    
}
