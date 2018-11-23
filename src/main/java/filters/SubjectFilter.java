package filters;

public class SubjectFilter {
    private String name;
    private Integer hours;
    private Double avgMark;
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
	public Double getAvgMark() {
		return avgMark;
	}
	public void setAvgMark(Double double1) {
		this.avgMark = double1;
	}
	@Override
	public String toString() {
		return "SubjectFilter [name=" + name + ", hours=" + hours + ", avgMark=" + avgMark + "]";
	}
    
}
