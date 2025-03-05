package com.valtech.ProjectWithMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//get ,load
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session=factory.openSession();
        
        Student student=(Student)session.get(Student.class, 101);
        System.out.println(student);
        
        Student student1=(Student)session.load(Student.class, 102);
        
        
 
        Address ad=(Address)session.get(Address.class, 1);
        System.out.println(ad.getStreet()+  ":"+ ad.getCity());
        
        Address ad1=(Address)session.get(Address.class, 1);
        System.out.println(ad1.getStreet()+  ":"+ ad1.getCity());
        
        session.close();
        factory.close();

	}

}
