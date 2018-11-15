package by.liba.student.webservlet.repositores;

import java.util.ArrayList;

import by.liba.student.common.Studies;

public class StudyRepository extends EntityRepositiry<Studies>{
	public StudyRepository(ArrayList<Studies>studies) {
		super(studies);
	}
}
