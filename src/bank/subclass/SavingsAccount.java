package bank.subclass;

import bank.Account;
import bank.exceptions.NegativeAmountException;

public class SavingsAccount extends Account {

    public SavingsAccount(long acNo, String n, long openBal) throws NegativeAmountException {
        super(acNo, n, openBal);
    }
    public SavingsAccount(String n, long openBal) throws NegativeAmountException {
        super(n, openBal);
    }
}
