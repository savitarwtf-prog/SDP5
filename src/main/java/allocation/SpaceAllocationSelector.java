public class SpaceAllocationSelector {
    public SpaceAllocationStrategy selectStrategy(String vehicleType, boolean isPeakHour) {
        if ("ELECTRIC".equalsIgnoreCase(vehicleType) || "TRUCK".equalsIgnoreCase(vehicleType)) {
            return new ZoneBasedStrategy();
        } else if (isPeakHour) {
            return new NearestSpaceStrategy();
        } else {
            return new RandomSpaceStrategy();
        }
    }
}