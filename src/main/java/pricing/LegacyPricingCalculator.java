public class LegacyPricingCalculator {
    public double calculatePrice(String type, int hours, double occupancy) {
        if (type.equals("VIP")) {
            return hours <= 2 ? 0 : (hours - 2) * 250;
        } else if (occupancy > 0.8) {
            return hours * 500 * 1.5;
        } else {
            return hours * 500;
        }
    }
}