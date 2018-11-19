package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import by.liba.student.common.Professors;
import by.liba.student.common.Students;

public class ProfessorRepository extends EntityRepositiry<Professors>{
	private final Map<Integer, Professors> professors = new ConcurrentHashMap<Integer, Professors>();
	
	public ProfessorRepository(List<Professors>professors){
		  super(new ArrayList<Professors>(professors));
	  }
}
