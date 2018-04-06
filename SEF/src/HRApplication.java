import java.util.ArrayList;
import java.util.Scanner;

public class HRApplication {
	private static ArrayList<Staff> accounts = new ArrayList<Staff>();
	private static ArrayList<CreateCourse> array = new ArrayList<CreateCourse>();

	public static void main(String[] args) {
		seedLogins();
	}

	// Adds the login details of the users into the system
	public static void seedLogins() {
		// Since there's only one user for each of these staff members, the log
		// in details are stored in an array
		Admin admin = new Admin("Admin", "cat");
		Approver approver = new Approver("Approver", "dog");
		Coordinator coordinator = new Coordinator("Coordinator", "mouse");
		accounts.add(admin);
		accounts.add(approver);
		accounts.add(coordinator);
		loginSystem();
	}

	public static void loginSystem() {
		boolean idExist = false;
		Scanner input = new Scanner(System.in);
		System.out.printf("%-15s %s", "Please enter Username:", "");
		String usernameInput = input.nextLine();
		System.out.printf("%-15s %s", "Please enter Password:", "");
		String passwordInput = input.nextLine();

		for (int i = 0; i < accounts.size(); i++) {

			if (usernameInput.equals(accounts.get(i).getUsername())) {
				if (passwordInput.equals(accounts.get(i).getPassword())) {
					idExist = true;

					if (accounts.get(i) instanceof Admin) {
						Admin.menuChoice();
					} else if (accounts.get(i) instanceof Approver) {
						Approver.menuChoice();
					} else if (accounts.get(i) instanceof Coordinator) {
						Coordinator.menuChoice();
						// } else if (accounts.get(i) instanceof CasualStaff) {
						// Casual Staff method under construction
						// CasualStaff.menuChoice();
					}
				}
			}
		}

		System.out.println("Username or password is incorrect, please try again");
		loginSystem();
	}

	public static void addCourse() {

		Scanner user_input = new Scanner(System.in);

		// input course name
		System.out.printf("%-35s %s", "Enter Course Name:", "");
		String Course_name = user_input.nextLine();

		// input vehicle Height checks if its numeric
		System.out.printf("%-35s %s", "Please Course ID:", "");
		String Course_ID = user_input.nextLine();

		System.out.printf("%-35s %s", "Enter pay rates per hour:", "");
		int Course_pay = user_input.nextInt();

		CreateCourse newCourse = new CreateCourse(Course_name, Course_ID, Course_pay);
		array.add(newCourse);

		System.out.printf("New Course created successfully for %s !%n", Course_name);

		Admin.menuChoice();
		user_input.close();
	}

	public static void Report() {
		
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i).getDetails());
		}
		Admin.menuChoice();
	}
	
	public static void Logout(){
		seedLogins(); 							//Restarts the program
//		Scanner user_input = new Scanner(System.in);
//		System.out.print("Are you sure you want to log out?");
//		String a = user_input.nextLine();
//		
//		String secondString = String.format("%-25s %s\n", "To Logout, Press:", "A");
//		String thirdString = String.format("%-25s %s\n", "TO cancel, Press:", "B");
//		
//		switch (a.toLowerCase()) {
//		case "a":
//			seedLogins();
//			break;
//		case "b":
//			Admin.menuChoice();
//			break;
	}
}
