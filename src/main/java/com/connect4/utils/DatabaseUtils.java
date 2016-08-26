package com.connect4.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
	public Connection openDB() {
		Connection conn = null;
		try {
			Class.forName("org.h2.Driver");
			conn = DriverManager.getConnection("jdbc:h2:~/gameDB;IFEXISTS=FALSE", "", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void createTables() {
		Statement stmt = null;
		try {
			stmt = openDB().createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS USER (userId bigint auto_increment, userName VARCHAR(255))";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String insertUsers(String firstUser, String secondUser){
		Statement stmt = null;
		try {
			stmt = openDB().createStatement();
			String sql = "INSERT INTO USER(userName) VALUES('"+firstUser+"'), ('"+secondUser+"');";
			stmt.executeUpdate(sql);
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
