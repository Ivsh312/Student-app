package by.liba.student.requarents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.taglibs.standard.tag.el.sql.TransactionTag;

import by.liba.student.common.Groups;
import by.liba.student.common.Students;
import by.liba.student.common.Util;
import by.liba.student.utils.Database;
import filters.StudentFilter;

public class RequestStudents implements Request<Students, StudentFilter> {
	Database database = new Database();

	@Override
	public void createListItems(List<Students> items) {
		// TODO Auto-generated method stub

	}

	@Override
	public Students updateItem(Students item) {
		return item;
		// TODO Auto-generated method stub

	}

	@Override
	public Students deleteItem(Students item) {
		return item;
		// TODO Auto-generated method stub

	}

	@Override
	public List<Students> deleteListItems(List<Students> items) {
		return items;
		// TODO Auto-generated method stub

	}

	@Override
	public void createItem(Students student) {
		PreparedStatement preparedStatement = null;
		RequestGroup requestGroup = null;
		Connection con = null;
		java.sql.Statement state = null;
		ResultSet res = null;
		String sql = null;
		try {
			con = database.getConnection();
			con.setAutoCommit(false);
			requestGroup = new RequestGroup();
			if (requestGroup.getGroupNumberInTransaction(student.getGroupNumber(), con) == null) {
				Groups group = new Groups();
				group.setGroupNumber(student.getGroupNumber());
				requestGroup.createItem(group);
			}
			sql = "INSERT INTO `beganss`.`student`"
					+ " (`STUDENT_ID`, `FIRST_NAME`, `SECOND_NAME`, `AVG_MARK`, `GROUP_NUMBER`) "
					+ "VALUES ('?', '?', '?', '?', '?')";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, student.getId());
			preparedStatement.setString(2, student.getFirstName());
			preparedStatement.setString(3, student.getSecondName());
			preparedStatement.setDouble(4, student.getAvgMark());
			preparedStatement.setString(5, student.getGroupNumber());
			res = preparedStatement.executeQuery();
			con.commit();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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
	}

	@Override
	public List<Students> updateListItems(List<Students> items) {
		return items;
		// TODO Auto-generated method stub

	} //

	@Override
	public Students getById(Integer id) {
		PreparedStatement preparedStatement = null;
		Connection con = null;
		java.sql.Statement state = null;
		ResultSet res = null;
		String sql = null;
		Students student = null;
		try {
			con = database.getConnection();
			sql = "SELECT * FROM BEGANSS.STUDENT WHERE STUDENT_ID = ?";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			res = preparedStatement.executeQuery();
			student = new Students();
			while (res.next()) {
				student.setFirstName(Util.trim(res.getString("FIRST_NAME")));
				student.setSecondName(Util.trim(res.getString("SECOND_NAME")));
				student.setId(res.getInt("STUDENT_ID"));
				student.setAvgMark(res.getInt("AVG_MARK"));
				student.setGroupNumber(res.getString("GROUP_NUMBER"));
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
		return student;
	}

	public void getById2(Integer id) {
		Connection con = null;
		java.sql.Statement state = null;
		ResultSet res = null;
		String sql = null;
		Students student = new Students();
		try {
			con = database.getConnection();
			// sql = String.format("SELECT * FROM BEGANSS.STUDENT WHERE STUDENT_ID = %s",
			// id);
			sql = "SELECT * FROM BEGANSS.STUDENT";
			res = state.executeQuery(sql);
			while (res.next()) {
				System.out.println(res.getInt("STUDENT_ID"));
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

	}

	@Override
	public List<Students> getAll(StudentFilter filtr) {
		List<Students> students = null;
		PreparedStatement preparedStatement = null;
		Connection con = null;
		java.sql.Statement state = null;
		ResultSet res = null;
		String sql = null;
		Students student = new Students();
		try {
			con = database.getConnection();
			sql = "SELECT * FROM BEGANSS.STUDENT "
					+ "WHERE 'FIRST_NAME' = ?% "
					+ "AND 'SECOND_NAME' = ?% "
					+ "AND 'GROUP_NUMBER' = ?%";
			preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, filtr.getFirstName());
			preparedStatement.setString(2, filtr.getSecondname());
			preparedStatement.setString(3, filtr.getGroupNumber());
			res = preparedStatement.executeQuery();
			students = new ArrayList<Students>();
			while (res.next()) {
				student.setFirstName(Util.trim(res.getString("FIRST_NAME")));
				student.setSecondName(Util.trim(res.getString("SECOND_NAME")));
				student.setId(res.getInt("STUDENT_ID"));
				student.setAvgMark(res.getInt("AVG_MARK"));
				student.setGroupNumber(res.getString("GROUP_NUMBER"));
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
		return students;
	}

	@Override
	public Students deleteItemById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
}
