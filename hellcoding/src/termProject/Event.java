package termProject;

public class Event {
	protected int startDay;
	protected int endDay;
	private String comment;
	
	public Event () {
		this.startDay = 0;
		this.endDay = 0;
		this.comment = "";
	}
	
	public Event (int startDay, int endDay, String comment) {
		this.startDay = startDay;
		this.endDay = endDay;
		this.comment = comment;
	}
	
	public int getStartDay() {
		return startDay;
	}
	public void setStartDay(int startDay) {
		this.startDay = startDay;
	}
	public int getEndDay() {
		return endDay;
	}
	public void setEndDay(int endDay) {
		this.endDay = endDay;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Event\t\t: " + comment + "\n");
		buf.append("Schedule\t: " + startDay + " ~ " + endDay + "\n");
		return buf.toString();
	}
}
