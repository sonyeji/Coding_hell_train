package termProject;

public class MainClass {
	public static void main (String args[]) {
		System.out.println("test");
		Department depart1 = new Department("Lab");
		Department depart2 = new Department(Department.Departments[1]);
		Department nulldepart = new Department("Hell, world!");
		System.out.println(depart1);
		System.out.println(depart2);
		System.out.println(nulldepart);
	}
}
