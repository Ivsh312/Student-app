package by.liba.student.requarents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.taglibs.standard.tag.el.sql.TransactionTag;

import by.liba.student.common.Groups;

import by.liba.student.common.StringUtil;
import by.liba.student.common.Students;
import by.liba.student.common.Util;
import by.liba.student.requarents.sql.SqlHelper;
import by.liba.student.utils.Database;
import by.liba.student.webservlet.repositores.EntityRepository;
import by.liba.student.webservlet.repositores.Repository;
import filters.GroupFilter;
import filters.StudentFilter;

public class RequestStudents extends EntityRequest<Students, StudentFilter> {
	private String tableName;
	private EntityRepository<Groups, GroupFilter> groupRepository;

	public RequestStudents() {
		super("");
	}

	public RequestStudents(String tableName, EntityRepository<Groups, GroupFilter> groupRepository) {
		super(tableName);
		this.tableName = tableName;
		this.groupRepository = groupRepository;
	}

	@Override
	public String createReuqestGetById() {
		// return getAllSql + " WHERE ID_STUDENTS = ?";
		return null;
	}

	@Override
	public String createReuqestCreate(Students student, List<Object> params) {
		Random random = new Random();
		System.out.println("createReuqestCreate");
		String groupNumber = ""; 
		groupNumber = (new RequestStudents()).findGroupNumber(student.getGroupNumber());
		if ("".equals(groupNumber)) {
			Groups group = new Groups();
			group.setGroupNumber(StringUtil.trim(groupNumber));
			group.setAvgMark(0.0);
			this.groupRepository.create(group);
		}
		
		CreateSql += "(FIRST_NAME, SECOND_NAME, GROUP_NUMBER, AVG_MARK, STUDENT_ID) VALUES ";
		CreateSql  += "('" +  student.getFirstName() + "', '"
		+ student.getSecondName() + "', '" 
        + student.getGroupNumber() + "', '"
        + student.getAvgMark() + "', '" + random.nextInt(32000)+"')";
		return CreateSql;
	}

	@Override
	public String createReuqestGetAll(StudentFilter filter, List<Object> params) {
		return getAllSql + " WHERE " + SqlHelper.addLike(params, "FIRST_NAME", filter.getFirstName(), "AND")
				+ SqlHelper.addLike(params, "SECOND_NAME", filter.getSecondname(), "AND")
				+ SqlHelper.addLike(params, "GROUP_NUMBER", filter.getGroupNumber(), "AND") + "1=1";

		// return "SELECT * FROM BEGANSS.STUDENT where 1+1 ";
	}

	@Override
	public String createReuqestDelete(Students student) {
//		CreateSql += " (FIRST_NAME, SECOND_NAME) VALUES ";
//		return CreateSql + "('" + student.getFirstName() + "', '" + student.getSecondName() + "')";
		return null;
	}

	@Override
	public String createReuqestUpdate(Students entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Students createItem(ResultSet resultSet) throws SQLException {

		Students student = new Students();
		student.setId(Integer.valueOf(resultSet.getString("STUDENT_ID")));
		student.setFirstName(StringUtil.trim(resultSet.getString("FIRST_NAME")));
		student.setSecondName(StringUtil.trim(resultSet.getString("SECOND_NAME")));
		String groupId = StringUtil.trim(resultSet.getString("GROUP_NUMBER"));
		if (!StringUtil.isEmpty(groupId)) {
			student.setGroupNumber(groupId);
		}
		return student;
	}

	private String findGroupNumber(String groupId) {
		String item = null;
		System.out.println("findGroupNumber");
		try (Connection connect = (new Database()).getConnection()) {
			String sql = "SELECT * FROM BEGANSS."+ "GROUP" + " WHERE GROUP_NUMBER = ?";
			System.out.println("sql");
			System.out.println("findGroupNumber: "+sql);
			PreparedStatement ps = connect.prepareStatement(sql);
			System.out.println(sql);
			ps.setString(1, groupId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				item = rs.getString("GROUP_NUMBER");
			}
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
		return StringUtil.trim(item);
	}

	@Override
	public String createReuqestGetById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestGetByGroupNumber(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}
}
