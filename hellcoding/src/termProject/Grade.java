package termProject;

// Staff - AssistantManager - Manager - DeputyGeneralManager - GeneralManager
// 사원 - 대리 - 과장 - 차장 - 부장

public class Grade {
	public static final String[] Grades = {
			"Unknown Grade",
			"Staff",
			"Assistant Manager",
			"Manager",
			"Deputy General Manager",
			"General Manager"
	};
	public static final int[] Salaries = {
			0,
			100,
			200,
			300,
			400,
			500
	};
	private String name;
	private int salary;
	private int grade;
	public static final Grade gradeUnknown = new Grade(0);
	public static final Grade gradeStaff = new Grade(1);
	public static final Grade gradeAssistantManager = new Grade(2);
	public static final Grade gradeManager = new Grade(3);
	public static final Grade gradeDeputyGeneralManager = new Grade(4);
	public static final Grade gradeGeneralManager = new Grade(5);
	
	public static Grade getGradeByNumber (int number) {
		Grade tmp;
		switch (number) {
		case 1:
			tmp = gradeStaff;
		case 2:
			tmp = gradeAssistantManager;
			break;
		case 3:
			tmp = gradeManager;
			break;
		case 4:
			tmp = gradeDeputyGeneralManager;
			break;
		case 5:
			tmp = gradeGeneralManager;
			break;
		default :
			tmp = gradeUnknown;
		}
		return tmp;
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
	
	private Grade (int grade) {
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
}
