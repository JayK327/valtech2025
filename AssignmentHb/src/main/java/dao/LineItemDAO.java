package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import entity.LineItem;
import utils.HibernateUtils;

public interface LineItemDAO {
	void save(LineItem item);

	LineItem get(int id);

	List<LineItem> getAll();
	
//	List<LineItem> getByOrderId(int id);

	void update(LineItem item);

	void delete(int id);
   
}
