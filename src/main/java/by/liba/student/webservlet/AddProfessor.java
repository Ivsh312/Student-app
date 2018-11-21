package by.liba.student.webservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.liba.student.common.Professors;
import by.liba.student.common.Students;
import by.liba.student.webservlet.repositores.EntityRepository;
import filters.ProfessorFilter;
import filters.StudentFilter;

public class AddProfessor extends HttpServlet {
	String errorMissage = "incorrect Intput";
	String goodMissage = "was added successfully";
	private EntityRepository<Professors, ProfessorFilter> repositoryDB;
    
	@Override
	public void init() throws ServletException {
		ServletContext sc = getServletContext();
		this.repositoryDB = (EntityRepository<Professors, ProfessorFilter>) sc.getAttribute("professorRepository");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/NewProfessor.jsp");
		dispatcher.forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String firstName = req.getParameter("firstName");
		String secondname = req.getParameter("secondname");
		Double avgMark = Double.parseDouble(req.getParameter("avgMark"));
		Professors professors = new Professors();
		
		if (firstName != null &&
				secondname != null &&
				avgMark != 0.0) {
			professors.setFirstName(firstName);
			professors.setSecondName(secondname);
			professors.setAvgMark(avgMark);
			
		System.out.println(professors);
		repositoryDB.create(professors);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Professor.jsp");
		dispatcher.forward(req, resp);
		req.setAttribute("Students", goodMissage);
		} else {;
			req.setAttribute("Error", goodMissage);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/NewProfessor.jsp");
			dispatcher.forward(req, resp);
			doGet(req, resp);
		}
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Integer id = Integer.parseInt(req.getParameter("id"));
//		repositoryDB.removeById(id);
//		doGet(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String first = req.getParameter("firstName");
//		String second = req.getParameter("secondName");
//		Integer id = Integer.parseInt(req.getParameter("id"));
//		System.out.println("Hi Jsl");
//		repositoryDB.create(new Students(id, first, second));
//		doGet(req, resp);
	}

	private static String toJson(Professors professor) {
		String json = "{" + "\"id\": \"" + professor.getId() + "\"," + "\"firstName\": \"" + professor.getFirstName()
				+ "\"," + "\"secondName\": \"" + professor.getSecondName() + "\"" + "}";
		return json;

	}

	private static String toJson(List<Professors> professors) {
		String json = "[";
		if (professors != null) {
			boolean firstItem = true;
			for (Professors professor1 : professors) {
				if (firstItem) {
					firstItem = false;
				} else {
					json += ",";
				}
				json += toJson(professor1);
			}
		}

		json += "]";
		return json;
	}
	
	@Override
	public void destroy() {
		
	}
}