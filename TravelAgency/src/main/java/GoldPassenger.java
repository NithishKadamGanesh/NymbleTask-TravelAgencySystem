// GoldPassenger.java
public class GoldPassenger extends Passenger {

    private double balance;

    public GoldPassenger(String name, int passengerNumber, double balance) {
    	super(name, passengerNumber, PassengerType.GOLD);
        this.balance = balance;
    }

    @Override
    public boolean hasSufficientBalance(double activityCost) {
        return balance >= activityCost;
    }

    @Override
    public void deductBalance(double activityCost) {
        if (hasSufficientBalance(activityCost)) {
            double discountedCost = applyDiscount(activityCost);
            balance -= discountedCost;
        }
    }

    @Override
    public double applyDiscount(double activityCost) {
        return activityCost * 0.9; // 10% discount
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }
}
