package dao;

import entity.Item;
import entity.Item;
import utils.HibernateUtils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class ItemDAOImpl implements ItemDAO {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(Item item) {
		new HibernateTemplate(sessionFactory).save(item);
	}
	@Override
	public Item get(long id) {
		return new HibernateTemplate(sessionFactory).load(Item.class,id);
	}
	@Override
	public void update(Item customer) {
		new HibernateTemplate(sessionFactory).update(customer);
		
	}
	@Override
	public void delete(int id) {
		new HibernateTemplate(sessionFactory).delete(get(id));		
	}
	@Override
	public List<Item> getAll() {
		return new HibernateTemplate(sessionFactory).find("from Item i");
	}
}

