package by.liba.student.webservlet.repositores;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Groups;
import by.liba.student.requarents.EntityRequest;
import by.liba.student.requarents.RequestGroup;
import by.liba.student.requarents.RequestStudents;
import by.liba.student.utils.Database;
import filters.GroupFilter;
public class GroupRepository extends EntityRepository<Groups, GroupFilter>{
	  public GroupRepository(EntityRequest<Groups, GroupFilter> requestGroups, Database database){
		  super(requestGroups, database);
	  }
}