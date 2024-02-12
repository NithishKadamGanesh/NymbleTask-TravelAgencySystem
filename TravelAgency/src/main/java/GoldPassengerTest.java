import static org.junit.Assert.*;
import org.junit.Test;


public class GoldPassengerTest {

    @Test
    public void testHasSufficientBalance() {
        // Create a gold passenger
        GoldPassenger goldPassenger = new GoldPassenger("Jane", 2, 100.0);

        // Test has sufficient balance
        assertTrue(goldPassenger.hasSufficientBalance(50.0));
        assertFalse(goldPassenger.hasSufficientBalance(150.0));
    }

    @Test
    public void testDeductBalance() {
        // Create a gold passenger
        GoldPassenger goldPassenger = new GoldPassenger("Jane", 2, 100.0);

        // Test deduct balance
        goldPassenger.deductBalance(50.0);
        assertEquals(95.0, goldPassenger.getBalance(), 0.01);
    }
}
