package by.liba.student.common;

public class Professors extends Entity{
    private Integer id;
    private String firstName;
    private String secondName;
    private String fatherdName;
    //private Date BirthDate;
    private Integer avgMark;
    
    
	public Professors() {
		super();
	}
	
	public Professors(Integer id, String firstName, String secondName, String fatherdName, Integer avgMark) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.fatherdName = fatherdName;
		this.avgMark = avgMark;
	}

	public Professors(String firstName, String secondName, String fatherdName) {
		this.firstName = firstName;
		this.secondName = secondName;
		this.fatherdName = fatherdName;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getFatherdName() {
		return fatherdName;
	}
	public void setFatherdName(String fatherdName) {
		this.fatherdName = fatherdName;
	}
	public Integer getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(Integer avgMark) {
		this.avgMark = avgMark;
	}

	@Override
	public String toString() {
		return "Professors [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", fatherdName="
				+ fatherdName + ", avgMark=" + avgMark + "]";
	}
    
}
