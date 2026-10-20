public class PricingSelector {
    private final ExternalEnvironmentService envService;

    public PricingSelector(ExternalEnvironmentService envService) {
        this.envService = envService;
    }

    public PricingStrategy selectStrategy(String customerType, int hourOfDay) {
        if ("VIP".equalsIgnoreCase(customerType)) {
            return new SubscriberVIPPricingStrategy();
        } else if (envService.getOccupancyRate() > 0.8 || envService.getWeatherFactor() > 1.2 || hourOfDay >= 17 && hourOfDay <= 19) {
            return new DynamicSurgePricingStrategy(envService);
        } else {
            return new StandardPricingStrategy();
        }
    }
}