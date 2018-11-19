package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;

import by.liba.student.requarents.Request;

public interface Repository<T, D> {

	public List<T> findAll(D filtr);

	public T findOne(Integer id) ;

	public void create(T entity) ;

	public void remove(T entity);
	
	public void removeById(Integer id) ;

	public T update(T entity) ;
}
