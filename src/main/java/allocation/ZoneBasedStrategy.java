public class ZoneBasedStrategy implements SpaceAllocationStrategy {
    @Override
    public String allocateSpace(String vehicleType, int requestedZone) {
        return "Zone-" + requestedZone + "-Space-05";
    }
}