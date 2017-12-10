package termProject;

public class Employee {
	public static final Employee NIL = new Employee();
	private GeneralInfoManagement generalInfo;
	private CompanyInfoManagement companyInfo;
	private AttendanceInfoManagement attendanceInfo;
	
	public GeneralInfoManagement getGeneralInfo() {
		return generalInfo;
	}
	public CompanyInfoManagement getCompanyInfo() {
		return companyInfo;
	}
	public AttendanceInfoManagement getAttendanceInfo() {
		return attendanceInfo;
	}
	
	private Employee() {
		this.generalInfo = new GeneralInfoManagement("Unknown Name", "Unknown Gender", "Unknown Address", new Phone("Unknown Phone Number"));
		this.companyInfo = new CompanyInfoManagement(-1, Grade.gradeUnknown, Department.departUnknown, Workplace.workplaceUnknown);
		this.attendanceInfo = new AttendanceInfoManagement(-1, -1, -1);
	}
	
	public Employee(String name, String gender, String address, Phone phone,
					int id, Grade grade, Department depart, Workplace workplace,
					int attendance, int absence, int leave) {
		this.generalInfo = new GeneralInfoManagement(name, gender, address, phone);
		this.companyInfo = new CompanyInfoManagement(id, grade, depart, workplace);
		this.attendanceInfo = new AttendanceInfoManagement(attendance, absence, leave);
	}
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append(generalInfo.toString());
		buf.append(companyInfo.toString());
		buf.append(attendanceInfo.toString());
		
		return buf.toString();
	}
}

class GeneralInfoManagement {
	private String name;
	private String gender;
	private String address;
	private Phone phone;
	
	public GeneralInfoManagement(String name, String gender, String address, Phone phone) {
		this.name = name;
		this.gender = gender;
		this.address = address;
		this.phone = phone;
	}
	
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
	
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("Name\t\t: " + name + "\n");
		buf.append("Gender\t\t: " + gender + "\n");
		buf.append("Address\t\t: " + address + "\n");
		buf.append("Phone Number\t: " + phone + "\n\n");
		
		return buf.toString();
	}
}

class CompanyInfoManagement {
	private int id;
	private Grade grade;
	private Department depart;
	private Workplace workplace;
	
	public CompanyInfoManagement (int id, Grade grade, Department depart, Workplace workplace) {
		this.id = id;
		this.grade = grade;
		this.depart = depart;
		this.workplace = workplace;
	}
	
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
	public Workplace getWorkplace() {
		return workplace;
	}
	public void setWorkplace (Workplace workplace) {
		this.workplace = workplace;
	}
	
	public String toString () {
		StringBuffer buf = new StringBuffer();
		buf.append("Employee Id\t: " + id + "\n");
		buf.append("Department\t: " + depart + "\n");
		buf.append("Employee Grade\t: " + grade + "\n");
		buf.append("Workplace\t: " + workplace + "\n\n");
		
		return buf.toString();
	}
}

class AttendanceInfoManagement {
	private int attendance;
	private int absence;
	private int leave;
	
	public AttendanceInfoManagement (int attendance, int absence, int leave) {
		this.attendance = attendance;
		this.absence = absence;
		this.leave = leave;
	}
	
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
	
	public String toString () {
		StringBuffer buf = new StringBuffer();
		buf.append("Attendance\t: " + attendance + " days\n");
		buf.append("Absence\t\t: " + absence + " days\n");
		buf.append("Leave\t\t: " + leave + " days\n\n");
		
		return buf.toString();
	}
}