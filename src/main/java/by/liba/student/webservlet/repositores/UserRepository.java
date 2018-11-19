package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Users;

public class UserRepository extends EntityRepositiry<Users> {
	public UserRepository(List<Users> users) {
		super(new ArrayList<Users>(users));
	}
}
