package by.liba.student.common;

public class Marks {
	 private Integer id;
     private Integer mark;
     private String comments;
     private Integer studyId;
     private Integer studentId;
     //private Date data;
     private Integer proffessorId;
     

	public Marks() {
		super();
	}

	public Marks(Integer mark, String comments) {
		super();
		this.mark = mark;
		this.comments = comments;
	}
	
	
	
	public Marks(Integer id, Integer mark, String comments, Integer studyId, Integer studentId, Integer proffessorId) {
		super();
		this.setId(id);
		this.mark = mark;
		this.comments = comments;
		this.studyId = studyId;
		this.studentId = studentId;
		this.proffessorId = proffessorId;
	}

	public Integer getStudyId() {
		return studyId;
	}

	public void setStudyId(Integer studyId) {
		this.studyId = studyId;
	}

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getProffessorId() {
		return proffessorId;
	}

	public void setProffessorId(Integer proffessorId) {
		this.proffessorId = proffessorId;
	}

	public Integer getMark() {
		return mark;
	}
	public void setMark(Integer mark) {
		this.mark = mark;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
     
     
}
