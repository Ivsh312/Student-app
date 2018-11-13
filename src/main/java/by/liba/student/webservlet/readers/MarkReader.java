package by.liba.student.webservlet.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Marks;

public class MarkReader {
	private final String path;

	public MarkReader(String path) {
		this.path = path;
	}
	
	public List<Marks> read() throws FileNotFoundException, IOException{
		List<Marks> marks = new ArrayList<Marks>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = null;
			while((line = br.readLine()) != null){
				String[] data = line.split(";");
				Marks mark = new Marks();
				mark.setId(Integer.parseInt(data[0]));
				mark.setMark(Integer.parseInt(data[1]));
				mark.setComments(data[2]);
				marks.add(mark);
				System.out.println(mark.toString());
			}
		}
		return marks;
	}
}
