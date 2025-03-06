import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TripCalculatorTest {
    private TripCalculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new TripCalculator();
    }
    @Test
    public void testSetDistance(){
        calculator.setDistanceKm(20);
        assertEquals(20, calculator.getDistanceKm());

        calculator.setDistanceKm(-20);
        assertNotEquals(-20, calculator.getDistanceKm());
    }
    @Test
    public void testSetFuelPrice(){
        calculator.setFuelPricePerLiter(20);
        assertEquals(20, calculator.getFuelPricePerLiter());

        calculator.setFuelPricePerLiter(-20);
        assertNotEquals(-20, calculator.getFuelPricePerLiter());
    }
    @Test
    public void testCalculateTrip() {
        calculator.setDistanceKm(1000);
        calculator.setFuelPricePerLiter(20);
        assertEquals(1000,calculator.getPricePerTrip());
    }
}
