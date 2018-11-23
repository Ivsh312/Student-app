package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Subject;
import by.liba.student.requarents.EntityRequest;
import by.liba.student.utils.Database;
import filters.SubjectFilter;

public class SubjectRepository extends EntityRepository<Subject, SubjectFilter>{ 
	  public SubjectRepository(EntityRequest<Subject, SubjectFilter> requestSubject, Database database){
		  super(requestSubject, database);
	  }
}