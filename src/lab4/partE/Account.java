package lab4.partE;

public abstract class Account {
    public Account() {
    }

    abstract public String getAccountID();

    abstract public double getBalance();

    abstract public double computeUpdatedBalance();
}
