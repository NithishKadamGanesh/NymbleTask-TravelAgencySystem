import static org.junit.Assert.*;
import org.junit.Test;


public class ActivityTest {

    @Test
    public void testEnrollPassenger() {
        // Create a destination
        Destination destination = new Destination("Test Destination");

        // Create an activity
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);

        // Create passengers
        StandardPassenger standardPassenger = new StandardPassenger("John", 1, 100.0);
        GoldPassenger goldPassenger = new GoldPassenger("Jane", 2, 100.0);
        PremiumPassenger premiumPassenger = new PremiumPassenger("Doe", 3);

        // Test enrolling passengers
        assertTrue(activity.enrollPassenger(standardPassenger));
        assertTrue(activity.enrollPassenger(goldPassenger));
        assertTrue(activity.enrollPassenger(premiumPassenger));
        assertFalse(activity.enrollPassenger(standardPassenger)); // Should fail, already enrolled
        assertFalse(activity.enrollPassenger(new StandardPassenger("Jack", 4, 0.0))); // Should fail, insufficient balance
        assertFalse(activity.enrollPassenger(new StandardPassenger("Jack", 4, 200.0))); // Should fail, capacity full
    }

    @Test
    public void testCancelEnrollment() {
        // Create a destination
        Destination destination = new Destination("Test Destination");

        // Create an activity
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);

        // Create a passenger
        StandardPassenger standardPassenger = new StandardPassenger("John", 1, 100.0);

        // Enroll passenger
        activity.enrollPassenger(standardPassenger);

        // Test canceling enrollment
        assertTrue(activity.cancelEnrollment(standardPassenger));
        assertFalse(activity.cancelEnrollment(standardPassenger)); // Should fail, already canceled
    }
}
