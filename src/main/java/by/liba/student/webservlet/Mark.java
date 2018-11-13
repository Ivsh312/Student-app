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

import by.liba.student.common.Marks;
import by.liba.student.webservlet.repositores.MarkRepository;

public class Mark extends HttpServlet{
	private final static List <Marks> MARKS = new ArrayList<Marks>();
	private MarkRepository markRepository;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
		    RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/Mark.jsp");
		    req.setAttribute("Marks", markRepository.findAll());
		    requestDispatcher.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		    Integer mark = Integer.parseInt(req.getParameter("mark"));
		    System.out.println(mark);
	        String comments = req.getParameter("comments");
	        System.out.println(comments);
	        markRepository.create(new Marks(mark, comments));
		    System.out.println(String.format("mark: %s, comments: %s", mark, comments));
		    MARKS.add(new Marks(mark, comments));
		    doGet(req, resp);
	}
	@Override
	public void init() throws ServletException {
		getInitParameter("123");
		ServletContext sc = getServletContext();
		this.markRepository = (MarkRepository)sc.getAttribute("markRepository");
	}
	@Override
	public void destroy() {
		
	}
	
}
