package by.liba.student.common;

public class Groups extends Entity{
         private String groupNumber;
         private Integer avgMark;
         
		public Groups() {
			super();
		}
		public Groups(String groupNumber, Integer avgMark) {
			super();
			this.groupNumber = groupNumber;
			this.avgMark = avgMark;
		}
		public String getGroupNumber() {
			return groupNumber;
		}
		public void setGroupNumber(String groupNumber) {
			this.groupNumber = groupNumber;
		}
		public Integer getAvgMark() {
			return avgMark;
		}
		public void setAvgMark(Integer avgMark) {
			this.avgMark = avgMark;
		}
         
         
}
