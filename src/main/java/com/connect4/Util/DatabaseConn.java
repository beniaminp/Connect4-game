package com.connect4.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConn {
	public Connection openDB() {
 		Connection conn = null;
 		try {
 			Class.forName("org.h2.Driver");
 			conn = DriverManager.getConnection("jdbc:h2:~/gameDB;IFEXISTS=TRUE", "", "");
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
 			StringBuilder sql = new StringBuilder("CREATE TABLE IF NOT EXISTS GAME_SESSION (gameId bigint auto_increment");
 			for(int i = 0; i < 7; ++i){
 				for(int j = 0; j < 7; ++j ){
 					sql.append(",a"+i+j +" INTEGER");
 				}
 			}
 			sql.append(")");
 			stmt.executeUpdate(sql.toString());
 			stmt.close();
 		} catch (SQLException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
	}
 	
 	public Integer[][] getByGameId(int gameId){
 		Statement stmt = null;
 		Integer[][] myBoard = new Integer[7][7];
 		try {
 			stmt = openDB().createStatement();
 			String selectTableSQL = "SELECT * FROM GAME_SESSION WHERE gameId="+gameId;
 			ResultSet rs = stmt.executeQuery(selectTableSQL);
 			while (rs.next()) {
 	 			for(int i = 0; i < 7; ++i){
 	 				for(int j = 0; j < 7; ++j ){
 	 					myBoard[i][j] = rs.getInt("a"+i+j);
 	 				}
 	 			}
 			}
 			stmt.close();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return myBoard;
 	}
 	
 	public void insertAt(int gameId, int i, int j, Integer player){
 		Statement stmt = null;
 		try {
 			stmt = openDB().createStatement();
 			String insert = "UPDATE GAME_SESSION SET a"+i+j+" = "+player+" WHERE gameId="+gameId;
 			stmt.executeUpdate(insert);
 			stmt.close();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}
 	
 	public int insertGame(){
 		Statement stmt = null;
 		int gameId = 0;
 		try {
 			stmt = openDB().createStatement();
 			String insert = "INSERT INTO GAME_SESSION DEFAULT VALUES";
 			stmt.executeUpdate(insert);
 			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
 	            if (generatedKeys.next()) {
 	               gameId = generatedKeys.getInt(1);
 	            }
 	            else {
 	                throw new SQLException("Creating user failed, no ID obtained.");
 	            }
 	        }
 			stmt.close();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 		return gameId;
 	}
 	
 	public void deleteByGameId(int gameId){
 		Statement stmt = null;
 		try {
 			stmt = openDB().createStatement();
 			String delete = "DELETE FROM GAME_SESSION WHERE gameId="+gameId;
 			stmt.executeUpdate(delete);
 			stmt.close();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}
}
