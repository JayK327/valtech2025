package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ItemDAO;
import dao.OrderDAO;
import entity.Item;
import entity.LineItem;
import entity.Order;
import entity.Order.Status;

public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDAO orderDAO;
	@Autowired
	private ItemDAO itemDAO;
	@Autowired
	private InventoryService inventoryService;

	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	public void setInventoryService(InventoryService inventoryService) {
		this.inventoryService = inventoryService;
	}
//	public void resetInventory(Item item) {
//		item.setCurrentQuantity(item.getMaxQuantity());;
//		item.setReorderQuantity(0);
//		itemDAO.update(item);
//	}

	@Override
	public void save(Order order) {
		boolean validOrder=true;
		
		//Check is the customer is enable or not to place order
		if(order.getCustomer().getCustomerStatus().toString().equals("DISABLE")) {
			System.out.println("CUSTOMER IS DISABLED");
			return;
		}

		for (LineItem lineItem : order.getLineItems()) {
			Item item=inventoryService.get(lineItem.getItem().getId());
			if(item.getCurrentQuantity()<=lineItem.getQuantity()) {
				validOrder=false;
				order.setStatus(Status.REJECTED);
				inventoryService.deleteInventory(item.getId());
				System.out.println("Ordered quantity not present");
				break;
			}
		}
		
		if(validOrder) {
			order.setStatus(Status.PACKED);
			inventoryService.updateInventory(order);
			System.out.println("Ordered is valid");
			System.out.println("Ordered PACKED");
			
		}
		orderDAO.save(order);
		
	}

	@Override
	public Order get(long id) {
		return orderDAO.get(id);
	}
	
	@Override
	public List<Order> getAll() {
		return orderDAO.getAll();
	}

	@Override
	public void update(Order order) {
		orderDAO.update(order);
	}

	@Override
	public void delete(long id) {
		orderDAO.delete(id);
	}

}
