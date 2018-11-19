package by.liba.student.webservlet.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Students;
import by.liba.student.webservlet.Student;

public class StudentReader {// extends EntityReader<Students>{
	private final String path;

	public StudentReader(String path) {
		this.path = path;
	}
  
	
	public List<Students> read() throws IOException{
		List<Students> students = new ArrayList<Students>();
		
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = null;
			while((line = br.readLine())!= null) {
				String[] data = line.split(";");
				Students student = new Students(data[1], data[2]);
				student.setId(Integer.valueOf(data[0]));
				students.add(student);
			}
		} finally {
			if(br!=null)
				br.close();
		}
		
		return students;
}
//	@Override
//	public Students mapLine(String line) {
//		String[] data = line.split(";");
//		Students students = new Students();
//		students.setId(Integer.parseInt(data[0]));
//		students.setFirstName(data[1]);
//		students.setSecondName(data[2]);
//		return students;
//	}

}
