public class SubscriberVIPPricingStrategy implements PricingStrategy {
    private static final double VIP_RATE = 250.0;

    @Override
    public double calculatePrice(int hours, String customerType) {
        if (hours <= 2) {
            return 0.0; // Первые 2 часа бесплатно для VIP
        }
        return (hours - 2) * VIP_RATE;
    }
}