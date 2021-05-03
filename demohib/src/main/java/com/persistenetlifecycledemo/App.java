package com.persistenetlifecycledemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App {
	
	public static void main(String[] args) {
		
Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Laptop1.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf =con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		//new state
		Laptop1 l = new Laptop1();
		l.setLid(8);
		l.setLname("lenova");
		l.setPrice(12000);
		
		//save or persist state
		session.save(l);
		l.setPrice(80000);
		
		//detach
		//session.detach(l);
		//remove
		//session.remove(l);
		
		l.setPrice(78);
		
		session.getTransaction().commit();
	}

}
