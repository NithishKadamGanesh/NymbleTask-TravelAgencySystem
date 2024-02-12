
// Passenger.java
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a passenger who can sign up for activities.
 */
public abstract class Passenger {
	private String name;
    private int passengerNumber;
    private PassengerType type;
    private List<Activity> enrolledActivities;

    public Passenger(String name, int passengerNumber, PassengerType type) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.type = type;
        this.enrolledActivities = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public PassengerType getType() {
        return type;
    }
    
    public List<Activity> getEnrolledActivities() {
        return enrolledActivities;
    }

    /**
     * Adds an activity to the list of enrolled activities for the passenger.
     * 
     * @param activity The activity to enroll.
     */
    public void enrollActivity(Activity activity) {
        enrolledActivities.add(activity);
    }

    /**
     * Removes an activity from the list of enrolled activities for the passenger.
     * 
     * @param activity The activity to remove.
     */
    public void cancelActivity(Activity activity) {
        enrolledActivities.remove(activity);
    }

    /**
     * Checks if the passenger has sufficient balance to sign up for an activity.
     * 
     * @param activityCost The cost of the activity.
     * @return true if balance is sufficient, false otherwise.
     */
    public abstract boolean hasSufficientBalance(double activityCost);

    /**
     * Deducts the activity cost from the passenger's balance.
     * 
     * @param activityCost The cost of the activity.
     */
    public abstract void deductBalance(double activityCost);

    /**
     * Applies a discount on the activity cost for a gold passenger.
     * 
     * @param activityCost The cost of the activity.
     * @return The discounted cost.
     */
    public abstract double applyDiscount(double activityCost);

}
