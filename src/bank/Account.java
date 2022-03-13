package bank;

//Abstract class: is a restricted class that cannot be used to create objects (to access it, it must be inherited from another class).
// Abstract method: can only be used in an abstract class, and it does not have a body. The body is provided by the subclass (inherited from).
public abstract class Account {

    private static long lastAccountNumber = 1000;
    private long accountNumber;
    private String name;

    public Account(long acNo,String n, long openBal){
        this.accountNumber=acNo;
        this.name= n;
    }

    public Account(String n, long openBal){
        this(++lastAccountNumber, n, openBal);
    }


    //Inner Class
    public class Transaction {
        private long date = System.currentTimeMillis();
        private String naration;
        private TransType transType;
        private long amount;

    }

    //Enum
    //
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



}
