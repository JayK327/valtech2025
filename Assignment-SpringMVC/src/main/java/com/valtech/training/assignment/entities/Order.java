package com.valtech.training.assignment.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
@Table(name = "orders")
public class Order {

	
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq", allocationSize = 1)
	private int orderId;
	
	@Enumerated(EnumType.STRING)
	private Status status;
	public enum Status{
		PACKED, DELIVERED, IN_WAREHOUSE, REJECTED
	}
	
	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "customerId", referencedColumnName = "cusId")
	private Customer customer;
	
	@OneToMany(targetEntity = LineItem.class, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY, mappedBy = "order")
	private List<LineItem> lineItems;

	
	public Order() {}
//	public Order(Status status) {
//		this.status = status;
//	}
	public Order(int orderId, Status status) {
		this.orderId = orderId;
		this.status = status;
	
	}
	public Order(int orderId, Status status, Customer customer, List<LineItem> lineItems) {
		this.orderId = orderId;
		this.status = status;
		this.customer = customer;
		this.lineItems = lineItems;
	}
	public Order(int orderId, Customer customer, List<LineItem> lineItems) {
		this.orderId = orderId;
		this.customer = customer;
		this.lineItems = lineItems;
	}
	
	
	
	
	public void addLineItem(LineItem li) {
		if(lineItems == null) lineItems = new ArrayList<LineItem>();
		lineItems.add(li);
		li.setOrder(this);
		
	}
	public void removeLineItem(LineItem li) {
		lineItems.remove(li);
		li.setOrder(null);
	}
	
	
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> getLineItems) {
		this.lineItems = getLineItems;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	
	
}
