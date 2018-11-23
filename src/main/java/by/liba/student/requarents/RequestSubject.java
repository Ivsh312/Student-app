package by.liba.student.requarents;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import by.liba.student.common.Groups;
import by.liba.student.common.Professors;
import by.liba.student.common.StringUtil;
import by.liba.student.common.Students;
import by.liba.student.common.Subject;
import by.liba.student.requarents.sql.SqlHelper;
import by.liba.student.utils.Database;
import by.liba.student.webservlet.repositores.EntityRepository;
import filters.GroupFilter;
import filters.ProfessorFilter;
import filters.StudentFilter;
import filters.SubjectFilter;

public class RequestSubject extends EntityRequest<Subject, SubjectFilter> {
	private String tableName;
	private String defoltProfessor = "0";
	private String defoltProfessorFirstname = "0";
	private String defoltProfessorSecindname = "0";
	private EntityRepository<Professors, ProfessorFilter> professorsRepository;

	public RequestSubject(String tableName, EntityRepository<Professors, ProfessorFilter> professorsRepository) {
		super(tableName);
		this.tableName = tableName;
		this.professorsRepository = professorsRepository;
		// TODO Auto-generated constructor stub
	}

	public RequestSubject() {
		super("");
	}

	@Override
	public String createReuqestGetById(Integer id) {
		// TODO Auto-generated method stub
		return this.getGetAllSql() + " WHERE STUDY_ID = ?";
	}

	@Override
	public Subject createItem(ResultSet resultSet) throws SQLException {
		Subject subject = new Subject();
		subject.setId(resultSet.getInt("STUDY_ID"));
		subject.setName(resultSet.getString("NAME"));
		subject.setHours(resultSet.getInt("HOURS"));
		subject.setProfessorId(resultSet.getInt("PROFESS_ID"));
		Double avgMark = resultSet.getDouble("AVG_MARK");
		if (avgMark != null && avgMark != 0.0) {
			subject.setAvgMark(avgMark);
		}
		return subject;
	}

	@Override
	public String createReuqestGetById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestCreate(Subject subject, List<Object> params) {
		Random rand = new Random();
		System.out.println("createReuqestCreate");
		String professorId = "";
		professorId = (new RequestSubject()).findProfessor(String.valueOf(subject.getProfessorId()));
		// groupNumber = StringUtil.trim(groupNumber);
		if ("".equals(professorId) || professorId == null) {
			String def = "";
			def = (new RequestSubject()).findProfessor(defoltProfessor);
			if ("".equals(def) || def == null) {
				Professors professor = new Professors();
				professor.setFirstName(defoltProfessorFirstname);
				professor.setSecondName(defoltProfessorSecindname);
				professor.setId(Integer.valueOf(defoltProfessor));
				subject.setProfessorId(Integer.valueOf(defoltProfessor));
				this.professorsRepository.create(professor);
			} else {
				subject.setProfessorId(Integer.valueOf(defoltProfessor));
			}
		}

		String CreateSql = this.getCreateSql()
				+ "(NAME, HOURS, PROFESS_ID, AVG_MARK, STUDY_ID) VALUES ";
		CreateSql += "('" + subject.getName() + "', '" + subject.getHours() + "', '"
				+ subject.getProfessorId() + "', '" + subject.getAvgMark() + "', '" + rand.nextInt(32000) + "')";
		return CreateSql;
	}

	private String findProfessor(String defoltProfessor) {
		String item = null;
		System.out.println("findGroupNumber");
		try (Connection connect = (new Database()).getConnection()) {
			String sql = "SELECT * FROM BEGANSS."+ "Profess" + " WHERE PROFESS_ID = ?";
			System.out.println("sql");
			System.out.println("findGroupNumber: "+sql);
			PreparedStatement ps = connect.prepareStatement(sql);
			System.out.println(sql);
			ps.setString(1, defoltProfessor);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				item = rs.getString("PROFESS_ID");
			}
		} catch (Throwable ex) {
			throw new RuntimeException(ex);
		}
		return StringUtil.trim(item);
	}

	@Override
	public String createReuqestGetAll(SubjectFilter filter, List<Object> params) {
		return this.getGetAllSql() + " WHERE " + SqlHelper.addLike(params, "NAME", filter.getName(), "AND")
		+ SqlHelper.addLike(params, "HOURS", String.valueOf(filter.getHours()), "AND")
		+ SqlHelper.addLike(params, "AVG_MARK", String.valueOf(filter.getAvgMark()), "AND") + "1=1";

// return "SELECT * FROM BEGANSS.STUDENT where 1+1 ";
}

	@Override
	public String createReuqestDelete(Subject entity, List<Object> params) {
		return getDeleteSql() + " WHERE " + SqlHelper.addFildDef(params, "STUDENT_ID", String.valueOf(entity.getId()), "");
	}

	@Override
	public String createReuqestUpdate(Subject entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String createReuqestGetByGroupNumber(String groupId) {
		// TODO Auto-generated method stub
		return null;
	}

}
