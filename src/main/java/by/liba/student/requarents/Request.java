package by.liba.student.requarents;

import java.util.List;

public abstract class Request<D> {
	public List<D> getAll() {
		return null;
	}

	public void createListItemS(List<D> items) {
	};

	public D createItem(D item) {
		return null;
	};

	public void deleteItem(Integer id) {
	};

	public void deleteListItemS(List<D> items) {
	};

	public D updateItem(D item) {
		return null;
	};

	public List<D> updateListItemS(List<D> items) {
		return null;
	};

	public D getById(Integer id) {
		return null;
	}

}
