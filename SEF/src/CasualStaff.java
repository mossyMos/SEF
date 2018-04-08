import java.util.Scanner;

public class CasualStaff extends Staff {
	
	public CasualStaff(String username, String password){
		super(username, password);
	}
	
	public static String Menu() {
		String zeroString = "UNDER CONSTRUCTION \n";
		String firstString = "*** Casual Staff Menu *** \n";
	
		
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
			// Add the actual methods in here to access them
			break;
		case "b":
		
			break;
		case "c":
			
			break;
		case "d":
		
			break;
		case "e":
		
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
