package by.liba.student.webservlet.readers;

import by.liba.student.common.Groups;

public class GroupLineMapper implements LineMapper<Groups> {
	@Override
	public Groups mapLine(String line) {
		String[] data = line.split(";");
		Groups group = new Groups();
		group.setGroupNumber(data[0]);
		return null;
	}
}
