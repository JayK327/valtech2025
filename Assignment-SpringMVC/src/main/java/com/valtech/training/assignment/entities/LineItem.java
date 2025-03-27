package com.valtech.training.assignment.entities;

import java.util.List;

import com.valtech.training.assignment.entities.Item;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="lineitems")
public class LineItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idseq")
	@SequenceGenerator(name = "idseq", sequenceName = "id_seq", allocationSize = 1)
	private int id;
	private int quantity;
	
	
	@ManyToOne(targetEntity = Item.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "item_Id", referencedColumnName = "itemId")
	private Item item;
	
	@ManyToOne(targetEntity = Order.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "order_id", referencedColumnName = "orderId")
	private Order order;

	
	public LineItem() {}
	public LineItem(int quantity) {
		this.quantity = quantity;
	}
	public LineItem(int id, int quantity) {
		this.id = id;
		this.quantity = quantity;
	}
	public LineItem(int id, int quantity, Item item, Order order) {
		this.id = id;
		this.quantity = quantity;
		this.item = item;
		this.order = order;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
	
	
	
	

}
