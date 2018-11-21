package filters;

public class ProfessorFilter {
	private String firstName;
	private String secondname;
	private Double avgMark;
	
	public ProfessorFilter(){
		firstName = null;
		secondname = null;
		avgMark = 0.0;
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
	public Double getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(Double avgMark) {
		this.avgMark = avgMark;
	}
	@Override
	public String toString() {
		return "ProfessorFilter [firstName=" + firstName + ", secondname=" + secondname + ", avgMark=" + avgMark + "]";
	}
	
	
}
