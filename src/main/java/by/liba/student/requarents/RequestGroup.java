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
	public String createReuqestDelete(Groups entity, List<Object> params) {
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
		String CreateSql = getCreateSql() + "(GROUP_NUMBER, AVG_MARK) VALUES ";
		return CreateSql  + "('" +  group.getGroupNumber() + "', '"
				+ group.getAvgMark() +"')";
	}
}
