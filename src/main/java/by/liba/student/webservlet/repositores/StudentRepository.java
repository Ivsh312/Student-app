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

import by.liba.student.common.Students;
//import by.liba.student.requarents.RequestStudents;

public class StudentRepository extends EntityRepositiry<Students>{ 
	  public StudentRepository(List<Students>students){
		  super(new ArrayList<Students>(students));
	  }
}
