import java.util.ArrayList;
import java.util.Scanner;

public class PackageManagement {
    Scanner input = new Scanner(System.in);
    ArrayList<TravelPackage> packageList = new ArrayList<TravelPackage>();

    public void addIndividualPackage(){
        System.out.print("Package ID: ");
        int packageId = input.nextInt();

        input.nextLine();
        System.out.print("Package Name: ");
        String packageName = input.nextLine();

        System.out.print("Location: ");
        String location = input.nextLine();

        System.out.print("Price: ");
        int price = input.nextInt();

        System.out.print("Travel Duration: ");
        int days = input.nextInt(); 

        input.nextLine();
        System.out.print("Details: ");
        String details = input.nextLine();

        System.out.print("Add-On: ");
        String addOn = input.nextLine();

        packageList.add(new IndividualPackage(packageId, packageName, location, price, days, details, addOn));
        System.out.println();
    }

    public void addGroupPackage(){
        System.out.print("Package ID: ");
        int packageId = input.nextInt();

        input.nextLine();
        System.out.print("Package Name: ");
        String packageName = input.nextLine();

        System.out.print("Location: ");
        String location = input.nextLine();

        System.out.print("Price: ");
        int price = input.nextInt();

        System.out.print("Travel Duration: ");
        int days = input.nextInt(); 

        input.nextLine();
        System.out.print("Details: ");
        String details = input.nextLine();

        System.out.print("Minimum Number Participant: ");
        int minNumber = input.nextInt(); 

        System.out.print("Group Discount: ");
        int groupDiscount = input.nextInt();

        packageList.add(new GroupPackage(packageId, packageName, location, price, days, details, minNumber, groupDiscount));
    }

    public void showPackage() {
        for (TravelPackage travelPackage : packageList){
            travelPackage.detailPackage();
        }
    }
}
