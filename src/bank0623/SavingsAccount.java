package bank0623;

public class SavingsAccount extends Account{
    public SavingsAccount(long actNo, String name, long openBal) throws NegativeAmountException {
        super(actNo, name, openBal);
    }

    public SavingsAccount(String name, long openBal) throws NegativeAmountException {
        super(name, openBal);
    }
}
