package com.valtech.training.assignment.services;

import java.util.List;

import com.valtech.training.assignment.entities.Order;
import com.valtech.training.assignment.vos.OrderVO;
import com.valtech.training.assignment.vos.PlaceOrderVO;

public interface OrderService {
	
//	Order getOrder(PlaceOrderVO poVO);

	void save(PlaceOrderVO poVO);

	OrderVO update(OrderVO orderVO);

	void delete(int id);

	OrderVO get(int id);

	List<OrderVO> getAll();

}