import java.util.Date;

public class IndividualPackage extends TravelPackage{
    private String addOn;
    private String packageStatus = "Individual";

    public IndividualPackage(int pacakageId, String packageName, String location, int price, int days,
            String details, String addOn) {
        super(pacakageId, packageName, location, price, days, details);
        this.addOn = addOn;
    }

    public void buyPackage(){
        
    }

    @Override
    public void detailPackage(){
        System.out.println("--------------------------------------");
        System.out.println("Package Status: Individual Package");
        super.detailPackage();
        System.out.println("Group Add-On: " + addOn);
        System.out.println("--------------------------------------");

    }
}
