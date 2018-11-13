package by.liba.student.webservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.liba.student.common.Marks;
import by.liba.student.webservlet.readers.MarkReader;
import by.liba.student.webservlet.repositores.MarkRepository;
import by.liba.student.webservlet.writers.MarkWriter;

public class MarkContextListener implements ServletContextListener{
	private MarkRepository markRepository;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Marks> mark;
		try {
			ServletContext sc = sce.getServletContext();
			String filePath = sc.getInitParameter("mark.file.path");
			
			mark = new MarkReader(filePath).read();
			this.markRepository = new MarkRepository(mark);
			
			
			sc.setAttribute("markRepository", this.markRepository);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		}
		
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try{
			ServletContext sc = sce.getServletContext();
			String filePath = sc.getInitParameter("student.file.path");
			List<Marks> marks = this.markRepository.findAll();
			new MarkWriter(filePath).writer(marks);
		}catch(IOException e){
			System.out.println("failed");
		}
		
	}
	
}
