package by.liba.student.requarents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import by.liba.student.common.Groups;
import by.liba.student.utils.Database;
import filters.GroupFilter;

public class RequestGroup extends EntityRequest<Groups, GroupFilter> {
	private String tableName;
	public RequestGroup(String tableName) {
		super(tableName);
		this.tableName = tableName;
		// TODO Auto-generated constructor stub
	}

	@Override
	public Groups createItem(ResultSet resultSet) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestGetById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestGetAll(GroupFilter filter, List<Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestDelete(Groups entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestUpdate(Groups entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestGetByGroupNumber(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestGetById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestCreate(Groups group, List<Object> params) {
		this.CreateSql += this.tableName + "(GROUP_NUMBER, AVG_MARK) VALUES ";
		return this.CreateSql  + "('" +  group.getGroupNumber() + "', '"
				+ group.getAvgMark() +"')";
	}

	
//	Database database = new Database();
//
//	@Override
//	public void createListItems(List<Groups> items) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void createItem(Groups group) {
//		PreparedStatement preparedStatement = null;
//		Connection con = null;
//		java.sql.Statement state = null;
//		ResultSet res = null;
//		String sql = null;
//		try {
//			con = database.getConnection();
//
//			if (this.getGroupNumber(group.getGroupNumber()) == null) {
//				sql = "INSERT INTO `beganss`.`group` " + "(`GROUP_NUMBER`, `AVG_MARK`) " + "VALUES (?, ?)";
//				preparedStatement = con.prepareStatement(sql);
//				preparedStatement.setString(1, group.getGroupNumber());
//				preparedStatement.setDouble(2, group.getAvgMark());
//				res = preparedStatement.executeQuery();
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//
//	}
//
//	@Override
//	public Groups deleteItem(Groups item) {
//		return item;
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public List<Groups> deleteListItems(List<Groups> items) {
//		return items;
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Groups updateItem(Groups item) {
//		return item;
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public List<Groups> updateListItems(List<Groups> items) {
//		return items;
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Groups getById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	public Groups getGroupNumber(String groupNumber) {
//		PreparedStatement preparedStatement = null;
//		Connection con = null;
//		java.sql.Statement state = null;
//		ResultSet res = null;
//		String sql = null;
//		Groups group = null;
//		try {
//			con = database.getConnection();
//			sql = "SELECT * FROM BEGANSS.GROUP WHERE GROUP_NUMBER = ?";
//			preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setString(1, groupNumber);
//
//			res = preparedStatement.executeQuery();
//			group = new Groups();
//			while (res.next()) {
//				group.setGroupNumber(groupNumber);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return group;
//	}
//
//	@Override
//	public List<Groups> getAll(GroupFilter filter) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	
//	public Groups getGroupNumberInTransaction(String groupNumber, Connection con) {
//		PreparedStatement preparedStatement = null;
//		java.sql.Statement state = null;
//		ResultSet res = null;
//		String sql = null;
//		Groups group = null;
//		try {
//			sql = "SELECT * FROM BEGANSS.GROUP WHERE GROUP_NUMBER = ?";
//			preparedStatement = con.prepareStatement(sql);
//			preparedStatement.setString(1, groupNumber);
//
//			res = preparedStatement.executeQuery();
//			group = new Groups();
//			while (res.next()) {
//				group.setGroupNumber(groupNumber);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			if (con != null) {
//				try {
//					con.close();
//				} catch (SQLException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return group;
//	}
//
//	@Override
//	public Groups deleteItemById(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//	

}
