package com.valtech.training.assignment.entities;

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
@Table(name="customers")
public class Customer {
	public enum CustomerStatus{
		ENABLE, DISABLE
	}

	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cusseq")
	@SequenceGenerator(name = "cusseq", sequenceName = "cus_req", allocationSize = 1, initialValue = 1)
	private int cusId;
	private String name;
	private int age;
	private String address;
	private String permanentAddress;
	
	
	@Enumerated(EnumType.STRING)
	private CustomerStatus cusStatus=CustomerStatus.ENABLE;
	

	
	
	@OneToMany(targetEntity = Order.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY, mappedBy = "customer")
	private Set<Order> orders;
	
	
	public Customer() {}
	public Customer(int cusId, String name, int age, String address, String per_address, CustomerStatus cusStatus) {
		this.cusId = cusId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanentAddress = per_address;
		this.cusStatus = cusStatus;
	}
	

	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", name=" + name + ", age=" + age + ", address=" + address
				+ ", per_address=" + permanentAddress + ", cusStatus=" + cusStatus + ", orders=" + orders + "]";
	}
	public CustomerStatus getCusStatus() {
		return cusStatus;
	}
	
	public void setCusStatus(CustomerStatus cusStatus) {
		this.cusStatus = cusStatus;
	}
	
	public int getCusId() {
		return cusId;
	}
	public void setCusId(int cusId) {
		this.cusId = cusId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String per_address) {
		this.permanentAddress = per_address;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	
}
