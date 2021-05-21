package com.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	
	public static void main(String[] args) {
		
		//configuration class object
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate.cfg.xml");
		
		//sessionfactory interface 
		SessionFactory sf = cfg.buildSessionFactory();
		
		//session object
		Session session = sf.openSession();
		
		//Transaction object
		Transaction t = session.beginTransaction();
		
		Employee e = new Employee();//transient state
		
		e.setEmpname("Yeswant");
		e.setSalary("898988");
		
		session.persist(e);//persistence
		
		t.commit();
		
		System.out.println("Done.");
		
	}

}
