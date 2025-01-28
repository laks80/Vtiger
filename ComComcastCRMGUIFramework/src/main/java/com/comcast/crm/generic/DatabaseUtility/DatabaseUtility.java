package com.comcast.crm.generic.DatabaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	Connection conn;
	Statement cs;
	public void getDatabaseConnection() throws SQLException {
		Driver d = new Driver();

		DriverManager.registerDriver(d);
		
		//connect to db
	try {	
		 conn = DriverManager.getConnection("jdbc:mysql://49.249.28.218:3333/crm", "root", "root");
		
	}catch (Exception e) {
		
	}	
	}

public void closeDatabaseConnection() {
	try {
		conn.close();
	} catch (SQLException e) {
		
	}
		
	}

public ResultSet executeDatabaseQuery() {
	
	ResultSet rs = null;
	try {
		cs = conn.createStatement();
	
	//execute statement
	rs = cs.executeQuery("select * from product;");
	} catch (SQLException e) {
		
	}
	return rs;
}

public int executeDatabaseUpdate() {
	int res = 0;
	try {
		cs = conn.createStatement();
		res = cs.executeUpdate("insert into product values('10','0','0','0','0','0','mouse','2000','0','0','0','0')");
		
	} catch (SQLException e) {
		
	}
	 return res;
	
}

}
