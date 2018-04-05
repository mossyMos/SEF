import java.io.PrintWriter;
import java.util.Scanner;

public class CreateCourse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //reads user data (number of courses)
        System.out.print("Enter how many courses do you wish to add: ");
        int numOfCourses = Integer.parseInt(scan.nextLine());

        //puts the courses and rates into arrays
        String arrayOfCourses[] = new String[numOfCourses];
        int ratesOfCourses[] = new int[numOfCourses];
        for (int i = 0; i < arrayOfCourses.length; i++) {
            System.out.println("Enter the ID of course " + (i + 1) + " : ");
            arrayOfCourses[i] = scan.nextLine();
        }

        for (int i = 0; i < arrayOfCourses.length; i++) {
            System.out.println("Enter the rates of course " + (i + 1) + " : ");
            ratesOfCourses[i] = scan.nextInt();
        }

        try {
            PrintWriter pr = new PrintWriter("Courselist.txt");

            //Prints list to file.txt
            for (int i = 0; i < arrayOfCourses.length; i++) {
                pr.print(arrayOfCourses[i]);
                pr.print(", ");
                pr.println(ratesOfCourses[i]);
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
}