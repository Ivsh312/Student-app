package by.liba.student.webservlet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import by.liba.student.common.Students;

public class StudentRepository {
	  private final Map<Integer, Students> students = new ConcurrentHashMap<Integer, Students>();
	  
	  public StudentRepository(List<Students>students){
		  if(students != null){
			  for(Students student : students){
				  this.students.put(student.getId(), student);
			  }
		  }
	  }
      public List<Students> findAll(){
    	  return new ArrayList<>(students.values());
    			  //Collection.unmodifiableCollection(students);
      }
      
      public Students create(Students student){
    	  String id = UUID.randomUUID().toString();
    	  student.setId(Integer.parseInt(id));
    	  this.students.put(Integer.parseInt(id), student);
    	  return student;
      }
      
      public void remove(String id){
    	  this.students.remove(id);
      }
      
      public Students update(Students student){
    	  this.students.put(student.getId(), student);
    	  return student;
      }
}
