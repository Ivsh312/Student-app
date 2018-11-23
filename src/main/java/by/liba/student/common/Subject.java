package by.liba.student.common;

public class Subject extends Entity{
    private String name;
    private Integer hours;
    private Integer id;
    private Double avgMark;
    private Integer professorId;
    
    
	public Subject(){
		super();
	}
	
	public Subject(String name, Integer hours, Integer id, Double avgMark) {
		super();
		this.name = name;
		this.hours = hours;
		this.id = id;
		this.avgMark = avgMark;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(Double d) {
		this.avgMark = d;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHours() {
		return hours;
	}
	public void setHours(Integer hours) {
		this.hours = hours;
	}

	public Integer getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Integer professorId) {
		this.professorId = professorId;
	}
    
}
