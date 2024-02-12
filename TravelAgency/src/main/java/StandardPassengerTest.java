import static org.junit.Assert.*;
import org.junit.Test;


public class StandardPassengerTest {

    @Test
    public void testHasSufficientBalance() {
        // Create a standard passenger
        StandardPassenger standardPassenger = new StandardPassenger("John", 1, 100.0);

        // Test has sufficient balance
        assertTrue(standardPassenger.hasSufficientBalance(50.0));
        assertFalse(standardPassenger.hasSufficientBalance(150.0));
    }

    @Test
    public void testDeductBalance() {
        // Create a standard passenger
        StandardPassenger standardPassenger = new StandardPassenger("John", 1, 100.0);

        // Test deduct balance
        standardPassenger.deductBalance(50.0);
        assertEquals(50.0, standardPassenger.getBalance(), 0.01);
    }
}
