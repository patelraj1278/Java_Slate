
package bank.exceptions;

public class NegativeAmountException extends Exception {
    private long amount;
    public NegativeAmountException(String msg, long amt) {
        super(msg);
        this.amount = amt;
    }
    public long getAmount() {
        return this.amount;
    }
    public String toString() {
        return super.toString() + ":" + this.getAmount();
    }
}
