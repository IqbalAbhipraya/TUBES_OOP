import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;  
    private String nationality;
    private int balance;
    private List<String> packageBuyed = new ArrayList<String>();

    public Customer(int id, String name, String nationality, int balance) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void customerDetail() {
        System.out.println("ID: " + id + " | Name: " + name + " | Nationality: " + nationality + " | Balance: " + balance);

        if (packageBuyed.size() != 0){
            System.out.println("Package Bought: ");
            for (String packageName : packageBuyed){
                System.out.println("- " + packageName);
            }
        }

        System.out.println("--------------------------------------");
    }

    public void buyPackage(String packageName) {
        packageBuyed.add(packageName);
    }
}
