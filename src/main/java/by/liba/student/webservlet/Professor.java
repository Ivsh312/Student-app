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

import by.liba.student.webservlet.repositores.EntityRepository;

import filters.ProfessorFilter;


public class Professor extends HttpServlet{
	private final static List <Professors> PROFESSORS = new ArrayList<Professors>();
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
		String avgMark = req.getParameter("avgMark");
		ProfessorFilter professorFilter = new ProfessorFilter();
		if (firstNameFiltr != null)
			professorFilter.setFirstName(firstNameFiltr);
		if (secondnameFiltr != null)
			professorFilter.setSecondname(secondnameFiltr);
		if (avgMark != null)
			professorFilter.setAvgMark(Double.valueOf(avgMark));

		List<Professors> professors = repositoryDB.findAll(professorFilter);
		req.setAttribute("Professors", professors);

		if ("".equals(req.getParameter("json"))) {
			resp.setContentType("application/json");

			PrintWriter pw = resp.getWriter();
			pw.print(toJson(professors));
			pw.close();

		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Professor.jsp");
			dispatcher.forward(req, resp);
		}
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
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String first = req.getParameter("firstName");
		String second = req.getParameter("secondName");
		System.out.println(String.format("First name: %s, Second name: %s", first, second));
		repositoryDB.create(new Professors(first, second));
		doGet(req, resp);
	}
	
	
	@Override
	public void destroy() {
		
	}
}
