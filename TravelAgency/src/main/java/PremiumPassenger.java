// PremiumPassenger.java
public class PremiumPassenger extends Passenger {

    public PremiumPassenger(String name, int passengerNumber) {
    	super(name, passengerNumber, PassengerType.PREMIUM); // Premium passengers have no balance
    }

    @Override
    public boolean hasSufficientBalance(double activityCost) {
        return true; // Premium passengers can sign up for activities for free
    }

    @Override
    public void deductBalance(double activityCost) {
        // No need to deduct balance for premium passengers
    }

    @Override
    public double applyDiscount(double activityCost) {
        // No discount for premium passengers
        return activityCost;
    }
}
