public class SpaceAllocationContext {
    private SpaceAllocationStrategy strategy;

    public SpaceAllocationContext(SpaceAllocationStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SpaceAllocationStrategy strategy) {
        this.strategy = strategy;
    }

    public String executeAllocation(String vehicleType, int requestedZone) {
        return strategy.allocateSpace(vehicleType, requestedZone);
    }
}