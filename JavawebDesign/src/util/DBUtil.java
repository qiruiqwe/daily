package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/javaweb", "root", "123456qirui3");
		} catch (ClassNotFoundException e) {
			System.err.println("数据库驱动类没有找到");
		} catch (SQLException e) {
			System.err.println("获取数据库连接失败");
		}
		return connection;
	}
}