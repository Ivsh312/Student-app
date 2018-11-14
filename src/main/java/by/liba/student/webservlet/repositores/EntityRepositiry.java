package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import by.liba.student.common.Marks;

public class EntityRepositiry {
	
	
}

//public abstract class EntityRepositiry <T extends Entity>{
//	private final Map<Integer, T> items = new LinkedHashMap<Integer, T>();
//	  
//	  public EntityRepositiry(List<T>items){
//		  if(items != null){
//			  for(T itemm : items){
//				  this.items.put(itemm.getId(), itemm);
//			  }
//		  }
//	  }
//	  
//    public List<T> findAll(){
//  	  return new ArrayList<>(items.values());
//    }
//    
//    public T findOne(String item){
//    	return 
//    }
//    
//    public T create(T item){
//  	  Random random = new Random();
//		 int id = random.nextInt(100);
//  	  mark.setId(id);
//  	  this.marks.put(id, mark);
//  	  return mark;
//    }
//    
//    public void remove(String id){
//  	  this.marks.remove(Integer.parseInt(id));
//    }
//    
//    public T update(T mark){
//  	  this.marks.put(mark.getId(), mark);
//  	  return mark;
//    }
//}
