package com.pro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

	public Connection conn;
	Statement stmt;
	public ResultSet rs;
	public PreparedStatement psmt;

	public Connection getConnect() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
//			conn = DriverManager.getConnection("jdbc:oracle:thin:@dbdeuxist01_high?TNS_ADMIN=C:\\\\Dev\\\\Wallet_DBdeuxist01", "admin", "Yd0534212460");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void disConnect() {
		try {
			if (rs != null)
				rs.close();

			if (stmt != null)
				stmt.close();

			if (conn != null)
				conn.close();

			if (psmt != null)
				psmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
