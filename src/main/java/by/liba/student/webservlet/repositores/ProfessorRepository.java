package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import by.liba.student.common.Professors;

public class ProfessorRepository extends EntityRepositiry<Professors>{
	
	public ProfessorRepository(List<Professors>professors){
		  super(professors);
	  }
}
