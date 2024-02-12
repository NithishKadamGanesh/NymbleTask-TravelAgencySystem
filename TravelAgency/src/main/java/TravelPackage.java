
// TravelPackage.java
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a travel package with itinerary and passengers.
 */
public class TravelPackage {
    private String name;
    private int passengerCapacity;
    private List<Destination> itinerary;
    private List<Passenger> passengers;

    public TravelPackage(String name, int passengerCapacity) {
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        this.itinerary = new ArrayList<>();
        this.passengers = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public List<Destination> getItinerary() {
        return itinerary;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    /**
     * Adds a destination to the itinerary of the travel package.
     * 
     * @param destination The destination to add.
     */
    public void addDestination(Destination destination) {
        itinerary.add(destination);
    }

    /**
     * Removes a destination from the itinerary of the travel package.
     * 
     * @param destination The destination to remove.
     */
    public void removeDestination(Destination destination) {
        itinerary.remove(destination);
    }

    /**
     * Adds a passenger to the travel package.
     * 
     * @param passenger The passenger to add.
     * @return true if addition successful, false otherwise.
     */
    public boolean addPassenger(Passenger passenger) {
        if (passengers.size() < passengerCapacity) {
            passengers.add(passenger);
            return true;
        }
        return false;
    }

    /**
     * Removes a passenger from the travel package.
     * 
     * @param passenger The passenger to remove.
     */
    public boolean removePassenger(Passenger passenger) {
        return passengers.remove(passenger);
    }

    /**
     * Prints the itinerary details of the travel package.
     */
    public void printItinerary() {
        System.out.println("Travel Package: " + name);
        for (Passenger passenger : passengers) {
            System.out.println("Passenger: " + passenger.getName());
            System.out.println("Activities:");
            for (Activity activity : passenger.getEnrolledActivities()) {
                System.out.println(activity.getName() + " - " + activity.getDescription());
            }
            System.out.println();
        }
    }

    /**
     * Prints the passenger list of the travel package.
     */
    public void printPassengerList() {
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.println("Number of Passengers: " + passengers.size());
        System.out.println("Passengers:");
        for (Passenger passenger : passengers) {
            System.out.println(passenger.getName() + " - " + passenger.getPassengerNumber());
        }
    }


    /**
     * Prints the details of an individual passenger.
     * 
     * @param passenger The passenger whose details to print.
     */
    public void printPassengerDetails(Passenger passenger) {
        System.out.println("Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if (passenger instanceof StandardPassenger) {
            StandardPassenger standardPassenger = (StandardPassenger) passenger;
            System.out.println("Balance: " + standardPassenger.getBalance());
        } else if (passenger instanceof GoldPassenger) {
            GoldPassenger goldPassenger = (GoldPassenger) passenger;
            System.out.println("Balance: " + goldPassenger.getBalance());
        }
        System.out.println("Enrolled Activities:");
        for (Activity activity : passenger.getEnrolledActivities()) {
            System.out.println("- Destination: " + activity.getDestination().getName() + ", Activity: "
                    + activity.getName() + ", Cost: " + activity.getCost());
        }
    }

    /**
     * Prints details of activities that still have spaces available.
     */
    public void printAvailableActivities() {
        System.out.println("Available Activities:");
        for (Destination destination : itinerary) {
            for (Activity activity : destination.getActivities()) {
                if (activity.hasAvailableSpace()) {
                    System.out.println("Destination: " + destination.getName() + ", Activity: " + activity.getName()
                            + ", Capacity: " + (activity.getCapacity() - activity.getEnrolledPassengers().size()));
                }
            }
        }
    }
}
