import java.io.PrintWriter;
import java.util.Scanner;

public class CreateCourse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //reads user data (number of courses)
        System.out.print("Enter how many courses do you wish to add: ");
        int numOfCourses = Integer.parseInt(scan.nextLine());

        //puts the courses into an array
        String arrayOfCourses[] = new String[numOfCourses];
        for (int i = 0; i < arrayOfCourses.length; i++) {
            System.out.print("Enter the ID of course " + (i + 1) + " : ");
            arrayOfCourses[i] = scan.nextLine();
        }

        try {
            PrintWriter pr = new PrintWriter("file.txt");

            //Prints list to file.txt
            for (int i = 0; i < arrayOfCourses.length; i++) {
                pr.println(arrayOfCourses[i]);
            }
            pr.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No such file exists.");
        }
    }
}
