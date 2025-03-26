package com.valtech.ServletEx;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws LifecycleException
    {
        System.out.println( "Hello World!" );
        Tomcat tomcat=new Tomcat();
        tomcat.setPort(8082);

        
        Context context=tomcat.addContext("", null);
        Tomcat.addServlet(context, "HelloServlet", new HelloServlet());
        context.addServletMappingDecoded("/helloo", "HelloServlet");
        
        tomcat.start();
        tomcat.getServer().await();
    }
}
