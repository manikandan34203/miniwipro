public class Driver {
    private int driverId;
    private String name;
    private String phone;
    private String license;

    public Driver(int driverId, String name, String phone, String license) {
        this.driverId = driverId;
        this.name = name;
        this.phone = phone;
        this.license = license;
    }

    public int getDriverId() { return driverId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getLicense() { return license; }

    @Override
    public String toString() {
        return "Driver ID: " + driverId +
                " | Name: " + name +
                " | Phone: " + phone +
                " | License: " + license;
    }
}
