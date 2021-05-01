package com.telusko.demohib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	
	public static void main(String[] args) {
		
		Alien telusko = new Alien();
		
		AlienName an = new AlienName();
		an.setFname("govindan");
		an.setLname("ramyaa");
		an.setMname("dhanasekaran");
		
		telusko.setAid(10);
		telusko.setAname(an);
		telusko.setColour("blue");
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf =con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tf = session.beginTransaction(); 
		//telusko = (Alien) session.get(Alien.class, 10);
		
		session.save(telusko);
		tf.commit();
		System.out.println(telusko);
		
		
	}

}
