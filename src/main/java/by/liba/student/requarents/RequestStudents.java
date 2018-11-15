package by.liba.student.requarents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Students;
import by.liba.student.common.Util;
import by.liba.student.utils.ConnectToMysql;

public class RequestStudents extends Request<Students> {

	@Override
	public void createListItemS(List<Students> items) {
		// TODO Auto-generated method stub

	}

	@Override
	public Students createItem(Students item) {
		return item;
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteItem(Integer id) {
		Students student = new Students();
		try {
			Connection con = null;
			java.sql.Statement state = null;
			ResultSet res = null;
			String sql = null;

			try {
				con = ConnectToMysql.getConnectionToMysql();
				sql = String.format("DELETE FROM BEGANSS.STUDENT WHERE STUDENT_ID = %s", id);
				state = con.createStatement();
				res = state.executeQuery(sql);
//				while (res.next()) {
//					student.setFirstName(Util.trim(res.getString("FIRST_NAME")));
//					student.setSecondName(Util.trim(res.getString("SECOND_NAME")));
//					student.setId(res.getInt("STUDENT_ID"));
//				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteListItemS(List<Students> items) {
		// TODO Auto-generated method stub

	}

	@Override
	public Students updateItem(Students student) {

		try {
			Connection con = null;
			java.sql.Statement state = null;
			ResultSet res = null;
			String sql = null;
			try {
				con = ConnectToMysql.getConnectionToMysql();
				sql = String.format(
						"UPDATE BEGANSS.STUDENT SET FIRST_NAME = '%s', SECOND_NAME = '%s' WHERE STUDENT_ID = '%s'",
						student.getFirstName(), student.getSecondName(), student.getId());
				state = con.createStatement();
				state.execute(sql);

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public List<Students> updateListItemS(List<Students> items) {
		return items;
	}

	@Override
	public Students getById(Integer id) {
		Students student = new Students();
		try {
			Connection con = null;
			java.sql.Statement state = null;
			ResultSet res = null;
			String sql = null;
			System.out.println("q");

			try {
				con = ConnectToMysql.getConnectionToMysql();
				sql = String.format("SELECT * FROM BEGANSS.STUDENT WHERE STUDENT_ID = %s", id);
				state = con.createStatement();
				res = state.executeQuery(sql);
				while (res.next()) {
					student.setFirstName(Util.trim(res.getString("FIRST_NAME")));
					student.setSecondName(Util.trim(res.getString("SECOND_NAME")));
					student.setId(res.getInt("STUDENT_ID"));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return student;
	}

	public List<Students> getAll() {
		List<Students> students = new ArrayList<Students>();
		try {
			Connection con = null;
			java.sql.Statement state = null;
			ResultSet res = null;
			String sql = null;
			try {
				con = ConnectToMysql.getConnectionToMysql();
				sql = String.format("SELECT * FROM BEGANSS.STUDENT");
				state = con.createStatement();
				res = state.executeQuery(sql);
				while (res.next()) {
					Students student = new Students();
					student.setFirstName(Util.trim(res.getString("FIRST_NAME")));
					student.setSecondName(Util.trim(res.getString("SECOND_NAME")));
					student.setId(res.getInt("STUDENT_ID"));
					students.add(student);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return students;
	}

	public static void main(String[] args) {
		RequestStudents rs = new RequestStudents();
		Students student = rs.getById(1);
		System.out.println(student.toString());
		student.setFirstName("Ivan");
		rs.updateItem(student);
		System.out.println(rs.getById(1).toString());
	}
}
