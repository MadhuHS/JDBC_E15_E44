package com.jspiders.tmg.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DatabaseUtils {

	private final String dbUrl = "jdbc:mysql://localhost:3306/appusers";
	private final String dbUser = "root";
	private final String dbPass = "root";

    Connection con = null;

	 void connect() {
		try {
			con = DriverManager.getConnection(dbUrl, dbUser, dbPass);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	 void disConnect() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
