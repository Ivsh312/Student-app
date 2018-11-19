package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Studies;

public class StudyRepository extends EntityRepositiry<Studies> {
	public StudyRepository(List<Studies> studies) {
		super(new ArrayList<Studies>(studies));
	}
}
