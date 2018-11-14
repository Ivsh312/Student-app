package by.liba.student.webservlet.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Students;
import by.liba.student.webservlet.Student;

public class StudentReader implements LineMapper<Student>{
      private final String path;

	public StudentReader(String path) {
		this.path = path;
	}
	
	public Students mapLian(String line){
		String[] data = line.split(";");
		Students students = new Students();
		students.setId(Integer.parseInt(data[0]));
		students.setFirstName(data[1]);
		students.setSecondName(data[2]);
		return students;
	}
	
      
}
