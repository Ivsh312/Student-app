package by.liba.student.webservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.liba.student.common.Students;
import by.liba.student.webservlet.repositores.EntityRepository;
import filters.StudentFilter;

public class AddStudent extends HttpServlet {
	String errorMissage = "incorrect Intput";
	String goodMissage = "was added successfully";
	private EntityRepository<Students, StudentFilter> repositoryDB;
    
	@Override
	public void init() throws ServletException {
		ServletContext sc = getServletContext();
		this.repositoryDB = (EntityRepository<Students, StudentFilter>) sc.getAttribute("studentRepository");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/NewStudent.jsp");
		dispatcher.forward(req, resp);	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String firstName = req.getParameter("firstName");
		String secondname = req.getParameter("secondname");
		String groupNumber = req.getParameter("groupNumber");
		Double avgMark = Double.parseDouble(req.getParameter("avgMark"));
		Students students = new Students();
		
		if (firstName != null &&
				secondname != null &&
				groupNumber != null &&
				avgMark != 0.0) {
		students.setFirstName(firstName);
		students.setSecondName(secondname);
		students.setGroupNumber(groupNumber);
		students.setAvgMark(avgMark);
			
		System.out.println(students);
		repositoryDB.create(students);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Student.jsp");
		dispatcher.forward(req, resp);
		req.setAttribute("Students", goodMissage);
		} else {;
			req.setAttribute("Error", goodMissage);
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/NewStudent.jsp");
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

	private static String toJson(Students student) {
		String json = "{" + "\"id\": \"" + student.getId() + "\"," + "\"firstName\": \"" + student.getFirstName()
				+ "\"," + "\"secondName\": \"" + student.getSecondName() + "\"" + "}";
		return json;

	}

	private static String toJson(List<Students> students) {
		String json = "[";
		if (students != null) {
			boolean firstItem = true;
			for (Students student : students) {
				if (firstItem) {
					firstItem = false;
				} else {
					json += ",";
				}
				json += toJson(student);
			}
		}

		json += "]";
		return json;
	}
}