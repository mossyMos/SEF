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



}
