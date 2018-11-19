package by.liba.student.webservlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.liba.student.common.Students;
import by.liba.student.webservlet.repositores.StudentRepository;

public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 6896779930314879279L;

	//private final static List<Student> STUDENTS = new ArrayList<Student>();
	
	//private final String path = "C:\\Users\\User\\eclipse-workspace\\student-app\\src\\main\\java\\resources\\students.csv";

	private StudentRepository studentRepository;
	
	@Override
	public void init() throws ServletException {
		
		ServletContext sc = getServletContext();
		this.studentRepository = (StudentRepository) sc.getAttribute("studentRepository");
		
		/*try {
			List<Student> students = new StudentReader(path).read();
			this.studentRepository = new StudentRepository(students);
			
		} catch (IOException e) {
			throw new ServletException(e);
		}*/
		
	}
	
	@Override
	public void destroy() {
		/*try {
			List<Student> students = studentRepository.findAll();
			new StudentWriter(path).write(students);
		} catch(IOException e) {
			System.out.println("");
		}*/
			
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//req.setAttribute("students", STUDENTS);
		//resp.setContentType("application/json");
		List<Students> students = studentRepository.findAll();
		
		
		req.setAttribute("students", studentRepository.findAll());
		
		if("".equals(req.getParameter("json"))) {
			resp.setContentType("application/json");
			
			PrintWriter pw = resp.getWriter();
			pw.print(toJson(students));
			
			pw.close();
			
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/TestFile.jsp");
			dispatcher.forward(req, resp);
		}
		
	}
	
	private static String toJson(Students student) {
		String json = "{" +
				"\"id\": \"" + student.getId() + "\"," +
				"\"firstName\": \"" + student.getFirstName() + "\"," +
				"\"secondName\": \"" + student.getSecondName() + "\"" +
				"}";
		return json;
		
	}
	
	private static String toJson(List<Students> students) {
		String json = "[";
		if(students!= null) {
			boolean firstItem = true;
			for(Students student : students) {
				if(firstItem) {
					firstItem = false;
				}
				else {
					json += ",";
				}
				json += toJson(student);
			}
		}

		json += "]";
		return json;
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String firstName = req.getParameter("firstName");
		String secondName = req.getParameter("secondName");	
		studentRepository.create(new Students(firstName,secondName));
		System.out.println(String.format("First name: %s, Second name: %s", firstName, secondName));
		
		//STUDENTS.add(new Student(firstName, secondName));
		
		doGet(req,resp);
	}
	
}