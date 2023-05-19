package bank0623;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class Account {

    private static long lastAccountNumber = 1000;
    private long accountNumber;
    private String accountName;

    private List<Transaction> passbook = new ArrayList<>();

    public Account(long actNo, String name, long openBal) throws NegativeAmountException {
        this.accountNumber= actNo;
        this.accountName= name;
        new Transaction("Opening Balance", TransType.CREDIT, openBal);
    }

    public Account(String name, long openBal) throws NegativeAmountException {
        this(++lastAccountNumber,name,openBal);
    }

    public class Transaction {
        private long date = System.currentTimeMillis();
        private String narration;  //Opening Bal or Deposit or Withdraw or Penalty
        private TransType transType;
        private long transactionAmount;

        public Transaction(String narration, TransType transType, long transactionAmount) throws NegativeAmountException {
            if(transactionAmount < 0){
                throw new NegativeAmountException("Negative Amount", transactionAmount);
            }
            this.narration= narration;
            this.transType = transType;
            this.transactionAmount = transactionAmount;

                    Account.this.passbook.add(this);
        }

        public long getDate() {
            return date;
        }

        public String getNarration() {
            return narration;
        }

        public TransType getTransType() {
            return transType;
        }

        public long getTransactionAmount() {
            return transactionAmount;
        }

        public long getNetAmount(){
            return this.transType.getSign() * this.getTransactionAmount();
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "date=" + date +
                    ", narration='" + narration + '\'' +
                    ", transType=" + this.transType.toString() +
                    ", transactionAmount=" + transactionAmount +
                    '}';
        }
    }

    public enum TransType {
        CREDIT(1),
        DEBIT(-1);

        private int sign;
        private TransType(int sign){
            this.sign= sign;
        }

        public int getSign() {
            return sign;
        }
    }

    public static long getLastAccountNumber() {
        return lastAccountNumber;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public List<Transaction> getPassbook() {
        return passbook;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", accountName='" + accountName + '\'' +
                ", passbook=" + passbook +
                '}';
    }

    public void deposit(long amt) throws NegativeAmountException {
        new Transaction("Deposit",TransType.CREDIT,amt);
    }

    public boolean withdraw(long amt) throws NegativeAmountException {
        if(amt > this.getBalance()){
            System.out.println("Withdra Amount is Greater than Balance...");
            return false;
        }
        new Transaction("Withdraw",TransType.DEBIT,amt);
        return true;
    }

    public void display(){
        System.out.println(this);
    }

    public boolean hasPenalty(){
            return getTransactionStream().anyMatch(x->x.getNarration().equalsIgnoreCase("penalty"));
    }

    public long getBalance(){
        return getTransactionStream().mapToLong(Transaction::getNetAmount).sum();
    }

    public Stream<Transaction> getTransactionStream(){
        return this.passbook.stream();
    }

    public void printPassbook() {
        System.out.println("Passbook of " + this.getAccountName());
        long runningBalance = 0;
        System.out.println("Final Amount ::"+getTransactionStream().mapToLong(Transaction::getNetAmount).sum());
        for (Transaction t : this.passbook) {
            runningBalance+= t.getNetAmount();
            System.out.printf("%tF\t%15s\t%12d\t%12d\t%12d\n"
                    , t.getDate(), t.getNarration()
                    , t.getTransType() == TransType.DEBIT ? t.getTransactionAmount() : 0
                    , t.getTransType() == TransType.CREDIT ? t.getTransactionAmount() : 0
                    , runningBalance);
            System.out.println("End of passbook");

        }
    }
}
