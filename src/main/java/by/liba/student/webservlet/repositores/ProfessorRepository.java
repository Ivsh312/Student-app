package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import by.liba.student.common.Professors;
import by.liba.student.common.Students;

public class ProfessorRepository {
	private final Map<Integer, Professors> professors = new ConcurrentHashMap<Integer, Professors>();
	
	public ProfessorRepository(List<Professors>professors){
		  if(professors != null){
			  for(Professors professor : professors){
				  this.professors.put(professor.getId(), professor);
			  }
		  }
	  }
    public List<Professors> findAll(){
  	  return new ArrayList<>(professors.values());
  			  //Collection.unmodifiableCollection(students);
    }
    public Professors create(Professors professor){
  	  Random random = new Random();
  		 int id = random.nextInt(100);
  		professor.setId(id);
  	  this.professors.put(id, professor);
  	  return professor;
    }
    public void remove(String id){
  	  this.professors.remove(Integer.parseInt(id));
    }
    public Professors update(Professors professor){
  	  this.professors.put(professor.getId(), professor);
  	  return professor;
    }
}
