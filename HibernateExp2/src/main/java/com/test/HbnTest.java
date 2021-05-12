package com.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HbnTest {
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		SessionFactory sf = cfg.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		//what is java language; 2 what is hibernate
		
		Answer ans1 = new Answer();
		
		ans1.setAnswers("java is multithreaded programming");
		ans1.setAuthor("Alekya");
		
		Answer ans2 = new Answer();
		ans2.setAnswers("Java is object oriented");
		ans2.setAuthor("vvss");
		
		Answer ans3 = new Answer();
		
		ans3.setAnswers("Hibernate is ORM tool");
		ans3.setAuthor("GS");
		
		Answer ans4 = new Answer();
		
		ans4.setAnswers("Hibernate is database independent");
		ans4.setAuthor("Meghan");
		
		List<Answer> ansList1 = new ArrayList<Answer>();
		
		ansList1.add(ans1);
		ansList1.add(ans2);
		
		List<Answer> ansList2 = new ArrayList<Answer>();
		
		ansList2.add(ans3);
		ansList2.add(ans4);
		
		Question q1 = new Question();
		
		q1.setQname("What is Java");
		q1.setAnswers(ansList1);
		
		Question q2 = new Question();
		
		q2.setQname("What is hibernate");
		q2.setAnswers(ansList2);
		
		session.save(q1);
		session.save(q2);
		
		t.commit();
		
		System.out.println("Done.");
		
		
	}

}
