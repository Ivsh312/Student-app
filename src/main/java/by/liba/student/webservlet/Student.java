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

public class Student extends HttpServlet {
	private final static List<Students> STUDENTS = new ArrayList<Students>();
	private StudentRepository studentRepository;
    
	@Override
	public void init() throws ServletException {
		getInitParameter("123");
		ServletContext sc = getServletContext();
		this.studentRepository = (StudentRepository) sc.getAttribute("studentRepository");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Student.jsp");
		req.setAttribute("Students", studentRepository.findAll());
		requestDispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String first = req.getParameter("firstName");
		String second = req.getParameter("secondName");
		studentRepository.create(new Students(first, second));
		System.out.println(String.format("First name: %s, Second name: %s", first, second));
		STUDENTS.add(new Students(first, second));
		doGet(req, resp);
	}
}
