package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		EmpDao edao = ctx.getBean("edao", EmpDao.class); 
		
		/*
		Employee e = new Employee();
		
		e.setEmpid("121");
		e.setEmpname("yeswant");
		e.setEmpsalary("34589");
		
		edao.update(e);
		
		Employee e1 = new Employee();
		
		e1.setEmpid("123");
		e1.setEmpname("Melvin");
		e1.setEmpsalary("23456");
		
		edao.save(e1);
		
		Employee e2 = new Employee();
		
		e2.setEmpid("124");
		e2.setEmpname("kiranmai");
		e2.setEmpsalary("783733");
		
		edao.save(e2);
		*/
		Employee e1 = new Employee();
		
		e1.setEmpid("123");
		
		
		edao.delete(e1);
		
		
		System.out.println("Done.");
	}

}
