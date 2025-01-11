import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        PackageManagement packageManagement = new PackageManagement();

        while (true) {
            try{
                System.out.println("==========================================");
                System.out.println("|               === Menu ===             |");
                System.out.println("==========================================");
                System.out.println("| 1. Add Package                        |");
                System.out.println("| 2. Add Customer                       |");
                System.out.println("| 3. Display Package                    |");
                System.out.println("| 4. Buy Package                        |");
                System.out.println("| 5. Display Customer                   |");
                System.out.println("| 6. Top Up Balance Customer            |");
                System.out.println("| 7. Exit                               |");
                System.out.println("==========================================");
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("------------------------------------------");
                        System.out.println("|        1. Individual Package          |");
                        System.out.println("|        2. Group Package               |");
                        System.out.println("------------------------------------------");
                        System.out.print("Enter package type: ");
                        int packageType = input.nextInt();
                        input.nextLine();
                        System.out.println("------------------------------------------");
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
                        packageManagement.topUp();
                        break;
                    case 7:
                        break;
                }
                if (choice == 7){
                    break;
                }
            }catch (Exception e){
                System.out.println("Invalid input");
            }
        }
        input.close(); 
    }
}