import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Customer {
    private int id;
    private String name;  
    private String nationality;
    private int balance;
    private List<String> packageBuyed = new ArrayList<String>();

    Scanner input = new Scanner(System.in);

    public Customer(int id, String name, String nationality, int balance) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.balance = balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void customerDetail() {
        System.out.println("--------------------------------------");
        System.out.println("| ID: " + id);
        System.out.println("| Name: " + name);
        System.out.println("| Nationaly: " + nationality);
        System.out.println("| Balance: " + balance);
        System.out.println("--------------------------------------");
       
        if (packageBuyed.size() != 0){
            System.out.println("|         Package Bought:            |");
            System.out.println("======================================");
            for (String packageName : packageBuyed){
                System.out.println("| - " + packageName);
            }
            System.out.println("======================================");
        }
    }

    public void topUpBalance(){
        try{
            
            System.out.println("How many you want to Top-Up: ");
            int topUpBalance = input.nextInt();
            input.nextLine();

            balance = balance + topUpBalance;
            System.out.println("Your new Balance is: " + balance);   
        }catch (Exception e){
            System.out.println("Invalid input");
        }
    }

    public void buyPackage(TravelPackage packageChoosen, Customer customerObj) {
        try{
            PackageManagement packageManagement = new PackageManagement();

            if (packageChoosen instanceof IndividualPackage){
                IndividualPackage packaged = (IndividualPackage) packageChoosen;
                if (packageManagement.payment(packaged, customerObj)){
                    packageBuyed.add(packageChoosen.packageName);
                }else{
                    return;
                }
    
            }else if (packageChoosen instanceof GroupPackage){
                GroupPackage packaged = (GroupPackage) packageChoosen;
                System.out.println("How many will go with you: ");
                int numParticipant = input.nextInt() + 1;
                input.nextLine();
    
                if (numParticipant < packaged.getMinNumber()){
                    System.out.println("Error, Number of participant is less than the minimum required");
                    return;
                }
                
                if (packageManagement.payment(packaged, customerObj, numParticipant)){
                    packageBuyed.add(packageChoosen.packageName);
                }else{
                    return;
                }
    
            }        
            System.out.println("Successfully buy a Package");
        }catch (Exception e){
            System.out.println("Data Invalid");
        }
    }

    public void inputCustomerData(){
        try{
            System.out.println("======================================");
            System.out.print("| Name: ");
            this.name = input.nextLine();
    
            System.out.print("| Nationality: ");
            this.nationality = input.nextLine();
    
            System.out.print("| Balance: ");
            this.balance = input.nextInt();
            input.nextLine();
            System.out.println("======================================");
        }catch (Exception e){
            System.out.println("The Input is Invalid, please enter valid input!!");
        }
    }
}