package entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "line_items")
public class LineItem {
	@Id@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "lineItem")
	@SequenceGenerator(name = "lineItem",sequenceName = "line_item" ,allocationSize = 1)
    private long id;

    private int quantity;
    
    // Many line items belong to one order
    @ManyToOne(targetEntity = Order.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id",referencedColumnName = "id", nullable = false)
    private Order order;

    // Many line items refer to one item
    @ManyToOne(targetEntity = Item.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "item_id",referencedColumnName = "id", nullable = false)
    private Item item;

	public LineItem() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public LineItem(int quantity) {
		super();
		
		this.quantity = quantity;
		
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}



	@Override
	public String toString() {
		return "LineItem [id=" + id + ", quantity=" + quantity + ", order=" + order + ", item=" + item + "]";
	}

	
    
}
