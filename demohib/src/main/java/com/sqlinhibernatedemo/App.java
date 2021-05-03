package com.sqlinhibernatedemo;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hqldemo.Student;

import net.sf.ehcache.search.expression.Criteria;

public class App {

public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);
		
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry();
		SessionFactory sf =con.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		
		//native queries
		SQLQuery query = session.createSQLQuery("select * from student where marks>60");
		query.addEntity(Student.class);
		List<Student> students = query.list();
		for(Student s :students)
		{
			System.out.println(s);
		}
		
//		SQLQuery query = session.createSQLQuery("select name,marks from student where marks>60");
//		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP=);
//		List students = query.list();
//		for(Object o :students)
//		{
//			Map m =(Map)o;
//			System.out.println(m.get("name")+" : "+m.get("marks"));
//		}
		
		session.getTransaction().commit();
}
}
