package by.liba.student.common;

import java.util.Random;

public class Students extends Entity{
	private Integer id;
	private String firstName;
	private String secondName;
	private Double avgMark;
	private String groupNumber;

	public Students() {
		super();
		Random r = new Random();
		this.id = r.nextInt(111111);
	}

	public Students(String firstName, String secondName) {
		super();
		this.firstName = firstName;
		this.secondName = secondName;
	}


	public Students(Integer id, String firstName, String secondName, Double avgMark, String groupNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
		this.avgMark = avgMark;
		this.groupNumber = groupNumber;
	}

	public Students(Integer id, String firstName, String secondName) {
		this.id = id;
		this.firstName = firstName;
		this.secondName = secondName;
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

	public void setAvgMark(Double avgMark) {
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
