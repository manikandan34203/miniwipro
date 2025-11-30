import java.sql.Date;

public class Ride {
    private int rideId;
    private int customerId;
    private int driverId;
    private String pickup;
    private String drop;
    private double distance;
    private double fare;
    private Date rideDate;

    public Ride(int rideId, int customerId, int driverId, String pickup, String drop,
                double distance, double fare, Date rideDate) {
        this.rideId = rideId;
        this.customerId = customerId;
        this.driverId = driverId;
        this.pickup = pickup;
        this.drop = drop;
        this.distance = distance;
        this.fare = fare;
        this.rideDate = rideDate;
    }

    @Override
    public String toString() {
        return "Ride ID: " + rideId +
                " | Customer: " + customerId +
                " | Driver: " + driverId +
                " | From: " + pickup +
                " | To: " + drop +
                " | Distance: " + distance +
                " km | Fare: ₹" + fare +
                " | Date: " + rideDate;
    }
}
