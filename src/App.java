import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        PackageManagement packageManagement = new PackageManagement();

        while (true) {
            System.out.println("=== Menu ===");
            System.out.println("1. Add Package\n2. Add Customer\n3. Display Package\n4. Buy Package\n5. Display Customer\n6. Exit");
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("---------------------");
                    System.out.println("1. Individual Package\n2. Group Package");
                    int packageType = input.nextInt();
                    input.nextLine();
                    System.out.println("---------------------");
                    if (packageType == 1){
                        packageManagement.addIndividualPackage();
                        
                    }else if (packageType == 2){
                        packageManagement.addGroupPackage();
                    }
                    break;
                case 2:
                    packageManagement.addCustomer();
                    break;
                case 3:
                    packageManagement.showPackage();
                    break;
                case 4:
                    packageManagement.buyPackage();
                    break;
                case 5:
                    packageManagement.showCustomer();
                    break;
                case 6:
                    break;
            }
            if (choice == 6){
                break;
            }
        }
    }
}
