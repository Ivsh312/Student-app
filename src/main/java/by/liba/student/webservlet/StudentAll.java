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

import by.liba.student.common.Students;
import by.liba.student.requarents.Request;
import by.liba.student.requarents.RequestStudents;
import by.liba.student.webservlet.repositores.StudentRepository;

public class StudentAll extends HttpServlet {
	private final static List<Students> STUDENTS = new ArrayList<Students>();
	private StudentRepository studentRepository;
	RequestStudents student;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestStudents stud =  new RequestStudents();
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Student.jsp");
		req.setAttribute("Students", stud.getAll());
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("id") != null) {
			Integer id = Integer.valueOf(req.getParameter("id"));
			this.student.deleteItem(id);
		}
		doGet(req, resp);
	}

	@Override
	public void init() throws ServletException {
		student = new RequestStudents();
		ServletContext sc = getServletContext();
		this.studentRepository = (StudentRepository) sc.getAttribute("studentRepository");
	}

	@Override
	public void destroy() {

	}
}
