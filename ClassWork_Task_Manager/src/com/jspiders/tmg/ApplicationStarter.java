package com.jspiders.tmg;

import com.jspiders.tmg.services.UserService;

public class ApplicationStarter {

	public static void main(String[] args) 
	{
		UserService us1 = new UserService();
		
		//us1.signup();
		us1.updateProfile();
	}
}
