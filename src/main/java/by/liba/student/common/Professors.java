package by.liba.student.common;

public class Professors {
    private int id;
    private String firstName;
    private String secondName;
    private String fatherdName;
    //private Date BirthDate;
    private int avgMark;
    
    
	public Professors() {
		super();
	}
	
	public Professors(int id, String firstName, String secondName, String fatherdName, int avgMark) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.fatherdName = fatherdName;
		this.avgMark = avgMark;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public int getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(int avgMark) {
		this.avgMark = avgMark;
	}
    
}
