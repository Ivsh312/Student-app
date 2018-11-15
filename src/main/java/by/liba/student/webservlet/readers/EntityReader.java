package by.liba.student.webservlet.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Students;

public class EntityReader<T> implements Reader<T> {
	private final String path;
	private final LineMapper<T> mapper;

	public EntityReader(String path, LineMapper<T> mapper) {
		this.path = path;
		this.mapper = mapper;
	}

	public List<T> read() {
		List<T> items = new ArrayList<T>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = null;
			while ((line = br.readLine()) != null) {
				T item = mapper.mapLine(line);
				items.add(item);
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		} finally {
			if (br != null)
				try {
					br.close();
				} catch (Exception e) {
					// ignore
				}

		}

		return items;
	}

}
