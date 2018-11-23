package by.liba.student.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class Professor extends HttpServlet {
	private final static List<Professors> PROFESSORS = new ArrayList<Professors>();
	private EntityRepository<Professors, ProfessorFilter> repositoryDB;

	@Override
	public void init() throws ServletException {
		ServletContext sc = getServletContext();
		this.repositoryDB = (EntityRepository<Professors, ProfessorFilter>) sc.getAttribute("professorsRepository");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstNameFiltr = req.getParameter("firstNameFiltr");
		String secondnameFiltr = req.getParameter("secondnameSortFiltr");
		String avgMark = req.getParameter("avgMarkFiltr");
		ProfessorFilter professorFilter = new ProfessorFilter();
		if (firstNameFiltr != null)
			professorFilter.setFirstName(firstNameFiltr);
		if (secondnameFiltr != null)
			professorFilter.setSecondname(secondnameFiltr);
		if (avgMark != null)
			professorFilter.setAvgMark(Double.valueOf(avgMark));

		List<Professors> professors = repositoryDB.findAll(professorFilter);
		req.setAttribute("Professors", professors);
		resp.setContentType("application/json");
		PrintWriter pw = resp.getWriter();
		pw.print(toJson(professors));
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost");
		String firstName = req.getParameter("firstName");
		String secondName = req.getParameter("secondName");
		Double avgMark = Double.parseDouble(req.getParameter("avgMark"));
		Professors professor = new Professors();
		if (firstName != null && secondName != null && avgMark != 0.0) {
			professor.setAvgMark(avgMark);
			professor.setFirstName(firstName);
			professor.setSecondName(secondName);
		}
		System.out.println(professor.toString());
		repositoryDB.create(professor);
	}

	private static String toJson(Professors professors) {
		String json = "{" + "\"id\": \"" + professors.getId() + "\"," 
	            + "\"firstName\": \"" + professors.getFirstName()
				+ "\"," + "\"avgMark\": \"" + professors.getAvgMark() 
				+ "\"," + "\"secondName\": \"" + professors.getSecondName() + "\"" + "}";
		return json;

	}

	private static String toJson(List<Professors> professors) {
		String json = "[";
		if (professors != null) {
			boolean firstItem = true;
			for (Professors professor : professors) {
				if (firstItem) {
					firstItem = false;
				} else {
					json += ",";
				}
				json += toJson(professor);
			}
		}

		json += "]";
		return json;
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String idForDelete = req.getParameter("idForDelete");
		Professors professors = new Professors();
		professors.setId(Integer.valueOf(idForDelete));
		if (idForDelete != null) {
			repositoryDB.remove(professors);
		}
	}

	@Override
	public void destroy() {

	}
}
