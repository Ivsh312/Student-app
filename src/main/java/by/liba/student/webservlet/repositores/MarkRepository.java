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

public class MarkRepository extends EntityRepositiry<Marks>{
	  private final Map<Integer, Marks> marks = new ConcurrentHashMap<Integer, Marks>();
	  
	  public MarkRepository(List<Marks>marks){
		  super(new ArrayList<Marks>(marks));
	  }
      public List<Marks> findAll(){
    	  return new ArrayList<>(marks.values());
      }
}
