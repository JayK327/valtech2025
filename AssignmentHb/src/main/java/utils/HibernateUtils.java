package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CustomerDAO;
import dao.CustomerDAOImpl;
import dao.ItemDAO;
import dao.ItemDAOImpl;
import dao.OrderDAO;
import dao.OrderDAOImpl;
import entity.Customer;
import entity.Item;
import entity.LineItem;
import entity.Order;
import entity.Order.Status;
import service.CustomerService;
import service.ItemService;
import service.LineItemService;
import service.OrderService;

public class HibernateUtils {
public static void main(String[] args) {
		
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("hibernate.xml");
		CustomerService customerService=ctx.getBean(CustomerService.class);
		OrderService orderService=ctx.getBean(OrderService.class);
		ItemService itemService=ctx.getBean(ItemService.class);
		LineItemService lineItemService=ctx.getBean(LineItemService.class);

		
		CustomerDAO customerDAO=ctx.getBean(CustomerDAOImpl.class);
		ItemDAO itemDAO=ctx.getBean(ItemDAOImpl.class);
		OrderDAO orderDAO=ctx.getBean(OrderDAOImpl.class);
		
		Item i=new Item("Laptop", "MacBookM4", 10, 10,20);
		Item i1=new Item("Phone", "Pixel9", 3, 3 ,6);
		Item i2=new Item("Phone", "Iphone16", 5, 5,10);
		Item i3=new Item("Laptop", "TufF15", 10, 10,20);
		Item i4=new Item("Phone", "GalaxyS22", 5, 5,10);
		
		itemDAO.save(i);
		itemDAO.save(i1);
		itemDAO.save(i2);
		itemDAO.save(i3);
		itemDAO.save(i4);
		
		Customer c=new Customer("Rohan",25,"Delhi","Delhi");
		Customer c1=new Customer("Raj",27,"Mumbai","Mumbai");
		Customer c2=new Customer("Simran",26,"Pune","Pune");
		Customer c3=new Customer("Kajal",22,"Chennai","Chennai");
		Customer c4=new Customer("Payal",23,"Kolkata","Kolkata");
		
		customerDAO.save(c);
		customerDAO.save(c1);
		customerDAO.save(c2);
		customerDAO.save(c3);
		customerDAO.save(c4);

		
		LineItem l=new LineItem();
		l.setItem(itemService.get(1));
		l.setQuantity(1);
		LineItem l1=new LineItem();
		l1.setItem(itemService.get(2));
		l1.setQuantity(1);
		LineItem l2=new LineItem();
		l2.setItem(itemService.get(4));
		l2.setQuantity(1);
		
		Order ord=new Order();
		ord.setCustomer(customerService.get(2));
		ord.addLineItems(l);
		ord.addLineItems(l1);
		ord.setStatus(Status.ORDERED);
		orderService.save(ord);

		System.out.println(customerService.getClass().getName());
		Customer customer=customerService.get(1);
		System.out.println(customer.getAge());
		customer.setAge(34);
		System.out.println(customer.getAge());
		customerService.update(customer);
		customerService.save(new Customer("Ajay",20,"Ahmedabad","Ahmedabad"));
		ctx.close();
	
	}

}

