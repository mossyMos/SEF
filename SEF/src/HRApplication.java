import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
// USER LOGINS IN TEXT FILE "UserAccounts"  
public class HRApplication {
	static String Course_name;
    static String Course_ID;
    static int Course_pay;
	public static final String AccountFile = "UserAccounts";		//Text file that contains the logins for accounts
	private static ArrayList<Staff> accounts = new ArrayList<Staff>();		//Array that holds the login details for accounts
	private static ArrayList<Course> array = new ArrayList<Course>();		//Array that holds course details

	public static void main(String[] args) {
		try {
			UserAccounts(); 	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void UserAccounts() throws FileNotFoundException{ 	//This method Reads the username and passwords for each user from textfile "UserAccount"
		Scanner input = new Scanner(new File(AccountFile));				//Creats objects and adds to array list.
		
		while (input.hasNextLine()) {									//Loops as long as there is another line
			
			String line = input.nextLine();
			if(line.equals("ADMIN")) {									//Checks if the data is for Admin, creats admin object
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

	public static void loginSystem() {							//This is the Login driver method, It prompts the users to enter their username and passwords
		boolean idExist = false;								
		Scanner input = new Scanner(System.in);
		System.out.printf("%-15s %s", "Please enter Username:", "");
		String usernameInput = input.nextLine();
		System.out.printf("%-15s %s", "Please enter Password:", "");
		String passwordInput = input.nextLine();

		for (int i = 0; i < accounts.size(); i++) {				//Loops through the array list to match the username and password

			if (usernameInput.equals(accounts.get(i).getUsername())) {
				if (passwordInput.equals(accounts.get(i).getPassword())) {
					idExist = true;

					if (accounts.get(i) instanceof Admin) {		//Checks if the account details are for which user
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

		System.out.println("Username or password is incorrect, please try again");		//If account details dont exist, prompts user to try again
		loginSystem();																	//Restarts the method
		input.close();
	}

	 public static void addCourse() {						//Method for the addCourse option in the admin menu
		 
	        Scanner user_input = new Scanner(System.in);
	 
	        // input course name
	        System.out.printf("%-35s %s", "Enter Course Name:", "");
	        Course_name = user_input.nextLine();
	 
	        // input vehicle Height checks if its numeric
	        System.out.printf("%-35s %s", "Please Course ID:", "");
	        Course_ID = user_input.nextLine();
	 
	        System.out.printf("%-35s %s", "Enter pay rates per hour:", "");
	        Course_pay = user_input.nextInt();
	 
	        Course newCourse = new Course(Course_name, Course_ID, Course_pay);			//Creats object for the course and adds to course array
	        array.add(newCourse);
	 
	        System.out.printf("New Course created successfully for %s !%n", Course_name);
	 
	        Admin.menuChoice();
	        user_input.close();
	    }
	 
	    public static void addCoordinator() {			//Method for the Alloction option in the admin menu
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
	 
	            AllocateCoordinator newCoord = new AllocateCoordinator(Course_name, Course_ID, Course_pay,Coord_name); //Makes object of the allocation and adds to array
	            array.add(newCoord);
	 
	            System.out.printf("Successfully allocated for %s !%n", Course_ID);
	 
	            Admin.menuChoice();
	            user_input.close();
	 
	 
	        } else {
	            System.out.println("no course ID found.");
	            Admin.menuChoice();
	        }
	 
	    }
	

	public static void Report() {		//Method for the report function in the admin menu
										// Prints the details for the course and coordinator allocated to the course
		for (int i = 0; i < array.size(); i++) {
			System.out.println(array.get(i).getDetails());			//Steps through the array and prints the details
		}
		Admin.menuChoice();
	}
	
	public static void Logout(){	//Logout function to restarts the program by calling the login method
									//prompts the user to login again
		loginSystem();
		
	} 						
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
	

