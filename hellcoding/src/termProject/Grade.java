package termProject;

// Staff - AssistantManager - Manager - DeputyGeneralManager - GeneralManager
// 사원 - 대리 - 과장 - 차장 - 부장

public class Grade {
	public static final String[] Grades = {
			"Staff",
			"Assistant Manager",
			"Manager",
			"Deputy General Manager",
			"General Manager",
	};
	public static final int[] Salaries = {
			100,
			200,
			300,
			400,
			500
	};
	private String name;
	private int salary;
	private int grade;
	
	public Grade () {
		this(0);
	}
	
	public Grade (int grade) {
		if (grade >= Grades.length) {
			this.grade = 0;
			this.name = Grades[0];
			this.salary = Salaries[0];
		} else {
			this.grade = grade;
			this.name = Grades[grade];
			this.salary = Salaries[grade];
		}
	}
	
	public int changeGrade (int gradeToChange) {
		int oldGrade = this.grade;
		if (gradeToChange >= Grades.length) {
			this.grade = 0;
			this.name = Grades[0];
			this.salary = Salaries[0];
			return oldGrade;
		}
		this.grade = gradeToChange;
		this.name = Grades[gradeToChange];
		this.salary = Salaries[gradeToChange];
		return oldGrade;
	}
	
	public int getGrade () {
		return this.grade;
	}
	public int getGradeSalary () {
		return this.salary;
	}
	public String toString () {
		return this.name;
	}
}
