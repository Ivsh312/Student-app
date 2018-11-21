package by.liba.student.requarents;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;


import by.liba.student.common.Professors;
import by.liba.student.common.StringUtil;

import by.liba.student.requarents.sql.SqlHelper;
import filters.ProfessorFilter;
public class RequestProfessors extends EntityRequest<Professors, ProfessorFilter> {
	private String tableName;
    
	public RequestProfessors() {
		super("");
	}
   
	public RequestProfessors(String tableName) {
		super(tableName);
		this.tableName = tableName;
		//this.groupRepository = groupRepository;
	}
	
	@Override
	public String createReuqestGetById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Professors createItem(ResultSet resultSet) throws SQLException {
		Professors professors = new Professors();
		professors.setId(Integer.valueOf(resultSet.getString("PROFESS_ID")));
		professors.setFirstName(StringUtil.trim(resultSet.getString("FIRST_NAME")));
		professors.setSecondName(StringUtil.trim(resultSet.getString("SECOND_NAME")));
		String avgMark = StringUtil.trim(resultSet.getString("AVG_MARK"));
		if (!StringUtil.isEmpty(avgMark)) {
			professors.setAvgMark(Double.valueOf(avgMark));
		}
		return professors;
	}

	@Override
	public String createReuqestGetById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestCreate(Professors entity, List<Object> params) {
		Random random = new Random();

		
		CreateSql += "(FIRST_NAME, SECOND_NAME, AVG_MARK, PROFESS_ID) VALUES ";
		CreateSql  += "('" +  entity.getFirstName() + "', '"
		+ entity.getSecondName() + "', '" 
        + entity.getAvgMark() + "', '" + random.nextInt(32000)+"')";
		System.out.println(CreateSql);
		return CreateSql;
	}

	@Override
	public String createReuqestGetAll(ProfessorFilter filter, List<Object> params) {
		System.out.println("0.0".equals(Double.toString(filter.getAvgMark())));
		String sql = getAllSql + " WHERE " + SqlHelper.addLike(params, "FIRST_NAME", filter.getFirstName(), "AND")
		+ SqlHelper.addLike(params, "SECOND_NAME", filter.getSecondname(), "AND")
		+ SqlHelper.addLike(params, "AVG_MARK", Double.toString(filter.getAvgMark()), "AND") + "1=1";
		return sql;
	}

	@Override
	public String createReuqestDelete(Professors entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestUpdate(Professors entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestGetByGroupNumber(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}


}
