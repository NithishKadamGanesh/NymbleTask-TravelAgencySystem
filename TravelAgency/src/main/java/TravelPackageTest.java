import static org.junit.Assert.*;
import org.junit.Test;


public class TravelPackageTest {

    @Test
    public void testAddDestination() {
        // Create a travel package
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);

        // Create a destination
        Destination destination = new Destination("Test Destination");

        // Test adding destination to travel package
        travelPackage.addDestination(destination);
        assertEquals(1, travelPackage.getItinerary().size());
    }

    @Test
    public void testRemoveDestination() {
        // Create a travel package
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);

        // Create a destination
        Destination destination = new Destination("Test Destination");

        // Add destination to travel package
        travelPackage.addDestination(destination);

        // Test removing destination from travel package
        travelPackage.removeDestination(destination);
        assertEquals(0, travelPackage.getItinerary().size());
    }

    @Test
    public void testAddPassenger() {
        // Create a travel package
        TravelPackage travelPackage = new TravelPackage("Test Package", 2);

        // Create passengers
        StandardPassenger standardPassenger = new StandardPassenger("John", 1, 100.0);
        GoldPassenger goldPassenger = new GoldPassenger("Jane", 2, 100.0);

        // Test adding passengers to travel package
        assertTrue(travelPackage.addPassenger(standardPassenger));
        assertTrue(travelPackage.addPassenger(goldPassenger));
        assertFalse(travelPackage.addPassenger(new PremiumPassenger("Doe", 3))); // Should fail, capacity full
    }

    @Test
    public void testRemovePassenger() {
        // Create a travel package
        TravelPackage travelPackage = new TravelPackage("Test Package", 10);

        // Create a passenger
        StandardPassenger standardPassenger = new StandardPassenger("John", 1, 100.0);

        // Add passenger to travel package
        travelPackage.addPassenger(standardPassenger);

        // Test removing passenger from travel package
        assertTrue(travelPackage.removePassenger(standardPassenger));
        assertFalse(travelPackage.removePassenger(standardPassenger)); // Should fail, already removed
    }
}
