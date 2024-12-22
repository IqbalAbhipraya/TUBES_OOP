public class TravelPackage {
    protected int pacakageId;
    protected String packageName;
    protected String location;
    protected int price;
    protected int days;
    protected String details;

    public TravelPackage(int pacakageId, String packageName, String location, int price, int days, String details) {
        this.pacakageId = pacakageId;
        this.packageName = packageName;
        this.location = location;
        this.price = price;
        this.days = days;
        this.details = details;
    }

    public int getPrice() {
        return price;
    }

    public String getPackageName() {
        return packageName;
    }

    public void detailPackage(){
        System.out.println("| Package ID: " + pacakageId);
        System.out.println("| Package Name: " + packageName);
        System.out.println("| Destination: " + location);
        System.out.println("| Duration: " + days + " days");
        System.out.println("| Price: " + price +" /person");
        System.out.println("| Detail: " + details);
    }
}