package by.liba.student.webservlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.liba.student.common.Professors;
import by.liba.student.webservlet.readers.ProfessorReader;
import by.liba.student.webservlet.repositores.ProfessorRepository;
import by.liba.student.webservlet.writers.ProfessorWriter;

public class ProfessorsContextListener implements ServletContextListener{
	private ProfessorRepository professorRepository;
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		List<Professors> professor;
		try {
			ServletContext sc = sce.getServletContext();
			String filePath = sc.getInitParameter("professor.file.path");
			
			professor = new ProfessorReader(filePath).read();
			this.professorRepository = new ProfessorRepository(professor);
			
			
			sc.setAttribute("professorRepository", professorRepository);
		} catch (IOException e) {
			// TODO Auto-generated catch block
		
		}

	}
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		try{
			ServletContext sc = sce.getServletContext();
			String filePath = sc.getInitParameter("student.file.path");
			List<Professors> professors = this.professorRepository.findAll();
			new ProfessorWriter(filePath).writer(professors);
		}catch(IOException e){
			System.out.println("failed");
		}
		
	}
}
