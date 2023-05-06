package bank0623;

public class CheckingAccount extends Account{

    private static long minimumBalance = 10000;

    private Penalty penalty = Penalty.DEFAULT_PENALTY; // Penalty.fixed(100);

    public CheckingAccount(long actNo, String name, long openBal) throws NegativeAmountException {
        super(actNo, name, openBal);
    }

    public CheckingAccount(String name, long openBal) throws NegativeAmountException {
        super(name, openBal);
    }

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    @Override
    public boolean withdraw(long amt) throws NegativeAmountException {
        if(!super.withdraw(amt)){
            return false;
        }

        if(this.getBalance() < minimumBalance){
            new Transaction("Penalty", TransType.DEBIT, this.getPenalty().compute(minimumBalance,this.getBalance()));
        }
       return true;
    }
}
