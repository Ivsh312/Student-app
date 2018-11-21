package by.liba.student.requarents;

import java.util.List;

import by.liba.student.common.Professors;

public interface Request <T, D>{
    
    public String createReuqestCreate(T entity, List<Object> params);
    
    public String createReuqestDelete(T entity);
    
    public String createReuqestUpdate(T entity);
    
    public String createReuqestGetById(Integer id);
    
    public String createReuqestGetAll(D filter, List<Object> params);
    

    

    
    
}
