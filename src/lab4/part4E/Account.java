package lab4.part4E;

public abstract class Account {
    public Account() {
    }

    abstract public String getAccountID();

    abstract public double getBalance();

    abstract public double computeUpdatedBalance();
}
