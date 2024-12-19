import java.util.ArrayList;
import java.util.Scanner;

public class PackageManagement {
    Scanner input = new Scanner(System.in);
    ArrayList<TravelPackage> packageList = new ArrayList<TravelPackage>();
    ArrayList<Customer> customerList = new ArrayList<Customer>();

    public void addIndividualPackage(){
        int packageId = (packageList.size()) + 1;

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

    public void addCustomer() {
        int id = (customerList.size()) + 1;

        System.out.print("Name: ");
        String name = input.nextLine();

        System.out.print("Nationality: ");
        String nationality = input.nextLine();

        System.out.print("Age: ");
        int age = input.nextInt();

        input.nextLine();

        customerList.add(new Customer(id, name, nationality, age));
    }

    public void showCustomer() {
        for (Customer customer : customerList) {
            customer.customerDetail();
        }
    }

    public void buyPackage() {
        Customer customerObj = loginCustomer();
        if (customerObj == null){
            return;
        }
        System.out.println("Choose the package: ");
        int choose = input.nextInt();
        input.nextLine();

        TravelPackage packageChoosen = packageList.get(choose-1);

        if (packageChoosen instanceof IndividualPackage){
            IndividualPackage packaged = (IndividualPackage) packageChoosen;
            customerObj.buyPackage(packaged.getPackageName());
        }else if (packageChoosen instanceof GroupPackage){
            GroupPackage packaged = (GroupPackage) packageChoosen;
            customerObj.buyPackage(packaged.getPackageName());
        }
    }

    public Customer loginCustomer(){
        Customer customerObj;
        showCustomer();
        System.out.println("Who are you: ");
        int choose = input.nextInt();
        input.nextLine();

        for (Customer customer : customerList) {
            int customerId = customer.getId();
            if (choose == customerId){
                customerObj = customer;
                return customerObj;
            } 
        } 

        System.out.println("The Customer Id is not found");
        return null;

    }
}
