package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import by.liba.student.common.Professors;
import by.liba.student.common.Students;
import by.liba.student.requarents.EntityRequest;
import by.liba.student.utils.Database;
import filters.ProfessorFilter;
import filters.StudentFilter;

public class ProfessorRepository extends EntityRepository<Professors, ProfessorFilter>{ 
	public ProfessorRepository(EntityRequest<Professors, ProfessorFilter> requarents, Database dataSource) {
		super(requarents, dataSource);
	}
}
