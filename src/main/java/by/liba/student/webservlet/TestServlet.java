package by.liba.student.webservlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.omg.CORBA.RepositoryIdHelper;

import by.liba.student.common.Groups;
import by.liba.student.common.Marks;
import by.liba.student.common.Professors;
import by.liba.student.common.Students;
import by.liba.student.common.Studies;
import by.liba.student.common.Users;

public class TestServlet extends HttpServlet{
    
	private final static List <Students> STUDENTS = new ArrayList<Students>();
	private final static List <Marks> MARKS = new ArrayList<Marks>();
	private final static List <Studies> STUDIES = new ArrayList<Studies>();
	private final static List <Professors> PROFESSORS = new ArrayList<Professors>();
	private final static List <Groups> GROUPS = new ArrayList<Groups>();
	private final static List <Users> USERS = new ArrayList<Users>();
	private static final long serialVersionUID = -3076373278255669151L;

	
	private final String path = "D:\\dev\\workspaces\\student-app\\resources\\res.csv";
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/TestJSPcool.jsp");
		    req.setAttribute("Students", studentRepository.findAll());
		    req.setAttribute("Marks", MARKS);
		    req.setAttribute("Studies", STUDIES);
		    req.setAttribute("Professors", PROFESSORS);
		    req.setAttribute("Groups", GROUPS);
		    req.setAttribute("Users", USERS);
		    requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    String first = req.getParameter("firstName");
		    String second = req.getParameter("secondName");
		    
		    studentRepository.create(new Students(first, second));
		    
		    //Integer mark = Integer.parseInt(req.getParameter("mark"));
		    //String comments = req.getParameter("comments");
		    System.out.println(String.format("First name: %s, Second name: %s", first, second));
		    //System.out.println(String.format("mark: %s, comments: %s", mark, comments));
		    STUDENTS.add(new Students(first, second));
		    //MARKS.add(new Marks(mark, comments));
		    doGet(req, resp);
	}
	
    //private final String path = "D:\dev\workspaces\student-app\resources\res.csv";
    

	private StudentRepository studentRepository;	@Override
	public void init() throws ServletException {
		getInitParameter("123");
		ServletContext sc = getServletContext();
		this.studentRepository = (StudentRepository)sc.getAttribute("studentRepository");
	}
	@Override
	public void destroy() {
		
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
