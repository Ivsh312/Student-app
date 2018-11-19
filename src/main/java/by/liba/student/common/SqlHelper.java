package by.liba.student.common;

import java.util.List;


public class SqlHelper {
	public static String help(List<Object> items, String value, String operator, String fild) {
		String sql = "";
		if (!StringUtil.isEmpty(value)) {
			sql += fild + "Like ?" + operator;
		}
		return sql;
	}
}
