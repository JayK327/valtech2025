package service;

import java.util.List;

import entity.LineItem;

public interface LineItemService {
	void save(LineItem item);

	LineItem get(int id);

	List<LineItem> getAll();

	void update(LineItem item);

	void delete(int id);
}
