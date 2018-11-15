package by.liba.student.webservlet.repositores;

import java.util.ArrayList;

import by.liba.student.common.Users;

public class UserRepository extends EntityRepositiry<Users>{
    public UserRepository (ArrayList<Users> users) {
    	super(users);
    }
}
