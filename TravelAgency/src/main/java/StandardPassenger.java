// StandardPassenger.java
public class StandardPassenger extends Passenger {

    private double balance;

    public StandardPassenger(String name, int passengerNumber, double balance) {
    	super(name, passengerNumber, PassengerType.STANDARD);
        this.balance = balance;
    }

    @Override
    public boolean hasSufficientBalance(double activityCost) {
        return balance >= activityCost;
    }

    @Override
    public void deductBalance(double activityCost) {
        if (hasSufficientBalance(activityCost)) {
            balance -= activityCost;
        }
    }

    @Override
    public double applyDiscount(double activityCost) {
        // Standard passengers do not receive a discount
        return activityCost;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}
