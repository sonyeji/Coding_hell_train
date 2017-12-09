package termProject;

public class MainClass {
	public static void main (String args[]) {
		System.out.println("test phone");
		Phone phone1 = new Phone("01012345678");
		Phone phone2 = new Phone("010-1234-5678");
		Phone nullphone = new Phone("1234");
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(nullphone);
		
		System.out.println("test department");
		Department depart1 = new Department("Lab");
		Department depart2 = new Department(Department.Departments[1]);
		Department nulldepart = new Department("Hell, world!");
		System.out.println(depart1);
		System.out.println(depart2);
		System.out.println(nulldepart);
	}
}
