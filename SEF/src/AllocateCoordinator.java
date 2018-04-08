
public class AllocateCoordinator extends Course{
 
    private String Coord_name;
 
    public AllocateCoordinator(String Course_name, String Course_ID, int Course_pay, String Coord_name) {
        super(Course_name,Course_ID,Course_pay);
        this.Coord_name = Coord_name;
    }
 
    public String getCoord_name(){
        return Coord_name;
    }
 
 
    public String getDetails() {
 
        String fourthLine = String.format("%-20s %s\n", "Coordinator name:", Coord_name);
 
        return fourthLine;
 
    }
 
}