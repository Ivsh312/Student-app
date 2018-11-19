package by.liba.student.requarents;

import java.util.List;
import by.liba.student.common.Professors;
import by.liba.student.utils.Database;
import filters.ProfessorFilter;

public class RequestProfessors implements Request<Professors, ProfessorFilter>{
	Database database = new Database();
	@Override
	public void createListItems(List<Professors> items) {
		// TODO Auto-generated method stub
		
	}
	

	@Override
	public void createItem(Professors item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Professors deleteItem(Professors item) {
		return item;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Professors> deleteListItems(List<Professors> items) {
		return null;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Professors updateItem(Professors item) {
		return item;
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Professors> updateListItems(List<Professors> items) {
		return items;
		// TODO Auto-generated method stub
		
	}

	@Override
	public Professors getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professors> getAll(ProfessorFilter filter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professors deleteItemById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
