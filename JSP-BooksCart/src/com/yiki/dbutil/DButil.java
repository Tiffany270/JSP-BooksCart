package com.yiki.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DButil {

	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	static {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://localhost:3306/tiffany?useUnicode=true&characterEncoding=gb2312";
		username = "root";
		password = "";
	}
	public static Connection open() {
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Á¬½Ó´íÎó");
		}
		return null;
	}
	public static void close(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
