package by.liba.student.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.liba.student.common.Students;
import by.liba.student.common.Subject;
import by.liba.student.webservlet.repositores.EntityRepository;
import filters.StudentFilter;
import filters.SubjectFilter;

public class Subjects extends HttpServlet {
	// private final static List<Students> STUDENTS = new ArrayList<Students>();
	// private StudentRepository studentRepository;
	private EntityRepository<Subject, SubjectFilter> repositoryDB;
	@Override
	public void init() throws ServletException {
		ServletContext sc = getServletContext();
		this.repositoryDB = (EntityRepository<Subject, SubjectFilter>) sc.getAttribute("subjectRepository");
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nameSub = req.getParameter("nameSubF");
		String hours = req.getParameter("hoursF");
		String avgMark = req.getParameter("avgMarkF");
		SubjectFilter subjectFilter = new SubjectFilter();
		if (nameSub != null && hours != null && avgMark != null) {
			subjectFilter.setName(nameSub);
	
			subjectFilter.setHours(Integer.valueOf(hours));
	
			subjectFilter.setAvgMark(Double.valueOf(avgMark));
			
			
			List<Subject> subjects = repositoryDB.findAll(subjectFilter);
			req.setAttribute("Subject", subjects);

			resp.setContentType("application/json");
			

			PrintWriter pw = resp.getWriter();
			pw.print(toJson(subjects));
			pw.close();
		}else {
			PrintWriter pw = resp.getWriter();
			pw.print("");
			pw.close();
		}
	}
		private static String toJson(Subject subject) {
			String json = "{" + "\"id\": \"" + subject.getId() + "\"," + "\"hourse\": \"" + subject.getHours()
					+ "\"," + "\"name\": \"" + subject.getName() 
					+ "\"," + "\"avgMark\": \"" + subject.getAvgMark() + "\"" + "}";
			return json;

		}

		private static String toJson(List<Subject> subject) {
			String json = "[";
			if (subject != null) {
				boolean firstItem = true;
				for (Subject subjects : subject) {
					if (firstItem) {
						firstItem = false;
					} else {
						json += ",";
					}
					json += toJson(subjects);
				}
			}

			json += "]";
			return json;
		}

		
		
		
		
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String name = req.getParameter("name");
			String hours = req.getParameter("hours");
			String avgMark = req.getParameter("avgMark");
			Subject subject = new Subject();
			if (name != null && hours != null && hours != null && avgMark != null) {
				subject.setName(name);
				subject.setHours(Integer.valueOf(hours));
				subject.setAvgMark(Double.valueOf(avgMark));
				System.out.println(subject);
				repositoryDB.create(subject);
			}
		}

		
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String idForDelete = req.getParameter("idForDelete");
			Subject subject = new Subject();
			subject.setId(Integer.valueOf(idForDelete));
			if (idForDelete != null) {
				repositoryDB.remove(subject);
			}
		}		
		

}
