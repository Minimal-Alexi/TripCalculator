import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripCalculatorTest {
    private TripCalculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new TripCalculator();
    }
    @Test
    public void testCalculateTrip() {
        calculator.setDistanceKm(1000);
        calculator.setFuelPricePerLiter(20);
        assertEquals(1000,calculator.getPricePerTrip());
    }
}
