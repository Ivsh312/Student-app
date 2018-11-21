package by.liba.student.webservlet.repositores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import by.liba.student.common.Entity;
import by.liba.student.common.Groups;
import by.liba.student.requarents.EntityRequest;
import by.liba.student.requarents.Request;
import by.liba.student.utils.Database;

public class EntityRepository<T extends Entity, D> implements Repository<T, D> {
	// private final Map<Integer, T> entities = new LinkedHashMap<>();
	private final EntityRequest<T, D> requarents;
	private final Database dataSource;

	public EntityRepository(EntityRequest<T, D> requarents, Database dataSource) {
		this.requarents = requarents;
		this.dataSource = dataSource;
	}

	public List<T> findAll(D filter) {
		List<T> items = new ArrayList<T>();
		try (Connection connect = this.dataSource.getConnection()) {
			List<Object> params = new ArrayList<Object>();
			System.out.println(filter);
			String sql = requarents.createReuqestGetAll(filter, params);
			System.out.println(sql);

			PreparedStatement ps = connect.prepareStatement(sql);

			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i + 1, params.get(i));
			}

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				items.add(this.requarents.createItem(rs));
			}
			System.out.println(items);
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
		return items;
	}

	public int create(T entity) {
		int updateCount = 0;
		try (Connection conn = dataSource.getConnection()) {
			System.out.println("--" + entity);
			List<Object> params = new ArrayList<Object>();
			String sql = requarents.createReuqestCreate(entity, params);
			System.out.println("create: " + sql);
			Statement statement = conn.createStatement();
			updateCount = statement.executeUpdate(sql);
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
		return updateCount;
	}

	public T remove(T entity) {
		T oldEntity = null;
		try (Connection conn = dataSource.getConnection()) {
			Statement statement = conn.createStatement();
			ResultSet rs = statement.executeQuery(this.requarents.createReuqestDelete(entity));
			while (rs.next()) {
				oldEntity = this.requarents.createItem(rs);
			}
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
		return oldEntity;
	}

	public int update(T entity) {
		int updateCount = 0;
		try (Connection conn = dataSource.getConnection()) {
			Statement statement = conn.createStatement();
			updateCount = statement.executeUpdate(this.requarents.createReuqestUpdate(entity));
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
		return updateCount;
	}

	public EntityRequest<T, D> getRequarents() {
		return requarents;
	}

	public Database getDataSource() {
		return dataSource;
	}

	public T findOneInGroups(String groupId) {
		T item = null;
		try (Connection connect = this.dataSource.getConnection()) {
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(this.requarents.createReuqestGetByGroupNumber(groupId));
			if (rs.next()) {
				item = requarents.createItem(rs);
			}
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
		return item;
	}
	public T findOne(Integer id) {
		T item = null;
		try (Connection connect = this.dataSource.getConnection()) {
			Statement statement = connect.createStatement();
			ResultSet rs = statement.executeQuery(this.requarents.createReuqestGetById());
			if (rs.next()) {
				item = requarents.createItem(rs);
			}
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
		return item;
	}
	
}
