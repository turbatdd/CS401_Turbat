package lab4.probE;

public abstract class Account {
    public Account() {
    }

    abstract public String getAccountID();

    abstract public double getBalance();

    abstract public double computeUpdatedBalance();
}
