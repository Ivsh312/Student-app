package by.liba.student.common;

public class Studies extends Entity{
    private String name;
    private Integer hours;
    private Integer id;
    private Integer avgMark;
    
    
	public Studies() {
		super();
	}
	
	public Studies(String name, Integer hours, Integer id, Integer avgMark) {
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

	public Integer getAvgMark() {
		return avgMark;
	}

	public void setAvgMark(Integer avgMark) {
		this.avgMark = avgMark;
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
    
}
