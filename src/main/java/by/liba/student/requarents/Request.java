package by.liba.student.requarents;

import java.util.List;

public interface Request <T>{
    public void createListItemS(List<T> items);
    public void createItem(T item);
    public void deleteItem(T item);
    public void deleteListItemS(List<T> items);
    public void updateItem(T item);
    public void updateListItemS(List<T> items);
    public T getById(Integer id);
    
}
