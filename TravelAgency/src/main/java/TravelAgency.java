
public class TravelAgency {
    public static void main(String[] args) {
        // Create destinations
        Destination paris = new Destination("Paris");
        Destination london = new Destination("London");

        // Create activities for destinations
        Activity eiffelTowerTour = new Activity("Eiffel Tower Tour", "Guided tour of the Eiffel Tower", 50.0, 20,
                paris);
        Activity louvreVisit = new Activity("Louvre Museum Visit", "Guided tour of the Louvre Museum", 40.0, 15, paris);
        Activity londonEyeTour = new Activity("London Eye Tour", "Observation wheel ride with stunning views of London",
                60.0, 25, london);
        Activity britishMuseumVisit = new Activity("British Museum Visit", "Guided tour of the British Museum", 35.0,
                20, london);

        // Add activities to destinations
        paris.addActivity(eiffelTowerTour);
        paris.addActivity(louvreVisit);
        london.addActivity(londonEyeTour);
        london.addActivity(britishMuseumVisit);

        // Create a travel package
        TravelPackage europeTour = new TravelPackage("Europe Tour", 50);

        // Add destinations to the travel package itinerary
        europeTour.addDestination(paris);
        europeTour.addDestination(london);

        // Create passengers
        Passenger standardPassenger = new StandardPassenger("John Doe", 1, 200.0);
        Passenger goldPassenger = new GoldPassenger("Jane Smith", 2, 300.0);
        Passenger premiumPassenger = new PremiumPassenger("Alice Johnson", 3);

        // Add passengers to the travel package
        europeTour.addPassenger(standardPassenger);
        europeTour.addPassenger(goldPassenger);
        europeTour.addPassenger(premiumPassenger);

        // Enroll passengers for activities
        eiffelTowerTour.enrollPassenger(standardPassenger);
        louvreVisit.enrollPassenger(standardPassenger);
        londonEyeTour.enrollPassenger(goldPassenger);
        britishMuseumVisit.enrollPassenger(premiumPassenger);

        // Print itinerary details
        europeTour.printItinerary();

        // Print passenger list
        europeTour.printPassengerList();

        // Print details of individual passengers
        europeTour.printPassengerDetails(standardPassenger);
        europeTour.printPassengerDetails(goldPassenger);
        europeTour.printPassengerDetails(premiumPassenger);

        // Print details of available activities
        europeTour.printAvailableActivities();
    }
}
