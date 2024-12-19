import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String name;
    private int id;
    private String nationality;
    private int age;
    private List<String> packageBuyed = new ArrayList<String>();

    public Customer(int id, String name, String nationality, int age) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void customerDetail() {
        System.out.println("--------------------------------------");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Nationaly: " + nationality);
        System.out.println("Age: " + age);
        
        if (packageBuyed.size() != 0){
            System.out.println();
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
