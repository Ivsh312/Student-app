package by.liba.student.webservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.liba.student.common.Students;
import by.liba.student.webservlet.readers.StudentReader;
import by.liba.student.webservlet.repositores.StudentRepository;
import by.liba.student.webservlet.writers.StudentWriter;

public class StudentsContextListener implements ServletContextListener{
	private StudentRepository studentRepository;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Students> students;
		try {
			ServletContext sc = sce.getServletContext();
			String filePath = sc.getInitParameter("student.file.path");
			
//			students = new StudentReader(filePath).read();
//			this.studentRepository = new StudentRepository(students);
			
			
			sc.setAttribute("studentRepository", this.studentRepository);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		
		}
		
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try{
			ServletContext sc = sce.getServletContext();
			String filePath = sc.getInitParameter("student.file.path");
			List<Students> strudents = this.studentRepository.findAll();
			new StudentWriter(filePath).writer(strudents);
		}catch(IOException e){
			System.out.println("failed");
		}
		
	}
	
}
