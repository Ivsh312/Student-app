package by.liba.student.webservlet.repositores;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Groups;
public class GroupRepository extends EntityRepositiry<Groups>{
	public GroupRepository(List<Groups> groups) {
		super(new ArrayList<Groups>(groups));
	}
}