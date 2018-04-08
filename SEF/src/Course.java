
public class Course {
 
    private String Course_name;
    private String Course_ID;
    private int Course_pay;
 
    public Course(String Course_name, String Course_ID, int Course_pay) {
        this.Course_name = Course_name;
        this.Course_ID = Course_ID;
        this.Course_pay = Course_pay;
    }
 
    public String getCourse_ID(){
        return Course_ID;
    }
 
 
        public String getDetails() {
 
            // this method prints out details.
            String firstLine = String.format("%-20s %s\n", "Course name:", Course_name);
            String secondLine = String.format("%-20s %s\n", "Course ID:", Course_ID);
            String thirdLine = String.format("%-20s %s\n", "Pay per hour:", Course_pay);
 
            return firstLine + secondLine + thirdLine;
 
    }
 
    }