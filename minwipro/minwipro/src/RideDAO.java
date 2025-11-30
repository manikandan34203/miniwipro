import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RideDAO {

    public boolean addRide(Ride r) {
        String sql = "INSERT INTO cab_ride_log VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, r.rideId);
            ps.setInt(2, r.customerId);
            ps.setInt(3, r.driverId);
            ps.setString(4, r.pickup);
            ps.setString(5, r.drop);
            ps.setDouble(6, r.distance);
            ps.setDouble(7, r.fare);
            ps.setDate(8, r.rideDate);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Add ride failed: " + e.getMessage());
            return false;
        }
    }

    public List<Ride> getAllRides() {
        List<Ride> list = new ArrayList<>();

        String sql = "SELECT * FROM cab_ride_log";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Ride(
                        rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5),
                        rs.getDouble(6), rs.getDouble(7),
                        rs.getDate(8)
                ));
            }

        } catch (SQLException e) {
            System.out.println("Fetch rides failed: " + e.getMessage());
        }

        return list;
    }
}
