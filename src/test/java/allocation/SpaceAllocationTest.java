package allocation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpaceAllocationTest {

    @Test
    void testNearestSpaceStrategy() {
        SpaceAllocationStrategy strategy = new NearestSpaceStrategy();
        assertEquals("Space-A1 (Nearest to exit)", strategy.allocateSpace("CAR", 1));
    }

    @Test
    void testZoneBasedStrategy() {
        SpaceAllocationStrategy strategy = new ZoneBasedStrategy();
        assertEquals("Zone-2-Space-05", strategy.allocateSpace("ELECTRIC", 2));
    }

    @Test
    void testRandomSpaceStrategy() {
        SpaceAllocationStrategy strategy = new RandomSpaceStrategy();
        String result = strategy.allocateSpace("CAR", 1);
        assertNotNull(result);
        assertTrue(result.startsWith("Random-Space-"));
    }
}