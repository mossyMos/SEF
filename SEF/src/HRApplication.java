import java.util.ArrayList;
import java.util.Scanner;

public class HRApplication {
	private static ArrayList<Staff> accounts = new ArrayList<Staff>();

	public static void main(String[] args) {
		seedLogins();
	}

	// Adds the login details of the users into the system
	public static void seedLogins() {
		// Since there's only one user for each of these staff members, the log in details are stored in an array
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
	}
