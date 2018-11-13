package by.liba.student.webservlet.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Professors;

public class ProfessorReader {
	 private final String path;

		public ProfessorReader(String path) {
			this.path = path;
		}
		public List<Professors> read() throws FileNotFoundException, IOException{
			List<Professors> professors = new ArrayList<Professors>();
			try(BufferedReader br = new BufferedReader(new FileReader(path))){
				String line = null;
				while((line = br.readLine()) != null){
					String[] data = line.split(";");
					Professors professor = new Professors();
					professor.setId(Integer.parseInt(data[0]));
					professor.setFirstName(data[1]);
					professor.setSecondName(data[2]);
					professor.setFatherdName(data[3]);
					professors.add(professor);
					System.out.println(professor);
				}
			}
			return professors;
		}
}
