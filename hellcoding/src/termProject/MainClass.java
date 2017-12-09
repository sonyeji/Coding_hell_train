package termProject;

public class MainClass {
	public static void main (String args[]) {
		System.out.println("Test Phone");
		Phone phone1 = new Phone("01012345678");
		Phone phone2 = new Phone("010-1234-5678");
		Phone nullphone = new Phone("1234");
		System.out.println(phone1);
		System.out.println(phone2);
		System.out.println(nullphone);
		
		System.out.println();
		
		System.out.println("Test Department");
		System.out.println(Department.departSales);
		System.out.println(Department.departGeneralAffairs.getCommission());
		
		System.out.println();
		
		System.out.println("Test Workplace");
		System.out.println(Workplace.workplaceSeoul);
		System.out.println(Workplace.workplaceDaejeon);
	}
}
