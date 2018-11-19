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

import by.liba.student.common.Students;
import by.liba.student.requarents.Request;
import by.liba.student.requarents.RequestStudents;
import by.liba.student.webservlet.repositores.EntityRepositiry;
import by.liba.student.webservlet.repositores.EntityRepository;
import by.liba.student.webservlet.repositores.Repository;
import by.liba.student.webservlet.repositores.StudentRepository;
import filters.StudentFilter;

public class Student extends HttpServlet {
	// private final static List<Students> STUDENTS = new ArrayList<Students>();
	// private StudentRepository studentRepository;
	private EntityRepository<Students, StudentFilter> repositoryDB;

	@Override
	public void init() throws ServletException {
		ServletContext sc = getServletContext();
		this.repositoryDB = (EntityRepository<Students, StudentFilter>) sc.getAttribute("studentRepository");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String firstNameFiltr = req.getParameter("firstNameFiltr");
		String secondnameFiltr = req.getParameter("secondnameSortFiltr");
		String groupNumberFiltr = req.getParameter("groupNumberFiltr");
		StudentFilter studentFilter = new StudentFilter();
		if (firstNameFiltr != null)
			studentFilter.setFirstName(firstNameFiltr);
		if (secondnameFiltr != null)
			studentFilter.setSecondname(secondnameFiltr);
		if (groupNumberFiltr != null)
			studentFilter.setGroupNumber(groupNumberFiltr);

		List<Students> students = repositoryDB.findAll(studentFilter);
		req.setAttribute("Students", students);

		if ("".equals(req.getParameter("json"))) {
			resp.setContentType("application/json");

			PrintWriter pw = resp.getWriter();
			pw.print(toJson(students));

			pw.close();

		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Student.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String first = req.getParameter("firstName");
		String second = req.getParameter("secondName");
		repositoryDB.create(new Students(first, second));
		System.out.println(String.format("First name: %s, Second name: %s", first, second));
		repositoryDB.create(new Students(first, second));
		doGet(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));
		repositoryDB.removeById(id);
		;
		doGet(req, resp);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String first = req.getParameter("firstName");
		String second = req.getParameter("secondName");
		Integer id = Integer.parseInt(req.getParameter("id"));
		System.out.println("Hi Jsl");
		repositoryDB.create(new Students(id, first, second));
		doGet(req, resp);
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
