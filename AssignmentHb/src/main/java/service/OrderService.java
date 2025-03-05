package service;

import java.util.List;

import entity.Order;

public interface OrderService {
	void save(Order order);

	Order get(int id);

	List<Order> getAll();

	void update(Order order);

	void delete(int id);

}
