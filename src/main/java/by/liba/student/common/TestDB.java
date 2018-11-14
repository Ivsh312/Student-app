package by.liba.student.common;

import java.awt.SystemTray;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = null;
		ResultSet res = null;
		String sql = null;
        List<Students> listStudent = new ArrayList<Students>();
		try {
			Class.forName("com.ibm.db2.jcc.DB2Driver");
			con = DriverManager.getConnection(
					"jdbc:db2://172.20.2.116:5035/DALLASB", "BEGANSS",
					"j");
			java.sql.Statement state = con.createStatement();
			sql = "SELECT * FROM BEGANSS.STUDENT";
			res = state.executeQuery(sql);
			
			while (res.next()) {
				Students student =new Students();
				student.setId(res.getInt("STUDENT_ID"));
				student.setFirstName(res.getString("FIRST_NAME").trim());
				student.setGroupNumber(res.getString("GROUP_NUMBER").trim());
				student.setFirstName(res.getString("SECOND_NAME").trim());
				listStudent.add(student);
				System.out.println("iii");
			}
			System.out.println(listStudent);
		} finally {
			if (con != null) {
				con.close();
			}
		}
	}
}
