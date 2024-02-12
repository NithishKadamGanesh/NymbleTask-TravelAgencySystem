// Acttivity.java
import java.util.ArrayList;
import java.util.List;

public class Activity {
    private String name;
    private String description;
    private double cost;
    private int capacity;
    private Destination destination;
    private List<Passenger> enrolledPassengers;

    public Activity(String name, String description, double cost, int capacity,Destination destination) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
        this.destination = destination;
        this.enrolledPassengers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }
    
    public Destination getDestination() {
        return destination;
    }

    /**
     * Enrolls a passenger for this activity if there is available space and handles
     * 
     * 
     * different passenger types.
     * 
     * @param passenger The passenger to enroll.
     * @return true if enrollment successful, false otherwise.
     */
    public boolean enrollPassenger(Passenger passenger) {
        if (hasAvailableSpace() && !enrolledPassengers.contains(passenger)) {
            if (passenger instanceof StandardPassenger) {
                if (((StandardPassenger) passenger).hasSufficientBalance(cost)) {
                    enrolledPassengers.add(passenger);
                    passenger.enrollActivity(this);
                    ((StandardPassenger) passenger).deductBalance(cost);
                    return true;
                } else {
                    System.out.println("Insufficient balance for standard passenger.");
                    return false;
                }
            } else if (passenger instanceof GoldPassenger) {
                double discountedCost = ((GoldPassenger) passenger).applyDiscount(cost);
                if (((GoldPassenger) passenger).hasSufficientBalance(discountedCost)) {
                    enrolledPassengers.add(passenger);
                    passenger.enrollActivity(this);
                    ((GoldPassenger) passenger).deductBalance(discountedCost);
                    return true;
                } else {
                    System.out.println("Insufficient balance for gold passenger.");
                    return false;
                }
            } else if (passenger instanceof PremiumPassenger) {
                enrolledPassengers.add(passenger);
                passenger.enrollActivity(this);
                return true;
            } else {
                System.out.println("Invalid passenger type.");
                return false;
            }
        } else {
            System.out.println("No available space for enrollment.");
            return false;
        }
    }

    /* 
     * 
     * Cancels enrollment of a passenger for this activity.
     * 
     * @param passenger The passenger to cancel enrollment for.
     * @return true if enrollment cancellation successful, false otherwise.
     */
    public boolean cancelEnrollment(Passenger passenger) {
    	passenger.cancelActivity(this);
        return enrolledPassengers.remove(passenger);
        
    }
 
     
    /**
     * Checks if there is available space for enrollment.
     * 
     * @return true if available space, false otherwise.
     */
    public boolean hasAvailableSpace() {
        return enrolledPassengers.size() < capacity;
    } 
     

    /**
     * Gets the list of passengers enrolled for this activity.
     * 
     * @return The list of enrolled passengers.
     */
    public List<Passenger> getEnrolledPassengers() {
        return new ArrayList<>(enrolledPassengers);
    }
}
