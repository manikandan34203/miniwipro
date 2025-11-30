import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CustomerDAO cdao = new CustomerDAO();
        DriverDAO ddao = new DriverDAO();
        RideDAO rdao = new RideDAO();

        while (true) {

            System.out.println("\n===== CAB BOOKING SYSTEM =====");
            System.out.println("1. Add Customer");
            System.out.println("2. Add Driver");
            System.out.println("3. Book a Ride");
            System.out.println("4. View All Customers");
            System.out.println("5. View All Drivers");
            System.out.println("6. View All Rides");
            System.out.println("7. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Customer ID: ");
                    int cid = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: ");
                    String cn = sc.nextLine();
                    System.out.print("Phone: ");
                    String cp = sc.nextLine();
                    System.out.print("Address: ");
                    String ca = sc.nextLine();
                    cdao.addCustomer(new Customer(cid, cn, cp, ca));
                    System.out.println("Customer Added.");
                    break;

                case 2:
                    System.out.print("Driver ID: ");
                    int did = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: ");
                    String dn = sc.nextLine();
                    System.out.print("Phone: ");
                    String dp = sc.nextLine();
                    System.out.print("License No: ");
                    String dl = sc.nextLine();
                    ddao.addDriver(new Driver(did, dn, dp, dl));
                    System.out.println("Driver Added.");
                    break;

                case 3:
                    System.out.print("Ride ID: ");
                    int rid = sc.nextInt(); sc.nextLine();
                    System.out.print("Customer ID: ");
                    int rcid = sc.nextInt(); sc.nextLine();
                    System.out.print("Driver ID: ");
                    int rdid = sc.nextInt(); sc.nextLine();
                    System.out.print("Pickup Location: ");
                    String pl = sc.nextLine();
                    System.out.print("Drop Location: ");
                    String dl2 = sc.nextLine();
                    System.out.print("Distance (km): ");
                    double dist = sc.nextDouble(); sc.nextLine();

                    double fare = FareCalculator.calculateFare(dist);
                    Date date = Date.valueOf(java.time.LocalDate.now());

                    Ride r = new Ride(rid, rcid, rdid, pl, dl2, dist, fare, date);
                    rdao.addRide(r);

                    System.out.println("Ride booked! Fare: ₹" + fare);
                    break;

                case 4:
                    List<Customer> customers = cdao.getAllCustomers();
                    customers.forEach(System.out::println);
                    break;

                case 5:
                    List<Driver> drivers = ddao.getAllDrivers();
                    drivers.forEach(System.out::println);
                    break;

                case 6:
                    List<Ride> rides = rdao.getAllRides();
                    rides.forEach(System.out::println);
                    break;

                case 7:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
