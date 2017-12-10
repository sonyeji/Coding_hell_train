package termProject;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDatabase {
	private static EmployeeDatabase instance;
	private Map<Integer, Employee> employees;
	
	private EmployeeDatabase() {
		this.employees = new HashMap<Integer, Employee>();
	}
	
	// Singleton pattern
	public static EmployeeDatabase getInstance() {
		if (instance == null)
			instance = new EmployeeDatabase();
		return instance;
	}
	
	public boolean addEmployee (Employee emp) {
		Integer empid = emp.getCompanyInfo().getId();
		if(employees.containsKey(empid) == true) return false;
		employees.put(empid, emp);
		return true;
	}
	
	public boolean delEmployee (Employee emp) {
		Integer empid = emp.getCompanyInfo().getId();
		if(employees.containsKey(empid) == false) return false;
		employees.remove(empid);
		return true;
	}
	
	public boolean delEmployee (Integer empid) {
		if(employees.containsKey(empid) == false) return false;
		employees.remove(empid);
		return true;
	}
	
	public Employee getEmployee (Employee emp) {
		Integer empid = emp.getCompanyInfo().getId();
		if(employees.containsKey(empid) == true) return employees.get(empid);
		return Employee.NIL;
	}
	
	public Employee getEmployee (Integer empid) {
		if(employees.containsKey(empid) == true) return employees.get(empid);
		return Employee.NIL;
	}
}