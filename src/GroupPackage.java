import java.util.Scanner;

public class GroupPackage extends TravelPackage {
    private int minNumber;
    private int groupDiscount;

    Scanner input = new Scanner(System.in);

    public GroupPackage(int pacakageId, String packageName, String location, int price, int days,
            String details, int minNumber, int groupDiscount) {
        super(pacakageId, packageName, location, price, days, details);
        this.minNumber = minNumber;
        this.groupDiscount = groupDiscount;
    }
    
    public int getMinNumber() {
        return minNumber;
    }

    public void setMinNumber(int minNumber) {
        this.minNumber = minNumber;
    }

    public int getGroupDiscount() {
        return groupDiscount;
    }

    public void setGroupDiscount(int groupDiscount) {
        this.groupDiscount = groupDiscount;
    }

    @Override
    public void detailPackage(){
        System.out.println("--------------------------------------");
        System.out.println("| Package Status: Group Package       |");
        System.out.println("| Minimum Number of Participant: " + minNumber + " |");
        super.detailPackage();
        System.out.println("| Group Discount: " + groupDiscount + "%              |");
        System.out.println("--------------------------------------");
    }

    public void inputGroupPackageData(){
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
    
            System.out.print("| Minimum Number Participant: ");
            this.minNumber = input.nextInt();
    
            System.out.print("| Group Discount: ");
            this.groupDiscount = input.nextInt();
            input.nextLine();
            System.out.println("======================================");
        }catch (Exception e){
            System.out.println("Error in the travel package");
        }

    }
}