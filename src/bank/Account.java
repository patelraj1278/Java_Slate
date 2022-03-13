package bank;

import bank.exceptions.NegativeAmountException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


//Constructor Overloading
//Instance variable/ Static variable , Method
//Method Overloading & Overriding
//Inheritance-Abstraction-Polymorphism-Encapsulation
//Abstract class/method
//Super Class-Sub Class
//Super & This
//Inner Class
//Enum
//Comparable & implement compareTo method
//Custom Exception
//Override equal & hashcode
//Java8:FunctionalInterface - Penalty
//Java8:Stream -> Stream<Transaction>
//Java8: doublecolumn usage to callout method - Transaction::getNetAmount
//Java8: mapToLong usage - getBalance
//Java8: Lambda anyMatch - hasPenalty
//Java8: Collections.unmodifiableList - getPassbook
//Java8: Arrays.sort & usage of Comparator comparing,comparingLong,thenComparingLong,reverseOrder,naturalOrder

//Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
// Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).
public abstract class Account implements Comparable<Account>{

    private static long lastAccountNumber = 1000;
    private long accountNumber;
    private String name;

    private List<Transaction> passbook = new ArrayList<>();

    public Account(long acNo,String n, long openBal) throws NegativeAmountException {
        this.accountNumber=acNo;
        this.name= n;
        new Transaction("Opening Balance",TransType.CREDIT,openBal);
    }

    public Account(String n, long openBal) throws NegativeAmountException{
        this(++lastAccountNumber, n, openBal);
    }


    //Inner Class
    public class Transaction {
        private long date = System.currentTimeMillis();
        private String naration;
        private TransType transType;
        private long amount;

        public Transaction(String name, TransType t, long amt) throws NegativeAmountException {
            if (amt < 0 ){
                throw new NegativeAmountException("negative amount", amt);
            }
            this.naration = name;
            this.transType = t;
            this.amount = amt;
            Account.this.passbook.add(this);
        }

        public long getDate() {
            return this.date;
        }
        public String getNaration() {
            return this.naration;
        }
        public TransType getTransType() {
            return this.transType;
        }
        public long getAmount() {
            return this.amount;
        }
        public long getNetAmount() {
            return this.transType.getSign()*this.getAmount();
        }
        @Override
        public String toString() {
            return "Transaction:"+String.format("%tF, %15s, %10s, %12d", this.date, this.naration, this.transType.toString(), this.amount);
        }
    }

    //Enum
    //Constants or Objects Define at the time when Enum created
    //By default, the Enum instance is thread-safe
    //INSTANCE is a public static final field that represents the enum instance
    //You can not create an instance of enums by using a new operator in Java because the constructor of Enum in Java can only be private and Enums constants can only be created inside Enums itself.
    public enum TransType{
        CREDIT(1),
        DEBIT(-1),
        ;
        private int sign;
        TransType(int sign){
            this.sign=sign;
        }
        public int getSign() {
            return this.sign;
        }
    }

    public long getAccountNumber() {
        return this.accountNumber;
    }
    public String getName() {
        return this.name;
    }

    public void deposit(long amt) throws NegativeAmountException {
        new Transaction("Deposit",TransType.CREDIT,amt);
    }

    public boolean withdraw(long amt) throws NegativeAmountException {
        if (amt > this.getBalance()) {
            return false;
        }
        new Transaction("Withdrawal", TransType.DEBIT, amt);
        return true;
    }

    public long getBalance() {
//      return this.balance;
        return getTransactionStream().mapToLong(Transaction::getNetAmount).sum();
    }

    public Stream<Transaction> getTransactionStream() {
        return this.passbook.stream();
    }

    public String toString() {
        String fullClassName = this.getClass().getName();
        String className = fullClassName.substring(fullClassName.lastIndexOf(".")+1);
        return className+":"+this.getAccountNumber()+", "+this.getName()+", "+this.getBalance();
    }
    public void display() {
        System.out.println(this);
    }

    public void printPassbook() {
        System.out.println("Passbook of "+this.getName());
        long runningBalance = 0;
        for (Transaction t : this.passbook) {

            System.out.printf("%tF\t%15s\t%12d\t%12d\t%12d\n"
                    ,t.getDate(), t.getNaration()
                    ,t.getTransType()==TransType.DEBIT?t.getAmount():0
                    ,t.getTransType()==TransType.CREDIT?t.getAmount():0
                    ,runningBalance=runningBalance+t.getNetAmount());
        }
        System.out.println("End of passbook");
    }

    @Override
    public int compareTo(Account ac){return ((Long)this.accountNumber).compareTo(ac.accountNumber);}

    public boolean equals(Object obj){
        if(obj == null) return false;
        if(obj == this) return true;
        if(!(obj instanceof Account)) return false;
        return this.accountNumber == ((Account)obj).accountNumber;
    }
    public int hashCode() {
        return ((Long)accountNumber).hashCode();
    }
}
