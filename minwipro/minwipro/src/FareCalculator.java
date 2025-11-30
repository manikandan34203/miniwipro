public class FareCalculator {

    public static double calculateFare(double distance) {
        double baseFare = 50;

        if (distance <= 10) {
            return baseFare + distance * 12;
        } else {
            return baseFare + (10 * 12) + ((distance - 10) * 10);
        }
    }
}
