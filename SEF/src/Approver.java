import java.util.Scanner;

public class Approver extends Staff {

	
	
	
	public Approver(String username, String password){
		super(username, password);
	}

	
	
	public static String Menu() {
		String zeroString = "------------------------------- \n";
		String firstString = "*** Approver Menu *** \n";
		String secondString = String.format("%-25s %s\n", "Offer course", "A");
		String thirdString = String.format("%-25s %s\n", "Approve course", "B");
		
		String fourthString = String.format("%-25s %s", "Exit Program", "X");

		return zeroString + firstString + secondString + thirdString + fourthString ;
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
			// 
			break;
		case "c":
			// 
			break;
		case "d":
			// 
			break;
		case "e":
			// 
			break;
		case "x":
			//
			break;
		default:
			System.out.println("Error! - Illegal character input, please try again.");
			menuChoice();
		}
	}

}


