
public class GroupPackage extends TravelPackage {
    private int minNumber;
    private int groupDiscount;
    private String packageStatus = "Group";

    public GroupPackage(int pacakageId, String packageName, String location, int price, int days,
            String details, int minNumber, int groupDiscount) {
        super(pacakageId, packageName, location, price, days, details);
        this.minNumber = minNumber;
        this.groupDiscount = groupDiscount;
    }

    public String getPackageStatus() {
        return packageStatus;
    }

    @Override
    public void detailPackage(){
        System.out.println("--------------------------------------");
        System.out.println("Package Status: Group Package");
        System.out.println("Minimum Number of Participant: " + minNumber);
        super.detailPackage();
        System.out.println("Group Discount: " + groupDiscount + "%");
        System.out.println("--------------------------------------");
    }
}
