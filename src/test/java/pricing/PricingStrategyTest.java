package pricing;

import environment.ExternalEnvironmentService;
import environment.SimulatedEnvironmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PricingStrategyTest {

    private ExternalEnvironmentService fakeEnvService;

    @BeforeEach
    void setUp() {
        fakeEnvService = new SimulatedEnvironmentService(1.5, 0.85);
    }

    @Test
    void testStandardPricing() {
        PricingStrategy strategy = new StandardPricingStrategy();
        assertEquals(1500.0, strategy.calculatePrice(3, "REGULAR"));
    }

    @Test
    void testDynamicSurgePricing() {
        PricingStrategy strategy = new DynamicSurgePricingStrategy(fakeEnvService);
        assertEquals(3375.0, strategy.calculatePrice(3, "REGULAR"));
    }

    @Test
    void testSubscriberVIPPricing() {
        PricingStrategy strategy = new SubscriberVIPPricingStrategy();
        assertEquals(250.0, strategy.calculatePrice(3, "VIP"));
        assertEquals(0.0, strategy.calculatePrice(1, "VIP")); // До 2 часов бесплатно
    }

    @ParameterizedTest
    @MethodSource("provideStrategies")
    void testPriceIsNeverNegative(PricingStrategy strategy) {
        assertTrue(strategy.calculatePrice(2, "REGULAR") >= 0);
    }

    static Stream<PricingStrategy> provideStrategies() {
        ExternalEnvironmentService env = new SimulatedEnvironmentService(1.0, 0.5);
        return Stream.of(
                new StandardPricingStrategy(),
                new DynamicSurgePricingStrategy(env),
                new SubscriberVIPPricingStrategy()
        );
    }
}