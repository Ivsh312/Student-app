package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import by.liba.student.common.Entity;
import by.liba.student.requarents.Request;

public class EntityRepository<T extends Request<D>, D> {
	//private final Map<Integer, T> entities = new LinkedHashMap<>();
	T requarents;
	
	public EntityRepository(T requarents) {
		if (requarents != null) {
				this.requarents = requarents;
		}
	}

	public List<D> findAll() {
		return new ArrayList<>(requarents.getAll());
	}

	public D findOne(Integer id) {
		return requarents.getById(id);
	}

	public D create(D entity) {
		return requarents.createItem(entity);
	}

	public void remove(Integer id) {
		requarents.deleteItem(id);
	}

	public D update(D entity) {
		return requarents.updateItem(entity);
	}
}
