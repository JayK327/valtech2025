package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import entity.LineItem;
import utils.HibernateUtils;

public interface LineItemDAO {
	void save(LineItem item);

	LineItem get(long id);

	List<LineItem> getAll();
	
//	List<LineItem> getByOrderId(long id);

	void update(LineItem item);

	void delete(long id);
   
}
