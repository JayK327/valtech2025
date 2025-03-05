package com.valtech.ProjectWithMaven;



import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args)throws IOException
    {
        System.out.println( "Project Started....." );
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        //"hibernate.cfg.xml" must be in java folder otherwise give proper path like com/valtech/ProjectWithMaven/hibernate.cfg.xml
        System.out.println(factory);
        //creating student class
        Student st=new Student();
        st.setId(101);
        st.setName("JOHN");
        st.setCity("DELHI");
        

        System.out.println(st);
        
        //creating object of address class
        Address ad=new Address();
        ad.setStreet("street1");
        ad.setCity("DELHI");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(4435.554);
        
        //reading image
        FileInputStream fis=new FileInputStream("src/main/java/xmas.png");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
//        Session session=factory.getCurrentSession();
        Session session=factory.openSession();
        Transaction tx=session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done.....");
    }
}
