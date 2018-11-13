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

import by.liba.student.common.Marks;
import by.liba.student.common.Students;

public class MarkRepository {
	  private final Map<Integer, Marks> marks = new ConcurrentHashMap<Integer, Marks>();
	  
	  public MarkRepository(List<Marks>marks){
		  if(marks != null){
			  for(Marks mark : marks){
				  this.marks.put(mark.getId(), mark);
			  }
		  }
	  }
      public List<Marks> findAll(){
    	  return new ArrayList<>(marks.values());
      }
      
      public Marks create(Marks mark){
    	  Random random = new Random();
 		 int id = random.nextInt(100);
    	  mark.setId(id);
    	  this.marks.put(id, mark);
    	  return mark;
      }
      
      public void remove(String id){
    	  this.marks.remove(Integer.parseInt(id));
      }
      
      public Marks update(Marks mark){
    	  this.marks.put(mark.getId(), mark);
    	  return mark;
      }
}
