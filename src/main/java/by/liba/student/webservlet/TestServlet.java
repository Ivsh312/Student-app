package by.liba.student.webservlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.liba.student.common.Students;

public class TestServlet extends HttpServlet{
    
	private final static List <Students> STUDENTS = new ArrayList<Students>();

	private static final long serialVersionUID = -3076373278255669151L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/TestJSPcool.jsp");
		    req.setAttribute("Students", STUDENTS);
		    requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    String first = req.getParameter("firstName");
		    String second = req.getParameter("secondName");
		    System.out.println(String.format("First name: %s, Second name: %s", first, second));

		    STUDENTS.add(new Students(first, second));
		    
		    doGet(req, resp);
	}
	public static void main(String[] args) {
		Students [] STUDENT = new Students[0];
	    StringBuilder students = new StringBuilder();
	    students.append("<tr>");
	    for(Students student : STUDENTS) {
	    	students.append("<td>");
	    	students.append(String.format("First name: %s, Second name: %s", student.getFirstName(), student.getSecondName()));
	    	students.append("</td>");
	    }
	    students.append("</tr>");
	    System.out.println(students);
	}
}
