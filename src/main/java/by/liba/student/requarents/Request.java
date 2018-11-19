package by.liba.student.requarents;

import java.util.List;

import by.liba.student.common.Professors;

public interface Request <T, D>{
    public void createListItems(List<T> items);
    
    public void createItem(T item);
    
    public T deleteItem(T item);
    
    public T updateItem(T item);
    
    public List<T> updateListItems(List<T> items);
    
    public T getById(Integer id);
    
    public List<T> getAll(D filtr);
    
    public T deleteItemById(Integer id);
    
    public List<T> deleteListItems(List<T> items);
    
}
