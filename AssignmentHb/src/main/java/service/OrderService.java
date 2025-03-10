package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	void save(Order order);

	Order get(long id);

	List<Order> getAll();

	void update(Order order);

	void delete(long id);

}
