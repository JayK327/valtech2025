package dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.Item;
import entity.Order;
import utils.HibernateUtils;

public interface OrderDAO {
	void save(Order order);

	Order get(long id);

	void update(Order order);

	void delete(long id);

	List<Order> getAll();

}
