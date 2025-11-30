import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriverDAO {

    public boolean addDriver(Driver d) {
        String sql = "INSERT INTO cab_driver VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, d.getDriverId());
            ps.setString(2, d.getName());
            ps.setString(3, d.getPhone());
            ps.setString(4, d.getLicense());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Add driver failed: " + e.getMessage());
            return false;
        }
    }

    public List<Driver> getAllDrivers() {
        List<Driver> list = new ArrayList<>();

        String sql = "SELECT * FROM cab_driver";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Driver(
                        rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)
                ));
            }

        } catch (SQLException e) {
            System.out.println("Fetch drivers failed: " + e.getMessage());
        }
        return list;
    }
}
