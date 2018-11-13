package by.liba.student.webservlet.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.liba.student.common.Professors;

public class ProfessorWriter {
	 private final String path;

		public ProfessorWriter(String path) {
			this.path = path;
		}
		public void writer(List<Professors> professors) throws IOException{
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
				for (Professors professor : professors){
					String line = String.format("%s;%s;%s", 
							professor.getId(), 
							professor.getFirstName(),
							professor.getSecondName());
					        professor.getFatherdName();
					bw.write(line);
					bw.newLine();
				}
			}
		}
}
