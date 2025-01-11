public abstract class TravelPackage {
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

    public int getPacakageId() {
        return pacakageId;
    }

    public void setPacakageId(int pacakageId) {
        this.pacakageId = pacakageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
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