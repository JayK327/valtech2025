package service;

import java.util.List;

import entity.Item;
import entity.Order;

public interface InventoryService {
	void save(Item item);

	Item get(long id);

	List<Item> getAll();

	void update(Item item);

	void delete(long id);
	
	void updateInventory(Order order);
	
	void deleteInventory(long id);
	
}
