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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	public Department getDepart() {
		return depart;
	}
	public void setDepart(Department depart) {
		this.depart = depart;
	}
}

class AttendanceInfoManagement {
	private int attendance;
	private int absence;
	private int leave;
	public int getAttendance() {
		return attendance;
	}
	public void setAttendance(int attendance) {
		this.attendance = attendance;
	}
	public int getAbsence() {
		return absence;
	}
	public void setAbsence(int absence) {
		this.absence = absence;
	}
	public int getLeave() {
		return leave;
	}
	public void setLeave(int leave) {
		this.leave = leave;
	}
}