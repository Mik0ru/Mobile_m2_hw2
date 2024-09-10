public class BankAccount {

    private double amount;

    public double getAmount() {
        return amount;
    }

    public void deposit(double sum) {
        this.amount += sum;
    }

    public void withdraw(double sum) throws LimitException {
        if (sum > amount) {
            throw new LimitException("Available credit exceeded. Credit left: " + amount, amount);
        } else {
            this.amount -= sum;
        }
    }

}
