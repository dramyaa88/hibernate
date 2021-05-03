package com.hqldemo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.Query;
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
		
//		Query q = session.createQuery("from Student where rollno = 5");
//		Query q = session.createQuery("select rollno,name from Student where rollno = 7");
//		Object[] student = (Object[]) q.uniqueResult();
//		
//		System.out.println(student[0]+" : "+student[1]);
		int b = 60;
		Query q = session.createQuery("select sum(marks) from Student s where s.marks>"+b);
		//Object marks = (Object)q.uniqueResult();
		Long marks = (Long)q.uniqueResult();
		System.out.println(marks);
//		for(Object o : student)
//		{
//			System.out.println(o);
//		}
//		System.out.println(student);
		
//		Query q = session.createQuery("from Student");
//		Query q = session.createQuery("from Student where marks>50");
//		List<Student> students = new ArrayList<Student>(q.list());
//		
//		for(Student s : students)
//		{
//			System.out.println(s);
//		}
//		for(Student t1 : students);
//		{
//			System.out.println(t1);
//		}
//		Random r = new Random();
//		
//		for(int i=1;i<=50;i++)
//		{
//			Student s = new Student();
//			s.setRollno(i);
//			s.setName("Name "+i);
//			s.setMarks(r.nextInt(100));
//			session.save(s);
//		}
		session.getTransaction().commit();
	}
	
	
	
	

}
