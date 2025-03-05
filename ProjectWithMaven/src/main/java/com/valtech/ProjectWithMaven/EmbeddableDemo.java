package com.valtech.ProjectWithMaven;

import java.awt.datatransfer.Transferable;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbeddableDemo {
	public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Student student1=new Student();
        student1.setId(12);
        student1.setName("SHIVA");
        student1.setCity("CHENNAI");
        
        Certificate certificate1=new Certificate();
        certificate1.setCourse("Android");
        certificate1.setDuration("2 months");
		student1.setCerti(certificate1);
		
		Student student2=new Student();
        student2.setId(21);
        student2.setName("RAJ");
        student2.setCity("KOLKATA");
        
        Certificate certificate2=new Certificate();
        certificate2.setCourse("WEB");
        certificate2.setDuration("4 months");
		student2.setCerti(certificate2);
		Session s=factory.openSession();
        Transaction tx=s.beginTransaction();
		s.save(student1);
		s.save(student2);

        tx.commit();
		s.close();
        factory.close();
	}
}
