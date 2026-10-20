public class StandardPricingStrategy implements PricingStrategy {
    private static final double HOURLY_RATE = 500.0;

    @Override
    public double calculatePrice(int hours, String customerType) {
        return hours * HOURLY_RATE;
    }
}