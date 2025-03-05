package dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import entity.Order;
import utils.HibernateUtils;

public class OrderDAOImpl implements OrderDAO {

	@Autowired
	private SessionFactory sessionFactory; 
	
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void save(Order order) {
		
		new HibernateTemplate(sessionFactory).save(order);
		
		
	}

	@Override
	public Order get(int id) {
		return new HibernateTemplate(sessionFactory).load(Order.class, id);
	
	}

	@Override
	public List<Order> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Order o");
	}

	@Override
	public void update(Order order) {
		new HibernateTemplate(sessionFactory).update(order);
		
	}

	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));
		
	}
}

