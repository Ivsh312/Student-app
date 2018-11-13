package by.liba.student.webservlet.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Students;

public class StudentReader {
      private final String path;

	public StudentReader(String path) {
		this.path = path;
	}
	
	public List<Students> read() throws FileNotFoundException, IOException{
		List<Students> students = new ArrayList<Students>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = null;
			while((line = br.readLine()) != null){
				String[] data = line.split(";");
				Students student = new Students();
				student.setId(Integer.parseInt(data[0]));
				student.setFirstName(data[1]);
				student.setSecondName(data[2]);
				students.add(student);
				System.out.println(student);
			}
		}
		return students;
	}
	
      
}
