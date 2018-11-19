package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import filters.StudentFilter;
import by.liba.student.common.Students;
//import by.liba.student.requarents.RequestStudents;
import by.liba.student.requarents.Request;

public class StudentRepository extends EntityRepository<Students, StudentFilter>{ 
	  public StudentRepository(Request <Students, StudentFilter> requarents){
		  super(requarents);
	  }
}
