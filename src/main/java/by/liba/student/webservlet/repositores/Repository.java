package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;

import by.liba.student.requarents.Request;

public interface Repository<T, D> {

	public List<T> findAll(D filtr);

	public T findOne(Integer id) ;

	public int create(T entity) ;

	public Integer remove(T entity);

	public int update(T entity) ;
}
