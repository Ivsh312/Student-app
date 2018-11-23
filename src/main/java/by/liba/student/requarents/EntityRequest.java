package by.liba.student.requarents;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class EntityRequest<T, D> implements Request<T, D>{
    
	private final String tableName;	
	private final String getAllSql;
	private final String CreateSql;
	private final String DeleteSql;
	private final String UpdateSql;
    
    public EntityRequest(String tableName) {
    	this.tableName = tableName;
    	this.getAllSql = "SELECT * FROM BEGANSS." + tableName;
    	this.CreateSql = "INSERT INTO BEGANSS." + tableName;
    	this.DeleteSql = "DELETE FROM BEGANSS." + tableName;
    	this.UpdateSql = "UPDATE BEGANSS." + tableName;
    	
    }
    
    public abstract T createItem(ResultSet resultSet) throws SQLException;
    public abstract String createReuqestGetById();
    public abstract String createReuqestCreate(T entity, List<Object> params);
    public abstract String createReuqestGetAll(D filter, List<Object> params);
    public abstract String createReuqestDelete(T entity, List<Object> params);
    public abstract String createReuqestUpdate(T entity);
	public abstract String createReuqestGetByGroupNumber(String groupId);

	public String getTableName() {
		return tableName;
	}

	public String getGetAllSql() {
		return getAllSql;
	}


	public String getCreateSql() {
		return CreateSql;
	}


	public String getDeleteSql() {
		return DeleteSql;
	}


	public String getUpdateSql() {
		return UpdateSql;
	}

}
