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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void topUp(int newBalance) {
        balance = balance + newBalance;
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

    public void buyPackage(String packageName) {
        packageBuyed.add(packageName);
    }
}