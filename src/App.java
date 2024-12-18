import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        // ArrayList<TravelPackage> packageList = new ArrayList<TravelPackage>();
        PackageManagement packageManagement = new PackageManagement();

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Add Package\n2. Add Customer\n3. Display Package\n4. Buy Package\n5. Exit");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("1. Individual Package\n2. Group Package");
                    int packageType = input.nextInt();
                    if (packageType == 1){
                        packageManagement.addIndividualPackage();
                        
                    }else if (packageType == 2){
                        packageManagement.addGroupPackage();
                    }
                    break;
                case 2:
                    break;
                case 3:
                    packageManagement.showPackage();
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
            if (choice == 5){
                break;
            }
        }
    }
}
