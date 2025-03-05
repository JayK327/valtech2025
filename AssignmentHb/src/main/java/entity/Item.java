package entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "itemseq")
	@SequenceGenerator(name="itemseq",sequenceName = "item_seq",allocationSize = 1)
	private long id;
	private String name;
	private String description;
    private int currentQuantity;
    private int reorderQuantity;
    private int maxQuantity;	
    
    // One item can appear in multiple line items
    @OneToMany(targetEntity = LineItem.class, mappedBy = "item", cascade = CascadeType.ALL )
    private Set<LineItem> lineItems;

	public Item() {
		super();
	}

	

	public Item(String name, String description, int currentQuantity, int reorderQuantity, int maxQuantity) {
		
		this.name = name;
		this.description = description;
		this.currentQuantity = currentQuantity;
		this.reorderQuantity = reorderQuantity;
		this.maxQuantity = maxQuantity;
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCurrentQuantity() {
		return currentQuantity;
	}
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
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

	public void setLineItems(Set<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public Set<LineItem> getLineItems() {
		return lineItems;
	}



	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", description=" + description + ", currentQuantity="
				+ currentQuantity + ", reorderQuantity=" + reorderQuantity + ", maxQuantity=" + maxQuantity + "]";
	}

	


    
    
    
}
