public interface ExternalEnvironmentService {
    double getWeatherFactor(); // e.g., 1.0 = normal, 1.5 = heavy rain/snow
    double getOccupancyRate();  // e.g., 0.85 = 85% full
}