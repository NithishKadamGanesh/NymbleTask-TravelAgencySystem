import static org.junit.Assert.*;
import org.junit.Test;


public class DestinationTest {

    @Test
    public void testAddActivity() {
        // Create a destination
        Destination destination = new Destination("Test Destination");

        // Create an activity
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);

        // Test adding activity to destination
        destination.addActivity(activity);
        assertEquals(1, destination.getActivities().size());
    }

    @Test
    public void testRemoveActivity() {
        // Create a destination
        Destination destination = new Destination("Test Destination");

        // Create an activity
        Activity activity = new Activity("Test Activity", "Test Description", 50.0, 10, destination);

        // Add activity to destination
        destination.addActivity(activity);

        // Test removing activity from destination
        destination.removeActivity(activity);
        assertEquals(0, destination.getActivities().size());
    }
}
