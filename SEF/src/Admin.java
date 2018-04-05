import java.util.Scanner;

public class Admin extends Staff {

	public Admin(String username, String password) {
		this.username = username;
		this.password = password;
	}



	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername(String username) {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword(String password) {
		return password;

	}

	public static String Menu() {
		String zeroString = "------------------------------- \n";
		String firstString = "*** Admin Menu *** \n";
		String secondString = String.format("%-25s %s\n", "Create Course", "A");
		String thirdString = String.format("%-25s %s\n", "Allocate course", "B");
		String fourthString = String.format("%-25s %s\n", "Create Timetable", "C");
		String fifthString = String.format("%-25s %s\n", "Report", "D");
		String sixthString = String.format("%-25s %s", "Exit Program", "X");

		return zeroString + firstString + secondString + thirdString + fourthString + fifthString + sixthString;
	}

	public static void menuChoice() {
		String choice;

		System.out.println(Menu());
		Scanner s = new Scanner(System.in);
		choice = s.next();
		System.out.println("-------------------------------");
		switch (choice.toLowerCase()) {
		case "a":
			HRApplication.addCourse();
			break;
		case "b":
			// EditCourseList();
			break;
		case "c":
			// createTimetable();
			break;
		case "d":
			// viewPayroll();
			break;
		case "e":
			// createReport();
			break;
		case "x":
			// exitProgram();
			break;
		default:
			System.out.println("Error! - Illegal character input, please try again.");
			menuChoice();
		}
	}
}

