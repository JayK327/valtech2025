package com.valtech.training.assignment.vos;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.valtech.training.assignment.entities.Customer;
import com.valtech.training.assignment.entities.Item;
import com.valtech.training.assignment.entities.LineItem;
import com.valtech.training.assignment.entities.Order;
import com.valtech.training.assignment.entities.Order.Status;

public record OrderVO(int orderId, Customer customer, List<LineItem> lineItems) {
	

	public static OrderVO from(Order o) {
		return new OrderVO(o.getOrderId(), o.getCustomer(), o.getLineItems());
	}
	
	
	public static List<OrderVO> from(List<Order> orders){
		return orders.stream().map(order -> OrderVO.from(order)).collect(Collectors.toList());
	}
	
	public Order to() {
		Order o = new Order(orderId, customer, lineItems)  ;
		return o;
	}

}
