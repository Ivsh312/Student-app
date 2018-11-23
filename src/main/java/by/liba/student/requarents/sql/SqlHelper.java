package by.liba.student.requarents.sql;

import java.util.List;

public class SqlHelper {

	public static String addLike(List<Object> params, String field, String value, String operator) {
		String sql = "";
		if (!isEmpty(value)) {
			sql = field + " LIKE ? " + operator + " ";
			params.add(value + "%");
		}
		return sql;
	}
    
	public static boolean isEmpty(String str) {
		return str == null || "".equals(str) || "0.0".equals(str);
	}
	
	public static String addFild(List<Object> params, String field, String value, String operator) {
		String sql = "";
		if (!isEmpty(value)) {
			sql = field + operator + " ";
			params.add(value);
		}
		return sql;
	}
	
	
	public static String addFildDef(List<Object> params, String field, String value, String operator) {
		String sql = "";
		if (!isEmpty(value)) {
			sql = field + "= ? " + operator + " ";
			params.add(value);
		}
		return sql;
	}

}
