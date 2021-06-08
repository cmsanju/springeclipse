package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserValidater 
{
	public static void validateUser(String username)
	{
		List<String> users = new ArrayList<String>();
		users.add("alekya");
		
		
		//User usr = userDao.findAll();
		
			if(users.contains(username))
			{
				System.out.println("user already existed : "+username);
				
			}
			else
			{
				System.out.println(" user added");

				users.add(username);
			}
			
			System.out.println(users);
			
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter user name ");
		
		String user = sc.next();
		
		
		validateUser(user);
	}
}
