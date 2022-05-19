package com.todo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ToDoDAO {

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs  = null;

	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void disConnect() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 리스트.
//	public List<ToDo> getList() {
//		String sql = "select * from todo_list";
//
//		getConnect();
//
//		List<ToDo> list = new ArrayList<>();
//		
//		try {
//			psmt = conn.prepareStatement(sql);
//			rs = psmt.executeQuery();
//			ToDo td = new ToDo();
//			while (rs.next()) {
//				td.setCode(rs.getString("todo_code"));
//				td.setCont(rs.getString("todo_cont"));
//				td.setCheck(rs.getInt("todo_check"));
//				list.add(td);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			disConnect();
//		}
//		return list;
//	}

	public void addEvent(String val) {
		
		getConnect();
		
		String sql = "INSERT INTO todo_list (\n"+
				"    todo_code,\n"+
				"    todo_cont,\n"+
//				"    todo_check\n"+
				") VALUES (\n"+
				"    'td' || code_seq.NEXTVAL,\n"+
				"    ?,\n"+
//				"    ?\n"+
				")";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, val);
//			psmt.setInt(2, td.getCheck());
			int r = psmt.executeUpdate();
			
			System.out.println(r + "건 입력");
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
	}

}
