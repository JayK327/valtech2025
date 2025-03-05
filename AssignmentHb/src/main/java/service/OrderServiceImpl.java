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
	private ItemDAO itemDAO;

	public void setOrderDAO(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}
	public void resetInventory(Item item) {
		item.setCurrentQuantity(item.getMaxQuantity());;
		item.setReorderQuantity(0);
		itemDAO.update(item);
	}

	@Override
	public void save(Order order) {
		boolean validOrder=true;
		
//if(l)
		//lineOrderItems.forEach(l-> if(l -> l.getItem().getCur_quantity() >= l.getQuantity()) {return true});
		for (LineItem lineItem : order.getLineItems()) {
			if(lineItem.getItem().getCurrentQuantity()>=lineItem.getQuantity()) {
				validOrder=false;
				order.setStatus(Status.REJECTED);
				System.out.println("Ordered quantity not present");
				break;
			}
		}
		
		if(validOrder) {
			order.setStatus(Status.PACKED);
			orderDAO.save(order);
			Item item;
			for (LineItem lineItem : order.getLineItems()) {
				item=itemDAO.get((int)lineItem.getItem().getId());
				item.setCurrentQuantity(item.getReorderQuantity()+lineItem.getQuantity());
				System.out.println(item.getCurrentQuantity());
				itemDAO.update(item);
				if(item.getCurrentQuantity()==0) {
					resetInventory(item);
				}
				order.setStatus(Status.REJECTED);
			}
		}
		
	}

	@Override
	public Order get(int id) {
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
	public void delete(int id) {
		orderDAO.delete(id);
	}

}
