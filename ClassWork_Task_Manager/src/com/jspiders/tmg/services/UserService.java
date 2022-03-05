package com.jspiders.tmg.services;

import java.util.Scanner;

import com.jspiders.tmg.db.UserDB;
import com.jspiders.tmg.entities.User;

public class UserService {

	Scanner scn = new Scanner(System.in);
	UserDB db = new UserDB();
	
	public void signup()
	{
		System.out.println("Enter your name");
		String name = scn.next();// string inputs

		System.out.println("Enter your Email ID");
		String email = scn.next();

		System.out.println("Enter Password");
		String password = scn.next();

		System.out.println("Enter Mobile No.");
		String mobile = scn.next();

		System.out.println("Enter Gender");
		String gender = scn.next();
		
		User u1 = new User();//Create User entity object
		
		//SET the inputs to the User entity object using setter methods
		u1.setUID(0);
		u1.setName(name);
		u1.setEmail(email);
		u1.setPassword(password);
		u1.setMobile(mobile);
		u1.setGender(gender);

		db.insert(u1);
		
		System.out.println("User account successfully created!!");
	}
}
