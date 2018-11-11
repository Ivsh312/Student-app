package by.liba.student.common;

public class Groups {
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
		public int getAvgMark() {
			return avgMark;
		}
		public void setAvgMark(int avgMark) {
			this.avgMark = avgMark;
		}
         
         
}
