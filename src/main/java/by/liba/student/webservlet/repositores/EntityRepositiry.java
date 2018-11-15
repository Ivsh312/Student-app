package by.liba.student.webservlet.repositores;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import by.liba.student.common.Entity;
import by.liba.student.common.Marks;

public class EntityRepositiry<T extends Entity> {
	private final Map<Integer, T> entities = new LinkedHashMap<>();

	public EntityRepositiry(List<T> entities) {
		if (entities != null) {
			for (T ent : entities)
				this.entities.put(ent.getId(), ent);
		}
	}

	public List<T> findAll() {
		return new ArrayList<>(entities.values());
	}

	public T findOne(String id) {
		return entities.get(id);
	}

	public T create(T entity) {
		Random random = new Random();
		int id = random.nextInt(100);
		entity.setId(id);
		entities.put(id, entity);
		return entity;
	}

	public void remove(String id) {
		entities.remove(id);
	}

	public T update(T entity) {
		entities.put(entity.getId(), entity);
		return entity;
	}
}
