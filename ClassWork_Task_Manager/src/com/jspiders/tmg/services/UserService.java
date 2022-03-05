package com.jspiders.tmg.services;

import java.util.Scanner;

import com.jspiders.tmg.db.UserDB;
import com.jspiders.tmg.entities.User;
import com.jspiders.tmg.request.UpdateRequest;

public class UserService {

	Scanner scn = new Scanner(System.in);
	UserDB db = new UserDB();

	public void signup() {
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

		User u1 = new User();// Create User entity object

		// SET the inputs to the User entity object using setter methods
		u1.setUID(0);
		u1.setName(name);
		u1.setEmail(email);
		u1.setPassword(password);
		u1.setMobile(mobile);
		u1.setGender(gender);

		db.insert(u1);

		System.out.println("User account successfully created!!");
	}

	public void updateProfile() {
		System.out.println("What do you want to update");

		System.out.println("1. Update Email");
		System.out.println("2. Update Password");
		System.out.println("3. Update Mobile");

		int choice = scn.nextInt();
		
		UpdateRequest req1 = new UpdateRequest();

		if (choice == 1) 
		{
			System.out.println("Please enter your old email id");
			String oldEmail = scn.next();

			System.out.println("Please enter your new email id");
			String newEmail = scn.next();
			
			req1.setCode(choice);
			req1.setOldValue(oldEmail);
			req1.setNewvalue(newEmail);
			
		} else if (choice == 2) {
			System.out.println("Please enter your old password");
			String oldPassword = scn.next();

			System.out.println("Please enter your new password");
			String newPassword = scn.next();
			
			req1.setCode(choice);
			req1.setOldValue(oldPassword);
			req1.setNewvalue(newPassword);
		}
		else if(choice == 3)
		{
			System.out.println("Please enter your old Mobile no.");
			String oldMob = scn.next();

			System.out.println("Please enter your new Mobile no");
			String newMob = scn.next();
			
			req1.setCode(choice);
			req1.setOldValue(oldMob);
			req1.setNewvalue(newMob);
		}
		else
		{
			System.out.println("INVALID CHOICE");
		}
		
		db.update(req1);

		System.out.println("User profile updated");
	}
}
