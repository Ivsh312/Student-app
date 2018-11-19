package by.liba.student.webservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.liba.student.common.Users;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher disp = req.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		disp.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String name = req.getParameter("user");
		String pass = req.getParameter("pass");
		if("admin".equals(name) &&
				req.getRequestURI().contains("/login")){
			HttpSession session = req.getSession();
			session.setAttribute("user", new Users(name, pass));
			resp.sendRedirect(req.getContextPath() + "/login");
		}else{
			doGet(req, resp);
		}
	}

}
