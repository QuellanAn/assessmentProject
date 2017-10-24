package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager
				.getConnection(
						"jdbc:mysql://192.168.8.14:3306/test?useUnicode=true&characterEncoding=utf-8",
						"root", "123456");
		// System.out.println("?useUnicode=true&characterEncoding=utf-8");防止乱码
		return conn;
	}
}
