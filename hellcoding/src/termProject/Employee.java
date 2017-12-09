package termProject;

public class Employee {
	private GeneralInfoManagement generalInfo = new GeneralInfoManagement();
	private CompanyInfoManagement companyInfo = new	CompanyInfoManagement();
	private AttendanceInfoManagement attendanceInfo = new AttendanceInfoManagement();
	
	public GeneralInfoManagement getGeneralInfo() {
		return generalInfo;
	}
	public CompanyInfoManagement getCompanyInfo() {
		return companyInfo;
	}
	public AttendanceInfoManagement getAttendanceInfo() {
		return attendanceInfo;
	}
}

class GeneralInfoManagement {
	private String name;
	private String gender;
	private String address;
	private Phone phone;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Phone getPhone() {
		return phone;
	}
	public void setPhone(Phone phone) {
		this.phone = phone;
	}
}

class CompanyInfoManagement {
	private int id;
	private Grade grade;
	private Department depart;
}

class AttendanceInfoManagement {
	private int attendance;
	private int absence;
	private int leave;
}