package by.liba.student.webservlet.writers;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import by.liba.student.common.Marks;

public class MarkWriter {
	private final String path;

	public MarkWriter(String path) {
		this.path = path;
	}
	public void writer(List<Marks> marks) throws IOException{
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))){
			for (Marks mark : marks){
				System.out.println("MarkWriter " + mark.getId()+" "+mark.getMark()+" "+mark.getComments());
				String line = String.format("%s;%s;%s", 
						mark.getId(), 
						mark.getMark(),
						mark.getComments());
				bw.write(line);
				bw.newLine();
			}
		}
	}
}
