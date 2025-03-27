package com.valtech.training.assignment.services;

import java.util.List;

import com.valtech.training.assignment.entities.Customer;
import com.valtech.training.assignment.entities.Item;
import com.valtech.training.assignment.vos.ItemVO;

public interface ItemService {

	ItemVO save(ItemVO itemVO);

	ItemVO update(ItemVO itemVO);

	void delete(Item i);
	
	ItemVO getItem(int id);
	
	List<ItemVO> getAll();
	
}
