import java.util.Scanner;

public class IndividualPackage extends TravelPackage{
    private String addOn;

    Scanner input = new Scanner(System.in);

    public IndividualPackage(int pacakageId, String packageName, String location, int price, int days,
            String details, String addOn) {
        super(pacakageId, packageName, location, price, days, details);
        this.addOn = addOn;
    }

    public String getAddOn() {
        return addOn;
    }

    public void setAddOn(String addOn) {
        this.addOn = addOn;
    }

    @Override
    public void detailPackage(){
        System.out.println("--------------------------------------");
        System.out.println("| Package Status: Individual Package |");
        super.detailPackage();
        System.out.println("| Group Add-On: " + addOn + "               |");
        System.out.println("--------------------------------------");

    }

    public void inputIndividualPackageData(){
        try{
            System.out.println("======================================");
            System.out.print("| Package Name: ");
            this.packageName = input.nextLine();
    
            System.out.print("| Location: ");
            this.location = input.nextLine();
    
            System.out.print("| Price: ");
            this.price = input.nextInt();
    
            System.out.print("| Travel Duration: ");
            this.days = input.nextInt();
            input.nextLine();

            System.out.print("| Details: ");
            this.details = input.nextLine();
    
            System.out.print("| Add-On: ");
            this.addOn = input.nextLine();
            System.out.println("======================================");
    
        }catch (Exception e){
            System.out.println("The Input is Invalid, please enter valid input!!");
        }
    }
}