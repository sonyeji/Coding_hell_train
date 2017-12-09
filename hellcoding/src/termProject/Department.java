package termProject;

// Sales , Technical , General Affairs , Human Resource , Lab , Management
// 영업 , 기술 , 총무 , 인사 , 개발 , 회계

public class Department {
	public static final String[] Departments = {
			"Sales",
			"Technical",
			"General Affairs",
			"Human Resource",
			"Lab",
			"Management"
	};
	public static final int[] Commissions = {
			100,
			400,
			300,
			500,
			600,
			400
	};
	
	private String name;
	private int commission;
	
	public Department (String depart) {
		for (int i=0; i<Departments.length; i++) {
			if (Departments[i].equals(depart)) {
				this.name = Departments[i];
				this.commission = Commissions[i];
				return;
			}
		}
		this.name = "NULL";
		this.commission = 0;
	}
	
	public int getCommission() {
		return this.commission;
	}
	public String toString() {
		return this.name;
	}
}