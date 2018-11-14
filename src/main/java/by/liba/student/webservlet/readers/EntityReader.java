package by.liba.student.webservlet.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Students;

public class EntityReader<T> implements Reader<T>{
      private final String path;
      private final LineMapper<T> mapper;

	public EntityReader(String path, LineMapper<T> mapper) {
		this.path = path;
		this.mapper = mapper;
	}
	
	public List<T> read(){
		List<T> items = new ArrayList<T>();
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = null;
			while((line = br.readLine()) != null){
//				T item = this.mapper.mapLine(line);
//				items.add(item);
			}
		}catch (Exception e) {
			new RuntimeException(e);
		}
		return items;
	}
	
      
}
