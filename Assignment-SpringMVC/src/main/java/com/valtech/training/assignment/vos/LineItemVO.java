package com.valtech.training.assignment.vos;

import java.util.List;
import java.util.stream.Collectors;

import com.valtech.training.assignment.entities.Item;
import com.valtech.training.assignment.entities.LineItem;
import com.valtech.training.assignment.entities.Order;
public record LineItemVO(int id, int quantity, Item item, Order order) {

	public static LineItemVO from(LineItem li) {
		return new LineItemVO(li.getId(), li.getQuantity(), li.getItem(), li.getOrder());
	}
	
	public static List<LineItemVO> from(List<LineItem> li){
		return li.stream().map(lis -> LineItemVO.from(lis)).collect(Collectors.toList());
	}
	
	
	public LineItem to() {
		LineItem li = new LineItem(id, quantity, item, order);
		return li;
	}
}
