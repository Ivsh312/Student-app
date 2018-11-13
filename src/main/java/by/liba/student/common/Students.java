package by.liba.student.common;

public class Students {
	private Integer id;
	private String firstName;
	private String secondName;
	private Integer avgMark;
	private String groupNumber;

	public Students() {
		super();
	}

	public Students(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}


	public Students(Integer id, String firstName, String secondName, Integer avgMark, String groupNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.avgMark = avgMark;
		this.groupNumber = groupNumber;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(Integer avgMark) {
		this.avgMark = avgMark;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
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

	@Override
	public String toString() {
		return "Students [id=" + id + ", firstName=" + firstName
				+ ", secondName=" + secondName + ", avgMark=" + avgMark
				+ ", groupNumber=" + groupNumber + "]";
	}

}
