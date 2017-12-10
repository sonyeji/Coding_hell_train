package termProject;

// Sales , Technical , General Affairs , Human Resource , Lab , Management
// 영업 , 기술 , 총무 , 인사 , 개발 , 회계

public class Department {
	private String name;
	private int commission;
	public static final String[] Departments = {
			"Unknown Department",
			"Sales",
			"Technical",
			"General Affairs",
			"Human Resource",
			"Lab",
			"Management"
	};
	public static final int[] Commissions = {
			0,
			100,
			400,
			300,
			500,
			600,
			400
	};
	public static final Department departUnknown = new Department (Departments[0]);
	public static final Department departSales = new Department (Departments[1]);
	public static final Department departTechnical = new Department (Departments[2]);
	public static final Department departGeneralAffairs = new Department (Departments[3]);
	public static final Department departHumanResource = new Department (Departments[4]);
	public static final Department departLab = new Department (Departments[5]);
	public static final Department departManagement = new Department (Departments[6]);
	
	public static Department getDepartByNumber (int number) {
		Department tmp;
		switch (number) {
		case 1:
			tmp = departSales;
			break;
		case 2:
			tmp = departTechnical;
			break;
		case 3:
			tmp = departGeneralAffairs;
			break;
		case 4:
			tmp = departHumanResource;
			break;
		case 5:
			tmp = departLab;
			break;
		case 6:
			tmp = departManagement;
			break;
		default :
			tmp = departUnknown;
		}
		return tmp;
	}
	
	public int getCommission() {
		return this.commission;
	}
	public String toString() {
		return this.name;
	}
	
	private Department (String depart) {
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
}