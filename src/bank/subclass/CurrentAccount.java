package bank.subclass;


import bank.Account;
import bank.interfaces.Penalty;
import bank.exceptions.NegativeAmountException;

public class CurrentAccount extends Account {

    private static long minimumBalance = 10_000;
    private Penalty penalty = Penalty.DEFAULT_PENALTY; // Penalty.fixed(100);

    public CurrentAccount(long acNo, String n, long openBal) throws NegativeAmountException {
        super(acNo, n, openBal);
    }
    public CurrentAccount(String n, long openBal) throws NegativeAmountException {
        super(n, openBal);
    }

    public void setPenalty(Penalty pa) {
        this.penalty = pa;
    }
    public Penalty getPenalty() {
        return this.penalty;
    }

    @Override
    public boolean withdraw(long amt) throws NegativeAmountException {
        if (!super.withdraw(amt)) {
            return false;
        }
        if (this.getBalance() < minimumBalance) {
            new Transaction("Penalty", TransType.DEBIT, this.getPenalty().compute(minimumBalance, this.getBalance()));
        }
        return true;
    }
}
