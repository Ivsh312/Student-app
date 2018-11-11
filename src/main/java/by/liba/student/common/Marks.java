package by.liba.student.common;

public class Marks {
     private Integer mark;
     private String comments;
     
     
	public Marks(Integer mark, String comments) {
		super();
		this.mark = mark;
		this.comments = comments;
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
     
     
}
