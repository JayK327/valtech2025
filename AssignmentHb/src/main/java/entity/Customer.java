package entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="customers")
public class Customer {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "custseq")
	@SequenceGenerator(name = "custseq", sequenceName = "cust_seq" ,allocationSize = 1)
	private long id;
	private String name;
	private int age;
	private String address;
	private String permanentAddress;
	
    // One customer can have multiple orderss
	@OneToMany(targetEntity = Order.class,mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Order> orders;

	public Customer(String name, int age, String address, String permanentAddress) {
		
		this.name = name;
		this.age = age;
		this.address = address;
		this.permanentAddress = permanentAddress;

	}
	public Customer() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	

	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", permanentAddress="
				+ permanentAddress +  "]";
	}
	public void addOrder(Order order) {
		if(orders==null) orders=new HashSet<Order>();
		orders.add(order);
			order.setCustomer(this);	
			
		}
	
	public void removeOrder(Order order) {
		orders.remove(order);
		order.setCustomer(null);
	}
	
}
