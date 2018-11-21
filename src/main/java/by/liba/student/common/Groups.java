package by.liba.student.common;

public class Groups extends Entity{
         private String groupNumber;
         private Double avgMark;
         
		public Groups() {
			super();
		}
		public Groups(String groupNumber, Double avgMark) {
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
		public Double getAvgMark() {
			return avgMark;
		}
		public void setAvgMark(Double d) {
			this.avgMark = d;
		}
         
         
}
