package bank0623;

public class NegativeAmountException extends  Exception{

    private long amount;
    NegativeAmountException(String msg, long amt){
        super(msg);
        this.amount=amt;
    }

    public long getAmount(){
        return this.amount;
    }

    @Override
    public String toString() {
        return "NegatveAmountException{" +
                "amount=" + amount +
                '}';
    }
}
