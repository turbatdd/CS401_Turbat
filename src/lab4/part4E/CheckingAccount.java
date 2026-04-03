package lab4.part4E;

public class CheckingAccount extends Account {
    private String acctId;
    private double monthlyFee;
    private double balance;

    public CheckingAccount(String accountId, double monthlyFee, double startBalance) {
        this.acctId = accountId;
        this.monthlyFee = monthlyFee;
        this.balance = startBalance;
    }

    @Override
    public String getAccountID() {
        return acctId;
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double computeUpdatedBalance() {
        return balance - monthlyFee;
    }
}


