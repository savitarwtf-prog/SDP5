public class RandomSpaceStrategy implements SpaceAllocationStrategy {
    @Override
    public String allocateSpace(String vehicleType, int requestedZone) {
        int randomSlot = (int) (Math.random() * 100) + 1;
        return "Random-Space-" + randomSlot;
    }
}