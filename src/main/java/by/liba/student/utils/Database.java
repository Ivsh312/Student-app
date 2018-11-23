package by.liba.student.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Database {

	private DataSource dataSource;


	public Database() {
		try {
			dataSource = (DataSource) new InitialContext().lookup("java:comp/env/" + "jdbc/TestDB");
		} catch (NamingException e) {
			// Handle error that it not configured in JNDI.
			throw new IllegalStateException("jdbc/db2" + " is missing in JNDI!", e);
		}
	}

	public Connection getConnection() throws SQLException {
	    return dataSource.getConnection();
	}

//	public static Connection getConnection() throws ClassNotFoundException, SQLException {
//		Connection con = null;
//		Class.forName("com.mysql.jdbc.Driver");
//		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BEGANSS", "root", "779259vrun13");
//		return con;
//	}
}
