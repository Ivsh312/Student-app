package by.liba.student.webservlet;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.SessionCookieConfig;
import javax.servlet.SessionTrackingMode;
import javax.servlet.descriptor.JspConfigDescriptor;

import by.liba.student.common.Students;

public class ApplicationContextListener implements ServletContextListener{
	private StudentRepository studentRepository;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Students> students;
		try {
			ServletContext sc = sce.getServletContext();
			String filePath = sc.getInitParameter("student.file.path");
			
			students = new StudentReader(filePath).read();
			this.studentRepository = new StudentRepository(students);
			
			
			sc.setAttribute("studentRepository", studentRepository);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		}
		
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try{
			ServletContext sc = sce.getServletContext();
			String filePath = sc.getInitParameter("student.file.path");
			List<Students> strudents = this.studentRepository.findAll();
			new StudentWriater(filePath).writer(strudents);
		}catch(IOException e){
			System.out.println("failed");
		}
		
	}
	
}
