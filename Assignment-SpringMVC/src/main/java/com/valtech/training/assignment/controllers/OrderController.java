package com.valtech.training.assignment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valtech.training.assignment.entities.LineItem;
import com.valtech.training.assignment.entities.Order;
import com.valtech.training.assignment.entities.Order.Status;
import com.valtech.training.assignment.services.CustomerService;
import com.valtech.training.assignment.services.ItemService;
import com.valtech.training.assignment.services.OrderService;
import com.valtech.training.assignment.vos.LineItemVO;
import com.valtech.training.assignment.vos.OrderVO;
import com.valtech.training.assignment.vos.PlaceOrderVO;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/order")
	public String addOrders(@ModelAttribute PlaceOrderVO placeOrderVO, Model model) {
//		int cusId = placeOrderVO.cusId();
//		int itemId = placeOrderVO.itemId();
//		int quantity = placeOrderVO.quantity();
//		
//		LineItem lineItem = new LineItem();
//		lineItem.setItem(itemService.getItem(itemId).to());
//		lineItem.setQuantity(quantity);
//		
//		Order order = new Order();
//		order.setCustomer(customerService.get(cusId).to());
//		order.addLineItem(lineItem);
//		order.setStatus(Status.IN_WAREHOUSE);
		
		
		orderService.save(placeOrderVO);
		
		return "order";
	}
	
	
	@GetMapping("/order")
	public String getOrder(Model model) {
		return "order";
	}
}
