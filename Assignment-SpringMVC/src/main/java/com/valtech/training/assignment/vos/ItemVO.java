package com.valtech.training.assignment.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.assignment.entities.Item;

public record ItemVO(int itemId, String name, String description, int quantity, int reorderQuantity, int maxQuantity) {

	
	public static ItemVO from(Item i) {
		return new ItemVO(i.getItemId(), i.getName(), i.getDescription(), i.getQuantity(), i.getReorderQuantity(), i.getMaxQuantity());
	}
	
	public Item to() {
		Item i = new Item(itemId, name, description, quantity, reorderQuantity, maxQuantity);
		return i;
	}
	
	public static List<ItemVO> from(List<Item> item){
		return item.stream().map(i -> ItemVO.from(i)).collect(Collectors.toList());
	}
}
