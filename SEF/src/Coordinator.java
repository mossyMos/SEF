import java.util.Scanner;

public class Coordinator extends Staff{
	
	public Coordinator(String username, String password) {
		super(username, password);
	}



	

	public static String Menu() {
		String zeroString = "UNDER CONSTRUCTION \n";
		String firstString = "*** Coordinator Menu *** \n";
	
		
		return zeroString + firstString;
	}

	public static void menuChoice() {
		String choice;

		System.out.println(Menu());
		Scanner s = new Scanner(System.in);
		choice = s.next();
		System.out.println("-------------------------------");
		switch (choice.toLowerCase()) {
		case "a":
			// createCourseList(); Add the actual methods in here to access them
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
			HRApplication.Logout();
			break;
		default:
			System.out.println("Error! - Illegal character input, please try again.");
			menuChoice();
		}
	}
}


	


