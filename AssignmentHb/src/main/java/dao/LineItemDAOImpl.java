package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.HibernateTemplate;

import entity.Item;
import entity.LineItem;
import utils.HibernateUtils;

public class LineItemDAOImpl implements LineItemDAO {

	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void save(LineItem lineItem) {
		new HibernateTemplate(sessionFactory).save(lineItem);
	}
	@Override
	public LineItem get(long id) {
		return new HibernateTemplate(sessionFactory).load(LineItem.class,id);
	}
	@Override
	public void update(LineItem lineItem) {
		new HibernateTemplate(sessionFactory).update(lineItem);
		
	}
	@Override
	public void delete(long id) {
		new HibernateTemplate(sessionFactory).delete(get(id));		
	}
	@Override
	public List<LineItem> getAll() {
		return new HibernateTemplate(sessionFactory).find("from LineItem l");
	}
	
//	@Override
//	public List<LineItem> getByOrderId(int id) {
//		return new HibernateTemplate(sessionFactory).find(id);
//	}

}
