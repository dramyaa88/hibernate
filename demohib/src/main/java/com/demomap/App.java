package com.demomap;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.telusko.demohib.Alien;

public class App {
	
	public static void main(String[] args) {
		
//		Laptop laptop = new Laptop();
//		laptop.setLid(101);
//		laptop.setLname("Dell");
//		
//		
//		Student s = new Student();
//		s.setRollno(1);
//		s.setName("Ramyaa");
//		s.setMarks(98);
//		s.getLaptop().add(laptop);
//		
//		laptop.getStudent().add(s);
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf =con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		session.beginTransaction();
//		session.save(laptop);
//		session.save(s);
		
		Student s1 = (Student) session.get(Student.class, 1);
		
		session.getTransaction().commit();
	}

}
