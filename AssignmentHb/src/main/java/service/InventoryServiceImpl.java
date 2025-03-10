package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import dao.ItemDAO;
import entity.Item;
import entity.LineItem;
import entity.Order;

public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private ItemDAO itemDAO;
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}
	
	@Override
	public void save(Item item) {
		itemDAO.save(item);
	}
	
	@Override
	public Item get(long id) {
		return itemDAO.get(id);
	}

	@Override
	public List<Item> getAll() {
		return itemDAO.getAll();
	}

	@Override
	public void update(Item item) {
		itemDAO.update(item);
	}

	@Override
	public void delete(long id) {
		itemDAO.delete(id);
	}

	@Override
	public void updateInventory(Order order) {
		// TODO Auto-generated method stub
		for(LineItem lineItem:order.getLineItems()) {
			Item item=itemDAO.get(lineItem.getItem().getId());
			item.setCurrentQuantity(item.getCurrentQuantity()-lineItem.getQuantity());
			item.setReorderQuantity(item.getMaxQuantity()-item.getCurrentQuantity());
			itemDAO.update(item);
		}
		
		
	}

	@Override
	public void deleteInventory(long id) {
		// TODO Auto-generated method stub
		//get item from id,change current quantity and empty reorder quantity
		Item item=itemDAO.get(id);
		item.setCurrentQuantity(item.getMaxQuantity());
		item.setReorderQuantity(0);
		itemDAO.update(item);
	}

}
