import java.util.Scanner;

public class Coordinator extends Staff{
	
	public Coordinator(String username, String password) {
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
			// exitProgram();
			break;
		default:
			System.out.println("Error! - Illegal character input, please try again.");
			menuChoice();
		}
	}
}


	


