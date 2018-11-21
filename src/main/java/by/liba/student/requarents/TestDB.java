package by.liba.student.requarents;

import java.awt.SystemTray;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Students;
import by.liba.student.utils.Database;

public class TestDB {
	
	
	
	
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("iii");
		Connection con = null;
		ResultSet res = null;
		String sql = null;
		System.out.println("q");
		List<Students> listStudent = new ArrayList<Students>();
		try {
			Database db = new Database();//"jdbc/db"
		System.out.println("iii1");
		con = db.getConnection();         
		java.sql.Statement state = con.createStatement();
		sql = "SELECT * FROM BEGANSS.STUDENT";
		res = state.executeQuery(sql);
		System.out.println("iii2");
		while (res.next()) {
			System.out.println(res.getString("FIRST_NAME").trim());
//				Students student = new Students();
//				student.setId(res.getInt("STUDENT_ID"));
//				student.setFirstName();
//				student.setGroupNumber(res.getString("GROUP_NUMBER").trim());
//				student.setFirstName(res.getString("SECOND_NAME").trim());
//				listStudent.add(student);
//				System.out.println("iii");
		}
		
} finally {
		if (con != null) {
			con.close();
		}
}
    }
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//
//		Connection con = null;
//		ResultSet res = null;
//		String sql = null;
//		System.out.println("q");
//        List<Students> listStudent = new ArrayList<Students>();
//		try {
//			Class.forName("com.ibm.db2.jcc.DB2Driver");
//			con = DriverManager.getConnection(
//					"jdbc:db2://172.20.2.116:5035/DALLASB", "BEGANSS",
//					"j");
//			java.sql.Statement state = con.createStatement();
//			sql = "SELECT * FROM BEGANSS.STUDENT";
//			res = state.executeQuery(sql);
//			
//			while (res.next()) {
//				Students student = new Students();
//				student.setId(res.getInt("STUDENT_ID"));
//				student.setFirstName(res.getString("FIRST_NAME").trim());
//				student.setGroupNumber(res.getString("GROUP_NUMBER").trim());
//				student.setFirstName(res.getString("SECOND_NAME").trim());
//				listStudent.add(student);
//				System.out.println("iii");
//			}
//			System.out.println(listStudent);
//		} finally {
//			if (con != null) {
//				con.close();
//			}
//		}
//	}
}
