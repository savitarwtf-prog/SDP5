public interface PricingStrategy {
    double calculatePrice(int hours, String customerType);
}
