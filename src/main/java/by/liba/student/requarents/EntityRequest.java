package by.liba.student.requarents;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public abstract class EntityRequest<T, D> implements Request<T, D>{
    
	private String tableName;	
    public String getAllSql;
    public String CreateSql;
    public String DeleteSql;
    public String UpdateSql;
    
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
    public abstract String createReuqestDelete(T entity);
    public abstract String createReuqestUpdate(T entity);
	public abstract String createReuqestGetByGroupNumber(String groupId);

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getGetAllSql() {
		return getAllSql;
	}

	public void setGetAllSql(String getAllSql) {
		this.getAllSql = getAllSql;
	}

	public String getCreateSql() {
		return CreateSql;
	}

	public void setCreateSql(String createSql) {
		CreateSql = createSql;
	}

	public String getDeleteSql() {
		return DeleteSql;
	}

	public void setDeleteSql(String deleteSql) {
		DeleteSql = deleteSql;
	}

	public String getUpdateSql() {
		return UpdateSql;
	}

	public void setUpdateSql(String updateSql) {
		UpdateSql = updateSql;
	}

}
