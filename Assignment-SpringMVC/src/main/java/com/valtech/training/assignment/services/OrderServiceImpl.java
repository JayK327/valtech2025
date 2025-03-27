package com.valtech.training.assignment.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.assignment.entities.Item;
import com.valtech.training.assignment.entities.LineItem;
import com.valtech.training.assignment.entities.Order;
import com.valtech.training.assignment.entities.Customer.CustomerStatus;
import com.valtech.training.assignment.entities.Order.Status;
import com.valtech.training.assignment.repos.ItemRepo;
import com.valtech.training.assignment.repos.OrderRepo;
import com.valtech.training.assignment.vos.OrderVO;
import com.valtech.training.assignment.vos.PlaceOrderVO;




@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderRepo orderRepo;
	
	
	@Autowired
	private ItemRepo itemRepo;
	
	@Autowired
	private ItemService itemService;
	
	@Autowired
	private CustomerService customerService;
	

	public void resetInventory(Item item) {
		
		item.setQuantity(item.getMaxQuantity());
		item.setReorderQuantity(0);
		itemRepo.save(item);
	}
	
	
	
//	@Override
//	public Order getOrder(PlaceOrderVO poVO) {
//		int cusId = poVO.cusId();
//		int itemId = poVO.itemId();
//		int quantity = poVO.quantity();
//		
//		LineItem li = new LineItem();
//		li.setItem(itemService.getItem(itemId).to());
//		li.setQuantity(quantity);
//		
//		Order order = new Order();
//		order.setCustomer(customerService.get(cusId).to());
//		order.addLineItem(li);
//		return order;
//	}
	
	

	@Override
	public void save(PlaceOrderVO poVO) {
		
		int cusId = poVO.cusId();
		int itemId = poVO.itemId();
		int quantity = poVO.quantity();
		
		LineItem li = new LineItem();
		li.setItem(itemService.getItem(itemId).to());
		li.setQuantity(quantity);
		
		Order o = new Order();
		o.setCustomer(customerService.get(cusId).to());
		o.addLineItem(li);
		
		
		System.out.println("============================");
		boolean valid = true;
		 
//		System.out.println(o.getLineItems().size() + "======================sdvskdvnxdkdnvdskx");
		for (LineItem lineItem : o.getLineItems()) {
			
			System.out.println(o.getLineItems()+ "========================");
			if(lineItem.getQuantity() > lineItem.getItem().getQuantity() || o.getCustomer().getCusStatus()== CustomerStatus.DISABLE) {
				valid = false;
				o.setStatus(Status.REJECTED);
				orderRepo.save(o);
				break;	
				
			}
		}
		if(valid) {
			
			System.out.println("=========================");
			o.setStatus(Status.PACKED);
			orderRepo.save(o);
			Item item;
			for (LineItem lineItem : o.getLineItems()) {
 
				item = itemRepo.getReferenceById(lineItem.getItem().getItemId());
				item.setQuantity(item.getQuantity()-lineItem.getQuantity());
				item.setReorderQuantity(item.getReorderQuantity() + lineItem.getQuantity());
				System.out.println("======>>>>>>>>>>>>>>>"+item.getQuantity());
				itemRepo.save(item);
				if(item.getQuantity() == 0) {
					resetInventory(item);
				}				
 
			}			
		}
	}
		
		
	@Override
	public OrderVO update(OrderVO orderVO) {
		return OrderVO.from(orderRepo.save(orderVO.to()));
	}

	@Override
	public void delete(int id) {
		orderRepo.deleteById(id);
	}

	@Override
	public OrderVO get(int id) {
		return OrderVO.from(orderRepo.getReferenceById(id));
	}

	@Override
	public List<OrderVO> getAll() {
		return OrderVO.from(orderRepo.findAll());
	}
}
