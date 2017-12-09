package termProject;

import java.util.LinkedList;
import java.util.List;

public class EmployeeDatabase {
	private static EmployeeDatabase instance;
	private List<Employee> employees;
	private EmployeeDatabase() {
		this.employees = new LinkedList<Employee>();
	}
	
	// Singleton pattern
	public static EmployeeDatabase getInstance() {
		if (instance == null)
			instance = new EmployeeDatabase();
		return instance;
	}
}