import java.util.Scanner;

public class Staff {

    public static void main(String[] args){
        menu();
    }


    private static void menu() {

        Scanner user_input = new Scanner(System.in);

        // displaying the feature of the menu
        System.out.println("*** Admin System Menu ***" + '\n');
        System.out.printf("%-25s %s\n", "Create Course", "A");
        System.out.printf("%-25s %s\n", "Allocate Course", "B");
        System.out.printf("%-25s %s\n", "Report", "C");
        System.out.printf("%-25s %s\n", "Exit Program", "x");
        String option = user_input.next();

        // a switch statement to control which function to call
        switch (option.toUpperCase()) {
            case "A":
                break;
            case "B":
                break;
            case "C":
                //gonna make a constructor for course and run in through the arraylist to print everything.
//                for (Course s : arrayList) {
//                    System.out.println("----------------------------");
//                    //will print everything from the constructor using the method getDetails.
//                    System.out.println(s.getDetails());
//                    System.out.println("----------------------------");
//                }
                break;
            case "D":
                break;
            case "X":
                break;
            default:
                System.out.println("invalid key");
                menu();

                break;
        }
        user_input.close();
    }

    public String getDetails() {

        // this method prints out details.
//        String firstLine = String.format("%-20s %s\n", "Course name:", CorName);
//        String secondLine = String.format("%-20s %s\n", "Course code:", CorCode);
//        String thirdLine = String.format("%-20s %s\n", "Course XX:", Time);
//        String fourthLine = String.format("%-20s %s\n", "Course XX:", description);
//        String fifthLine = String.format("%-20s %s\n", "Course XX:", Rates);
//        return firstLine + secondLine + thirdLine + fourthLine + fifthLine ;
//    }


        return null;
    }
}
