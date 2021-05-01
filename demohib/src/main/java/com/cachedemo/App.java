package com.cachedemo;



import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class App {
	
	public static void main(String[] args) {
		
		Alien a = null;
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Alien.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf =con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		session.beginTransaction();
		Query q1 = session.createQuery("from Alien where aid = 3");
		q1.setCacheable(true);
		a = (Alien)q1.uniqueResult();
		
		System.out.println(a);
		
		session.getTransaction().commit();
		session.close();
		
		Session session2 = sf.openSession();
		session2.beginTransaction();
		Query q2 = session2.createQuery("from Alien where aid = 3");
		q2.setCacheable(true);
		a = (Alien)q2.uniqueResult();
		//a = (Alien) session2.get(Alien.class, 2);
		
		System.out.println(a);
		
		session2.getTransaction().commit();
		session2.close();
	}

}
