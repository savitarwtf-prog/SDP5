public class NearestSpaceStrategy implements SpaceAllocationStrategy {
    @Override
    public String allocateSpace(String vehicleType, int requestedZone) {
        return "Space-A1 (Nearest to exit)";
    }
}