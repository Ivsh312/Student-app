package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.List;
import by.liba.student.requarents.Request;

public class EntityRepository<T, D> implements Repository<T, D>{
	//private final Map<Integer, T> entities = new LinkedHashMap<>();
	Request <T, D> requarents ;
	
	public EntityRepository(Request <T, D> requarents) {
		if (requarents != null) {
				this.requarents = requarents;
		}
	}
	
	public List<T> findAll(D filter) {
		return new ArrayList<T>(requarents.getAll(filter));
	}

	public T findOne(Integer id) {
		return requarents.getById(id);
	}
	
	public void create(T entity) {
		requarents.createItem(entity);
	}

	public void remove(T entity) {
		requarents.deleteItem(entity);
	}
	
	public void removeById(Integer id) {
		requarents.deleteItemById(id);
	}

	public T update(T entity) {
		return requarents.updateItem(entity);
	}
}
