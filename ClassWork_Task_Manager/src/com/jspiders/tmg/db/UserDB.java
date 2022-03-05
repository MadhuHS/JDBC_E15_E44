package com.jspiders.tmg.db;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.jspiders.tmg.entities.User;
import com.jspiders.tmg.request.UpdateRequest;

public class UserDB extends DatabaseUtils implements Database {

	Scanner scn = new Scanner(System.in);
	@Override
	public int insert(Object obj) {
		User u1 = (User) obj;// Downcast Object class(Superclass) ref to User class(Sub) ref

		String insertUserQuery = "insert into Appusers.User values(0,?,?,?,?,?);";
		int rowCount = 0;
		connect();

		try {
			PreparedStatement psm = con.prepareStatement(insertUserQuery);

			psm.setString(1, u1.getName());// get the data from User obj and SET it o Placeholder(?)
			psm.setString(2, u1.getEmail());
			psm.setString(3, u1.getPassword());
			psm.setString(4, u1.getMobile());
			psm.setString(5, u1.getGender());

			rowCount = psm.executeUpdate();

		} catch (SQLException e) {
			System.out.println("");
		}

		disConnect();

		return rowCount;
	}

	@Override
	public int update(Object obj) {
		UpdateRequest req = (UpdateRequest) obj;// downcasting

		int code = req.getCode();
		int rowCount = 0;
		
		connect();

		try {
			if (code == 1) {
				String updateEmail = "UPDATE Appusers.user SET email = ? where email = ?;";
				PreparedStatement psm = con.prepareStatement(updateEmail);
				
				psm.setString(1,req.getNewvalue());
				psm.setString(2, req.getOldValue());
				
				rowCount = psm.executeUpdate();

			} else if (code == 2) {
				
				System.out.println("Enter your email id to Update the password");
				String email =scn.next();
				String updatePassword = "UPDATE Appusers.user SET password = ? where password = ? where email = ?;";
			
                 PreparedStatement psm = con.prepareStatement(updatePassword);
				
				psm.setString(1,req.getNewvalue());
				psm.setString(2, req.getOldValue());
				psm.setString(3, email);
			} else {
				String updateMob = "UPDATE Appusers.user SET password = ? where password = ? where email = ?;";

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		disConnect();
		return rowCount;
	}

	@Override
	public int delete(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object selectOne(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> selectMultiple(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
