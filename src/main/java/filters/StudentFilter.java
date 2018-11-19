package filters;

public class StudentFilter {
	private String firstName;
	private String secondname;
	private String groupNumber;

	public StudentFilter() {
		firstName = "";
		secondname = "";
		groupNumber = "";
	}

	public StudentFilter(String firstName, String secondname, String groupNumber) {
		this.firstName = firstName;
		this.secondname = secondname;
		this.groupNumber = groupNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondname() {
		return secondname;
	}

	public void setSecondname(String secondname) {
		this.secondname = secondname;
	}

	public String getGroupNumber() {
		return groupNumber;
	}

	public void setGroupNumber(String groupNumber) {
		this.groupNumber = groupNumber;
	}
}
