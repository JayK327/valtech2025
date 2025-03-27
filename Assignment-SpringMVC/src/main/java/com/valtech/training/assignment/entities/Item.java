package com.valtech.training.assignment.entities;

import java.util.List;
import java.util.Set;

import com.valtech.training.assignment.entities.LineItem;

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
@Table(name="items")
public class Item {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemseq")
	@SequenceGenerator(name = "itemseq", sequenceName = "item_seq", allocationSize = 1)
	private int itemId;
	private String name;
	private String description;
	private int quantity;
	private int reorderQuantity;
	private int maxQuantity;
	
	
	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "item")
	private List<LineItem> getLineItems;
	
	
	public Item() {}
	public Item(int itemId, String name, String description, int quantity, int reorderQuantity, int maxQuantity) {
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.reorderQuantity = reorderQuantity;
		this.maxQuantity = maxQuantity;
	}
	
	
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", name=" + name + ", description=" + description + ", quantity=" + quantity
				+ ", reorderQuantity=" + reorderQuantity + ", maxQuantity=" + maxQuantity + "]";
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getReorderQuantity() {
		return reorderQuantity;
	}
	public void setReorderQuantity(int reorderQuantity) {
		this.reorderQuantity = reorderQuantity;
	}
	public int getMaxQuantity() {
		return maxQuantity;
	}
	public void setMaxQuantity(int maxQuantity) {
		this.maxQuantity = maxQuantity;
	}
	
	
	

}
