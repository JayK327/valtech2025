package service;

import java.util.List;

import entity.Item;

public interface ItemService {
	void save(Item item);

	Item get(int id);

	List<Item> getAll();

	void update(Item item);

	void delete(int id);
}
