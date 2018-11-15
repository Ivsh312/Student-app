package by.liba.student.webservlet.readers;

import by.liba.student.common.Groups;
import by.liba.student.common.Students;
import by.liba.student.webservlet.Student;

public class GroupReader implements LineMapper<Groups>{
    private final String path;

	public GroupReader(String path) {
		this.path = path;
	}
	@Override
	public Groups mapLine(String line) {
		String[] data = line.split(";");
		Groups groups = new Groups();
		groups.setGroupNumber(data[0]);
		return groups;
	}
}
