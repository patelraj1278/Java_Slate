package bank0623;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Bank {
    private String name;
    private long lastAccountNumber;

    private Map<Long,Account> accountMap = new TreeMap<>();

    public Bank(String name, int code){
        this.name = name;
        this.lastAccountNumber = code * 100L;
    }

    public enum AccountType {
        CHECKING {
            @Override
            public Account create(long acno, String n, long openBal) throws NegativeAmountException {
                return new CheckingAccount(acno, n, openBal);
            }
        },
        SAVINGS {
            @Override
            public Account create(long acno, String n, long openBal) throws NegativeAmountException {
                return new SavingsAccount(acno, n, openBal);
            }
        };
        public abstract Account create(long acno, String n, long openBal) throws NegativeAmountException;
    }

    public long openAccount(AccountType type, String n, long openBal) throws NegativeAmountException {
        Account ac = type.create(++lastAccountNumber, n, openBal);
        this.accountMap.put(ac.getAccountNumber(), ac);
        return ac.getAccountNumber();
    }
    private Account getAccount(long acno) throws NoSuchAccountException {
        Account ac = this.accountMap.get(acno);
        if (ac == null) {
            throw new NoSuchAccountException("invalid account number");
        }
        return ac;
    }
    public void deposit(long acno, long amt) throws NegativeAmountException, NoSuchAccountException {
        getAccount(acno).deposit(amt);
    }
    public boolean withdraw(long acno, long amt) throws NegativeAmountException, NoSuchAccountException {
        return getAccount(acno).withdraw(amt);
    }
    public void display(long acno) throws NoSuchAccountException {
        getAccount(acno).display();
    }
    public void printPassbook(long acno) throws NoSuchAccountException {
        getAccount(acno).printPassbook();
    }
    public Stream<Account> getAccountStream() {
        return this.accountMap.values().stream();
    }
    public void listAccounts() {
        System.out.println("List of Accounts for bank:"+this.name);
        getAccountStream().forEach(Account::display);
        System.out.println("End of account list");
    }

}
