package service;

import java.util.List;

import dao.LineItemDAO;
import entity.LineItem;

public class LineItemServiceImpl implements LineItemService {
	
	private LineItemDAO lineItemDAO;
	@Override
	public void save(LineItem item) {
		lineItemDAO.save(item);
	}

	@Override
	public LineItem get(int id) {
		return lineItemDAO.get(id);
	}

	@Override
	public List<LineItem> getAll() {
		return lineItemDAO.getAll();
	}

	@Override
	public void update(LineItem item) {
		lineItemDAO.update(item);
	}

	@Override
	public void delete(int id) {
		lineItemDAO.delete(id);
	}

}
