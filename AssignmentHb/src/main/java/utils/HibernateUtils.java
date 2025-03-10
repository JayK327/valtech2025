package utils;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.ItemDAO;
import dao.ItemDAOImpl;
import dao.LineItemDAO;
import dao.LineItemDAOImpl;
import dao.OrderDAO;
import dao.OrderDAOImpl;
import entity.Customer;
import entity.Customer.CustomerStatus;
import entity.Item;
import entity.LineItem;
import entity.Order;
import entity.Order.Status;
import service.CustomerService;
import service.InventoryService;
import service.ItemService;
import service.LineItemService;
import service.OrderService;

public class HibernateUtils {
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("hibernate.xml");
		CustomerService customerService=ctx.getBean(CustomerService.class);
		OrderService orderService=ctx.getBean(OrderService.class);
		InventoryService inventoryService=ctx.getBean(InventoryService.class);
//		LineItemService lineItemService=ctx.getBean(LineItemService.class);

		
		CustomerDAO customerDAO=ctx.getBean(CustomerDAOImpl.class);
		ItemDAO itemDAO=ctx.getBean(ItemDAOImpl.class);
		OrderDAO orderDAO=ctx.getBean(OrderDAOImpl.class);
		LineItemDAO lineItemDAO=ctx.getBean(LineItemDAOImpl.class);
		
//		Item i=new Item("Laptop", "MacBookM4", 10, 10,20);
//		Item i1=new Item("Phone", "Pixel9", 8, 10 ,10);
//		Item i2=new Item("Phone", "Iphone16", 10, 5,10);
//		Item i3=new Item("Laptop", "TufF15", 15, 10,20);
//		Item i4=new Item("Phone", "GalaxyS22", 10, 10,20);
//		
//		itemDAO.save(i);
//		itemDAO.save(i1);
//		itemDAO.save(i2);
//		itemDAO.save(i3);
//		itemDAO.save(i4);
//		
//		Customer c=new Customer("Rohan",25,"Delhi","Delhi");
//		Customer c1=new Customer("Raj",27,"Mumbai","Mumbai");
//		Customer c2=new Customer("Simran",26,"Pune","Pune");
//		Customer c3=new Customer("Kajal",22,"Chennai","Chennai");
//		Customer c4=new Customer("Payal",23,"Kolkata","Kolkata");
//		
//		customerDAO.save(c);
//		customerDAO.save(c1);
//		customerDAO.save(c2);
//		customerDAO.save(c3);
//		customerDAO.save(c4);

		Customer cust=customerService.get(2);  
		System.out.println(cust.toString());
		cust.setName("Rohit");
		System.out.println(cust.toString());
		
		Item item=inventoryService.get(1);
		System.out.println(item.toString());
		
		LineItem lineItem=new LineItem();
		lineItem.setItem(item);
		lineItem.setQuantity(2);
		
		
		Order order=new Order();
		order.setCustomer(cust);
		
		lineItem.setOrder(order);
		
		
		order.setLineItems(Arrays.asList(lineItem));
		orderService.save(order);
		System.out.println(order.getStatus());     //PACKED
		
		LineItem lineItem1=new LineItem();    
		lineItem1.setItem(inventoryService.get(4));
		lineItem1.setQuantity(17);
		
		
		Order order1=new Order();
		order1.setCustomer(customerService.get(3));
		
		lineItem1.setOrder(order1);
		order1.setLineItems(Arrays.asList(lineItem1));
		orderService.save(order1);
		System.out.println(order1.getStatus());  ////Rejected due to currentQ<orderedQ
		
		cust.setCustomerStatus(CustomerStatus.DISABLE); //Checking CustomerStatus
		customerService.update(cust);
		lineItem1.setItem(inventoryService.get(4));
		lineItem1.setQuantity(17);
		
		
		Order order2=new Order();
		order2.setCustomer(customerService.get(2));
		
		order2.setLineItems(Arrays.asList(lineItem));
		orderService.save(order2);
		System.out.println(order2.getStatus());
				
		
//		ctx.close();
	
	}

}

