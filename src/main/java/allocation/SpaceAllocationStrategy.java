public interface SpaceAllocationStrategy {
    String allocateSpace(String vehicleType, int requestedZone);
}