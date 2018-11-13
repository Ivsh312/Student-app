package by.liba.student.webservlet;

import java.io.IOException;
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
import by.liba.student.webservlet.repositores.ProfessorRepository;

public class Professor extends HttpServlet{
	private final static List <Professors> PROFESSORS = new ArrayList<Professors>();
	private ProfessorRepository professorRepository;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Professor.jsp");
		    req.setAttribute("Professors", professorRepository.findAll());
		    requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    String first = req.getParameter("firstName");
		    String second = req.getParameter("secondName");
		    String fatherdName = req.getParameter("fatherdName");
		    professorRepository.create(new Professors(first, second, fatherdName));
		    System.out.println(String.format("First name: %s, Second name: %s fatherd Name: %s", first, second, fatherdName));

		    PROFESSORS.add(new Professors(first, second, fatherdName));

		    doGet(req, resp);
	}
	
	@Override
	public void init() throws ServletException {
		getInitParameter("123");
		ServletContext sc = getServletContext();
		this.professorRepository = (ProfessorRepository)sc.getAttribute("professorRepository");
	}
	@Override
	public void destroy() {
		
	}
}
