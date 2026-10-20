public class DynamicSurgePricingStrategy implements PricingStrategy {
    private static final double BASE_RATE = 500.0;
    private final ExternalEnvironmentService envService;

    public DynamicSurgePricingStrategy(ExternalEnvironmentService envService) {
        this.envService = envService;
    }

    @Override
    public double calculatePrice(int hours, String customerType) {
        double surgeMultiplier = 1.0;
        if (envService.getOccupancyRate() > 0.8) {
            surgeMultiplier += 0.5;
        }
        surgeMultiplier *= envService.getWeatherFactor();
        return hours * BASE_RATE * surgeMultiplier;
    }
}