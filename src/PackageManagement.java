import java.util.ArrayList;
import java.util.Scanner;

public class PackageManagement {
    Scanner input = new Scanner(System.in);
    ArrayList<TravelPackage> packageList = new ArrayList<TravelPackage>();
    ArrayList<Customer> customerList = new ArrayList<Customer>();

    public void addIndividualPackage(){
        try {
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
        }catch (Exception e){
            System.out.println("The Input is Invalid, please enter valid input!!");
        }
    }

    public void addGroupPackage(){
        try{
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

            System.out.print("Minimum Number Participant: ");
            int minNumber = input.nextInt(); 

            System.out.print("Group Discount: ");
            int groupDiscount = input.nextInt();
            input.nextLine();

            packageList.add(new GroupPackage(packageId, packageName, location, price, days, details, minNumber, groupDiscount));
        }catch (Exception e){
            System.out.println("The Input is Invalid, please enter valid input!!");
        }     
    }

    public void showPackage() {
        try{
            for (TravelPackage travelPackage : packageList){
                travelPackage.detailPackage();
            }
        }catch (Exception e){
            System.out.println("Error in the travel package");
        }
    }

    public void addCustomer() {
        try {
            int id = (customerList.size()) + 1;

            System.out.print("Name: ");
            String name = input.nextLine();

            System.out.print("Nationality: ");
            String nationality = input.nextLine();

            System.out.print("Age: ");
            int age = input.nextInt();
            input.nextLine();

            customerList.add(new Customer(id, name, nationality, age));
        }catch (Exception e){
            System.out.println("The Input is Invalid, please enter valid input!!");
        }  
    }

    public void showCustomer() {
        try{
            for (Customer customer : customerList) {
                customer.customerDetail();
            }           
        }catch (Exception e){
            System.out.println("Error in the travel package");
        }   
    }

    public void buyPackage() {
        try{
            Customer customerObj = loginCustomer();
            if (customerObj == null){
                return;
            }

            showPackage();
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
        }catch (Exception e){
            System.out.println("Data Invalid");
        }
    }

    public Customer loginCustomer(){
        try{
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

            System.out.println("The Customer ID is not found");
            return null;
        }catch (Exception e){
            System.out.println("Invalid Data");
            return null;
        }
    }
}
