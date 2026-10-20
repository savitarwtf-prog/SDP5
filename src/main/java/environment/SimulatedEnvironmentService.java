public class SimulatedEnvironmentService implements ExternalEnvironmentService {
    private final double weatherFactor;
    private final double occupancyRate;

    public SimulatedEnvironmentService(double weatherFactor, double occupancyRate) {
        this.weatherFactor = weatherFactor;
        this.occupancyRate = occupancyRate;
    }

    @Override
    public double getWeatherFactor() {
        return weatherFactor;
    }

    @Override
    public double getOccupancyRate() {
        return occupancyRate;
    }
}