package com.hqldemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;



public class App {
	
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf =con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		
		for(int i=1;i<=50;i++)
		{
			
		}
		session.getTransaction().commit();
	}
	
	
	
	

}
