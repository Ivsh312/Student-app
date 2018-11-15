package by.liba.student.webservlet.readers;

import by.liba.student.common.Groups;
import by.liba.student.common.Students;
import by.liba.student.webservlet.repositores.EntityRepositiry;

public class StudentLineMapper implements LineMapper<Students> {

	private EntityRepositiry<Groups> groupRepository;

	public StudentLineMapper(EntityRepositiry<Groups> groupRepository) {
		this.groupRepository = groupRepository;
	}

	@Override
	public Students mapLine(String line) {
		String[] data = line.split(";");
		Students student = new Students(data[1], data[2]);
		student.setId(Integer.valueOf(data[0]));
		String groupId = data[3];
		Groups group = groupRepository.findOne(groupId);
		student.setGroupNumber(group.getGroupNumber());
		return student;
	}
}
