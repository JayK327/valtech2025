package entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "orders")
public class Order {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator = "orderseq")
	@SequenceGenerator(name = "orderseq", sequenceName = "order_seq" ,allocationSize = 1)
	private long id;
    
	@Enumerated(EnumType.STRING)
    private Status status; // e.g., Delivered, On the way(Shipped), Packed,Ordered
    
	public enum Status{
		DELIVERED,ORDERED,PACKED,REJECTED
	}

    // Many orders belong to one customer
    @ManyToOne(targetEntity=Customer.class,cascade = CascadeType.ALL)
    @JoinColumn(name="customer_id",referencedColumnName = "id",nullable = false) 
    private Customer customer;
    
    // One order has many line items
    @OneToMany(targetEntity = LineItem.class,mappedBy = "order", cascade = CascadeType.ALL)
    private List<LineItem> lineItems;
    
	public Order() {
	
	}

	public Order(Status status) {
		super();
		this.status = status;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", status=" + status + "]";
	}
//	public void addLineItems(LineItem lineItem ) {
//		if(lineItems==null) {
//			lineItems=new HashSet<LineItem>();
//		}
//		if (lineItem.getOrder() == null) {
//
//	        System.out.println("LineItem's order is null");
//	    } else {
//	        lineItems.add(lineItem);
//	    }
//			
//		}
//	
//	public void removeLineItem(LineItem lineItem) {
//		if (lineItem != null) {
//            lineItems.remove(lineItem); // Remove the provided lineItem
//        }
//	}
    
    
}
