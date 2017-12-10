package termProject;

import java.util.Iterator;
import java.util.Scanner;

public class MainClass {
	private static Scanner sc = new Scanner(System.in);
	private static EmployeeDatabase empDB = EmployeeDatabase.getInstance();
	private static EventDatabase eventDB = EventDatabase.getInstance();
	public static void main (String args[]) {
		menuMain();
		sc.close();
	}
	
	private static void menuMain() {
		boolean exitFlag = false;
		
		while (!exitFlag) {
			System.out.println("Select what you want to login in.");
			System.out.println("1> Employee\t 2> Admin");
			System.out.println("3> Exit");
			switch (sc.nextInt()) {
			case 1:
				authEmployee();
				break;
			case 2:
				authAdmin();
				break;
			case 3:
				System.out.println("Thank you for using our service.");
				exitFlag = true;
				break;
			default :
				System.out.println("Wrong Input.");
			}
		}
	}
	
	private static void authEmployee() {
		System.out.print("Please give your id : ");
		int empid = sc.nextInt();
		Employee emp = empDB.getEmployee(empid);
		if (emp != Employee.NIL) {
			System.out.println("Hello, " + emp.getGeneralInfo().getName());
			menuEmployee(emp);
		} else {
			System.out.println("Unknown Employee Id.");
		}
	}
	
	private static void authAdmin() {
		System.out.print("Admin Password : ");
		String passwd = sc.next();
		if (passwd.equals("0000")) {
			System.out.println("Login Success.");
			menuAdmin();
		} else {
			System.out.println("Login Failed, Wrong Admin Password");
		}
	}
	
	private static void menuEmployee(Employee emp) {
		boolean exitFlag = false;
		
		while (!exitFlag) {
			System.out.println("Select what you want to do.");
			System.out.println("1> Record Attendance");
			System.out.println("2> Call for leave (never undo)");
			System.out.println("3> Call for retire (never undo)");
			System.out.println("4> Checkout Company Schedule.");
			System.out.println("5> Checkout My Leave Schedule.");
			System.out.println("6> Exit");
			switch (sc.nextInt()) {
			case 1: // record attendance
				emp.getAttendanceInfo().setAttendance(emp.getAttendanceInfo().getAttendance()+1);
				System.out.println("Your attendance has been recorded.");
				break;
			case 2: // call for leave
				System.out.print("Start Day (0 to cancel) : ");
				int startday = sc.nextInt();
				if (startday > 0) {
					System.out.print("End Day (0 to cancel) : ");
					int endday = sc.nextInt();
					if (endday > 0) {
						eventDB.addLeave(new Leave(emp, startday, endday));
						emp.getAttendanceInfo().setLeave(emp.getAttendanceInfo().getLeave() + (endday-startday+1));
					}
				}
				break;
			case 3: // call for retire
				if (eventDB.setRetire(emp.getCompanyInfo().getId())) {
					System.out.println("Your retirement request has been accepted.");
				} else {
					System.out.println("You already request retirement.");
				}
				break;
			case 4: // checkout company schedule
				Iterator<Event> it = eventDB.getEvents().iterator();
				while (it.hasNext()) {
					System.out.println(it.next().toString());
				}
				break;
			case 5: // checout my leave schedule
				Iterator<Leave> it1 = eventDB.getLeaveByEmployee(emp).iterator();
				while (it1.hasNext()) {
					System.out.println(it1.next().toString());
				}
				break;
			case 6:
				System.out.println("Logout Success.");
				exitFlag = true;
				break;
			default :
				System.out.println("Wrong Input.");
			}
		}
	}
	
	private static void menuAdmin() {
		boolean exitFlag = false;
		
		while (!exitFlag) {
			System.out.println("Select what you want to do.");
			System.out.println("1> Employee Management");
			System.out.println("2> Schedule Management");
			System.out.println("3> Payroll Management");
			System.out.println("4> Exit");
			switch (sc.nextInt()) {
			case 1: // Employee Management
				System.out.println("Select what you want to do.");
				System.out.println("1> Add new employee");
				System.out.println("2> Edit employee");
				System.out.println("3> Remove Employee");
				System.out.println("4> Check Employee");
				System.out.println("5> Exit");
				switch (sc.nextInt()) {
				case 1: // add new employee
					System.out.println("Select Grade");
					for (int i=1; i<Grade.Grades.length; i++)
						System.out.println(i + "> " + Grade.Grades[i]);
					int grade = sc.nextInt();
					System.out.println("Select Department");
					for (int i=1; i<Department.Departments.length; i++)
						System.out.println(i + "> " + Department.Departments[i]);
					int depart = sc.nextInt();
					System.out.println("Select Workplace");
					for (int i=1; i<Workplace.Places.length; i++)
						System.out.println(i + "> " + Workplace.Places[i]);
					int workplace = sc.nextInt();

					System.out.print("Name : ");
					String name = sc.next();
					System.out.print("Gender : ");
					String gender = sc.next();
					System.out.print("Address : ");
					String address = sc.next();
					System.out.print("Phone Number : ");
					String phone = sc.next();
					System.out.print("id : ");
					int id = sc.nextInt();
					
					Employee newEmp = new Employee(name, gender, address, new Phone(phone),
							id, Grade.getGradeByNumber(grade), Department.getDepartByNumber(depart), Workplace.getWorkplaceByNumber(workplace),
							0, 0, 0);
					
					if (empDB.addEmployee(newEmp)) {
						System.out.println("Employee has been added at Database.");
					} else System.out.println("Failed to add employee at Database.");
					
					break;
				case 2: // edit employee
					System.out.print("Employee id : ");
					Employee emp = empDB.getEmployee(sc.nextInt());
					if (emp.equals(Employee.NIL) == false) {
						System.out.println("Select what you want to edit.");
						System.out.println("1> Name");
						System.out.println("2> Gender");
						System.out.println("3> Address");
						System.out.println("4> Phone Number");
						System.out.println("5> Grade");
						System.out.println("6> Department");
						System.out.println("7> Workplace");
						System.out.println("8> Exit");
						switch(sc.nextInt()) {
						case 1:
							System.out.println("Present\t: " + emp.getGeneralInfo().getName());
							System.out.print("Edit to\t: ");
							emp.getGeneralInfo().setName(sc.next());
							break;
						case 2:
							System.out.println("Present\t: " + emp.getGeneralInfo().getGender());
							System.out.print("Edit to\t: ");
							emp.getGeneralInfo().setGender(sc.next());
							break;
						case 3:
							System.out.println("Present\t: " + emp.getGeneralInfo().getAddress());
							System.out.print("Edit to\t: ");
							emp.getGeneralInfo().setAddress(sc.next());
							break;
						case 4:
							System.out.println("Present\t: " + emp.getGeneralInfo().getPhone());
							System.out.print("Edit to\t: ");
							emp.getGeneralInfo().setPhone(new Phone(sc.next()));
							break;
						case 5:
							System.out.println("Select Grade");
							for (int i=1; i<Grade.Grades.length; i++)
								System.out.println(i + "> " + Grade.Grades[i]);
							emp.getCompanyInfo().setGrade(Grade.getGradeByNumber(sc.nextInt()));
							break;
						case 6:
							System.out.println("Select Department");
							for (int i=1; i<Department.Departments.length; i++)
								System.out.println(i + "> " + Department.Departments[i]);
							emp.getCompanyInfo().setDepart(Department.getDepartByNumber(sc.nextInt()));
							break;
						case 7:
							System.out.println("Select Workplace");
							for (int i=1; i<Workplace.Places.length; i++)
								System.out.println(i + "> " + Workplace.Places[i]);
							emp.getCompanyInfo().setWorkplace(Workplace.getWorkplaceByNumber(sc.nextInt()));
							break;
						case 8:
							break;
						default :
						}
						System.out.println("Employee " + emp.getCompanyInfo().getId() + " (" + emp.getGeneralInfo().getName() + ") has been edited.");
					} else System.out.println("Wrong Employee id.");
					break;
				case 3: // remove employee
					Iterator<Integer> it = eventDB.getRetires().iterator();
					if (it.hasNext()) System.out.println("Next employees (id) request retire.");
					while (it.hasNext()) {
						System.out.print(it.next().toString() + " ");
					}
					System.out.println();
					System.out.print("Employee id : ");
					int tmpid = sc.nextInt();
					eventDB.delRetire(tmpid);
					eventDB.delLeave(empDB.getEmployee(tmpid));
					empDB.delEmployee(tmpid);
					break;
				case 4: // check employee
					System.out.print("Employee id : ");
					System.out.println(empDB.getEmployee(sc.nextInt()));
					break;
				case 5: // exit
					break;
				default :
					System.out.println("Wrong Input.");
				}
				break;
			case 2: // Schedule mangement
				System.out.println("Select what you want to do.");
				System.out.println("1> Add Company Schedule");
				System.out.println("2> Checkout Company Schedule");
				System.out.println("3> Checkout Leave Schedule");
				System.out.println("4> Exit");
				switch (sc.nextInt()) {
				case 1:
					System.out.print("Start Day (0 to cancel) : ");
					int startday = sc.nextInt();
					if (startday > 0) {
						System.out.print("End Day (0 to cancel) : ");
						int endday = sc.nextInt();
						if (endday > 0) {
							System.out.print("Comment : ");
							sc.skip("[\\r\\n]+");
							eventDB.addEvent(new Event(startday, endday, sc.nextLine()));
						}
					}
					break;
				case 2:
					Iterator<Event> it = eventDB.getEvents().iterator();
					while (it.hasNext()) {
						System.out.println(it.next().toString());
					}
					break;
				case 3:
					Iterator<Leave> it1 = eventDB.getLeaves().iterator();
					while (it1.hasNext()) {
						System.out.println(it1.next().toString());
					}
					break;
				case 4: // exit
					break;
				default:
					System.out.println("Wrong Input.");
				}
				break;
			case 3: // Payroll management
				System.out.print("Employee id : ");
				Employee emp = empDB.getEmployee(sc.nextInt());
				int payment = emp.getCompanyInfo().getGrade().getGradeSalary() * emp.getCompanyInfo().getDepart().getCommission();
				if (emp.equals(Employee.NIL)) {
					System.out.println("Wrong Employee Id.");
				} else {
					System.out.println("Employee " + emp.getGeneralInfo().getName() + " (" + emp.getCompanyInfo().getId() + ") Payroll Info");
					System.out.println("Basic Grade Pay\t\t: " + emp.getCompanyInfo().getGrade().getGradeSalary());
					System.out.println("Department Commission\t: x" + emp.getCompanyInfo().getDepart().getCommission());
					System.out.println("Final Payment\t\t: $" + payment);
				}
				break;
			case 4:
				System.out.println("Logout Success.");
				exitFlag = true;
				break;
			default :
				System.out.println("Wrong Input.");
			}
		}
	}
}