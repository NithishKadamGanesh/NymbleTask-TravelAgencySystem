import static org.junit.Assert.*;
import org.junit.Test;


public class PremiumPassengerTest {

    @Test
    public void testHasSufficientBalance() {
        // Create a premium passenger
        PremiumPassenger premiumPassenger = new PremiumPassenger("Doe", 3);

        // Test has sufficient balance (premium passengers always have sufficient balance)
        assertTrue(premiumPassenger.hasSufficientBalance(50.0));
    }

    @Test
    public void testDeductBalance() {
        // Create a premium passenger
        PremiumPassenger premiumPassenger = new PremiumPassenger("Doe", 3);

        // Test deduct balance (premium passengers do not have balance)
        premiumPassenger.deductBalance(50.0); // Should not change balance
    }
}
