import java.util.ArrayList;
import java.util.Scanner;

public class PackageManagement {
    Scanner input = new Scanner(System.in);
    ArrayList<TravelPackage> packageList = new ArrayList<TravelPackage>();
    ArrayList<Customer> customerList = new ArrayList<Customer>();

    public void addIndividualPackage(){
        try{
            int packageId = (packageList.size()) + 1;
            IndividualPackage individualPackage = new IndividualPackage(packageId, "", "", 0, 0, "", "");
            individualPackage.inputIndividualPackageData();
            packageList.add(individualPackage);
            System.out.println("Successfully add Individual Package");
            System.out.println();
        }catch (Exception e){
            System.out.println("The Input is Invalid, please enter valid input!!");
        }     
    }

    public void addGroupPackage(){
        try{
            int packageId = (packageList.size()) + 1;
            GroupPackage groupPackage = new GroupPackage(packageId, "", "", 0, 0, "", 0, 0);
            groupPackage.inputGroupPackageData();
            packageList.add(groupPackage);
            System.out.println("Successfully add Group Package");
            System.out.println();
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
        try{
            int id = (customerList.size()) + 1;
            Customer customer = new  Customer(id, null, null, 0);
            customerList.add(customer);
            customer.inputCustomerData();
            System.out.println("Successfully add Customer");
            System.out.println();
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
            System.out.println("======================================");
            System.out.println("|         Choose the package:        |");
            System.out.println("======================================");
            int choose = input.nextInt();
            input.nextLine();

            TravelPackage packageChoosen = packageList.get(choose-1);
            customerObj.buyPackage(packageChoosen, customerObj);
        }catch (Exception e){
            System.out.println("Data Invalid");
        }
    }

    public Customer loginCustomer(){
        try{
            Customer customerObj;
            showCustomer();
            System.out.println("======================================");
            System.out.println("|          Who are you:             |");
            System.out.println("======================================");
            System.out.print("Enter customer id: ");
            int choose = input.nextInt();
            input.nextLine();
            
            if (customerList.size() != 0){
                for (Customer customer : customerList) {
                    int customerId = customer.getId();
                    if (choose == customerId){
                        customerObj = customer;
                        return customerObj;
                    }
                }
            }
            
            System.out.println("======================================");
            System.out.println("|   The Customer Id is not found    |");
            System.out.println("======================================");
            return null;
        }catch (Exception e){
            System.out.println("Invalid Data");
            return null;
        }
    }
    
    public boolean payment(IndividualPackage packageBuyed, Customer customerBuying){
        try{
            System.out.println("Total Payment: " + packageBuyed.getPrice());
            System.out.print("Input the amount of payent: ");
            int paymentAmount = input.nextInt();
            input.nextLine();

            if (customerBuying.getBalance()-paymentAmount<0){
                System.out.println("Your balance is not enough");
                return false;
            }
            if (paymentAmount < 0){
                System.out.println("The amount payment is in the negative");
                return false;
            }else if (paymentAmount < packageBuyed.getPrice()){
                System.out.println("The amount payment is less then price");
                return false;
            }

            int change =  paymentAmount - packageBuyed.getPrice();
            customerBuying.setBalance(customerBuying.getBalance() - packageBuyed.getPrice());
            System.out.println("Your change: " + change);
            System.out.println("Your balance: " + customerBuying.getBalance());
            return true;

        }catch (Exception e){
            System.out.println("Input is invalid");
            return false;
        }
    }

    public boolean payment(GroupPackage packageBuyed, Customer customerBuying, int numberParticipant){
        try{
            System.out.println("Payment: " + packageBuyed.getPrice() + " x " + numberParticipant);
            System.out.println("Discount: " + packageBuyed.getGroupDiscount() + "%");
            int total = (packageBuyed.getPrice() * numberParticipant) * (100-packageBuyed.getGroupDiscount()) / 100;
            System.out.println("Total :" + total);
            System.out.print("Input the amount of payent: ");
            int paymentAmount = input.nextInt();
            input.nextLine();

            if (customerBuying.getBalance()-paymentAmount<0){
                System.out.println("Your balance is not enough");
                return false;
            }
            if (paymentAmount < 0){
                System.out.println("The amount payment is in the negative");
                return false;
            }else if (paymentAmount < total){
                System.out.println("The amount payment is less then price");
                return false;
            }

            int change =  paymentAmount - total;
            customerBuying.setBalance(customerBuying.getBalance() - total);
            System.out.println("Your change: " + change);
            System.out.println("Your balance: " + customerBuying.getBalance());
            return true;
        }catch (Exception e){
            System.out.println("Input is invalid");
            return false;
        }
    }

    public void topUp(){
        Customer customerLogin = loginCustomer();
        if (customerLogin == null){
            return;
        }
        customerLogin.topUpBalance();
    }
}