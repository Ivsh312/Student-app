package by.liba.student.webservlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.liba.student.common.Groups;
import by.liba.student.common.Professors;
import by.liba.student.common.Students;

import by.liba.student.requarents.RequestGroup;
import by.liba.student.requarents.RequestProfessors;
import by.liba.student.requarents.RequestStudents;
import by.liba.student.utils.Database;

import by.liba.student.webservlet.repositores.EntityRepository;
import by.liba.student.webservlet.repositores.GroupRepository;
import by.liba.student.webservlet.repositores.ProfessorRepository;
import by.liba.student.webservlet.repositores.StudentRepository;

import filters.GroupFilter;
import filters.ProfessorFilter;
import filters.StudentFilter;

public class StudentsContextListener implements ServletContextListener {
	// private StudentRepository studentRepository;

	private EntityRepository<Students, StudentFilter> studentRepositoryDB;
	private EntityRepository<Groups, GroupFilter> groupsRepositoryDB;
	private EntityRepository<Professors, ProfessorFilter> professorsRepositoryDB;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext sc = sce.getServletContext();
		this.groupsRepositoryDB = new GroupRepository(new RequestGroup("GROUP"), new Database());
		this.studentRepositoryDB = new StudentRepository(new RequestStudents("STUDENT", groupsRepositoryDB), new Database());
		this.professorsRepositoryDB = new ProfessorRepository(new RequestProfessors("PROFESS"), new Database());
		sc.setAttribute("studentRepository", this.studentRepositoryDB);
		sc.setAttribute("groupsRepositoryDB", this.groupsRepositoryDB);
		sc.setAttribute("professorsRepository", this.professorsRepositoryDB);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
