import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class HRApplication {
	static String Course_name;
    static String Course_ID;
    static int Course_pay;
	public static final String AccountFile = "UserAccounts";
	private static ArrayList<Staff> accounts = new ArrayList<Staff>();
	private static ArrayList<Course> array = new ArrayList<Course>();

	public static void main(String[] args) {
		try {
			UserAccounts();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void UserAccounts() throws FileNotFoundException{
		Scanner input = new Scanner(new File(AccountFile));
		
		while (input.hasNextLine()) {
			
			String line = input.nextLine();
			if(line.equals("ADMIN")) {
				String AdminUsername = input.nextLine();
				String AdminPassword = input.nextLine();
				
				Admin admin = new Admin(AdminUsername, AdminPassword);
				accounts.add(admin);
				
			}  if(line.equals("COORDINATOR")){
				String coordinatorUsername = input.nextLine();
				String coordinatorPassword = input.nextLine();
				
				Coordinator coordinator = new Coordinator(coordinatorUsername, coordinatorPassword);
				accounts.add(coordinator);

			} if(line.equals("APPROVER")){
				String approverUsername = input.nextLine();
				String approverPassword = input.nextLine();
				
				Approver approver = new Approver(approverUsername, approverPassword);
				accounts.add(approver);

			} if(line.equals("CASUAL")){
				String casualUsername = input.nextLine();
				String casualPassword = input.nextLine();
				
				CasualStaff casual = new CasualStaff(casualUsername, casualPassword);
				accounts.add(casual);

			}
			
		} loginSystem();
	}
	
	// Adds the login details of the users into the system
//	public static void seedLogins() {
//		// Since there's only one user for each of these staff members, the log
//		// in details are stored in an array
//		Admin admin = new Admin("Admin", "cat");
//		Approver approver = new Approver("Approver", "dog");
//		Coordinator coordinator = new Coordinator("Coordinator", "mouse");
//		accounts.add(admin);
//		accounts.add(approver);
//		accounts.add(coordinator);
//		loginSystem();
//	}

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
					} else if (accounts.get(i) instanceof CasualStaff) {
						CasualStaff.menuChoice();
						 
					}
				}
			}
		}

		System.out.println("Username or password is incorrect, please try again");
		loginSystem();
		input.close();
	}

	 public static void addCourse() {
		 
	        Scanner user_input = new Scanner(System.in);
	 
	        // input course name
	        System.out.printf("%-35s %s", "Enter Course Name:", "");
	        Course_name = user_input.nextLine();
	 
	        // input vehicle Height checks if its numeric
	        System.out.printf("%-35s %s", "Please Course ID:", "");
	        Course_ID = user_input.nextLine();
	 
	        System.out.printf("%-35s %s", "Enter pay rates per hour:", "");
	        Course_pay = user_input.nextInt();
	 
	        Course newCourse = new Course(Course_name, Course_ID, Course_pay);
	        array.add(newCourse);
	 
	        System.out.printf("New Course created successfully for %s !%n", Course_name);
	 
	        Admin.menuChoice();
	        user_input.close();
	    }
	 
	    public static void addCoordinator() {
	        Scanner user_input = new Scanner(System.in);
	 
	        String cID = null;
	 
	            System.out.printf("%-35s %s", "Enter course ID:", "");
	            cID = user_input.nextLine();
	 
	        // Checking if registration id already exist
	        boolean cIDExists = false;
	        for (Course g : array) {
	            if ((cID.equals(g.getCourse_ID()))) {
	                cIDExists = true;
	            }
	        }
	 
	        if (cIDExists) {
	            System.out.printf("%-35s %s", "Enter coordinator name:", "");
	            String Coord_name = user_input.nextLine();
	 
	            AllocateCoordinator newCoord = new AllocateCoordinator(Course_name, Course_ID, Course_pay,Coord_name);
	            array.add(newCoord);
	 
	            System.out.printf("Successfully allocated for %s !%n", Course_ID);
	 
	            Admin.menuChoice();
	            user_input.close();
	 
	 
	        } else {
	            System.out.println("no course ID found.");
	            Admin.menuChoice();
	        }
	 
	    }
	

	public static void Report() {
		
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i).getDetails());
		}
		Admin.menuChoice();
	}
	
	public static void Logout(){
		try {
			UserAccounts();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 							//Restarts the program
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
