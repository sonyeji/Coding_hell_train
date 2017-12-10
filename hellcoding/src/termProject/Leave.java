package termProject;

public class Leave extends Event {
	private Employee emp;
	
	public Leave (Employee emp, int startDay, int endDay) {
		this.startDay = startDay;
		this.endDay = endDay;
		this.emp = emp;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}
	
	public String toString () {
		StringBuffer buf = new StringBuffer();
		buf.append("Employee (empid)\t: " + emp.getGeneralInfo().getName() + " (" + emp.getCompanyInfo().getId() + ")" + "\n");
		buf.append("Schedule\t\t: " + startDay + " ~ " + endDay + "\n");
		return buf.toString();
	}
}
