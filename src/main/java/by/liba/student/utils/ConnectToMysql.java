package by.liba.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToMysql {
	Connection con = null;
	public static Connection getConnectionToMysql() throws ClassNotFoundException, SQLException {
		Connection con = null;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(
        		"jdbc:mysql://localhost:3306/BEGANSS", "root",
				"123");
		return con;
	}
}
