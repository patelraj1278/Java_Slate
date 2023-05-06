package bank0623.test;

import bank0623.Account;
import bank0623.CheckingAccount;
import bank0623.NegativeAmountException;
import bank0623.SavingsAccount;

import java.util.Arrays;
import java.util.Comparator;

public class TestAccount {

    private static void display(Account[] accounts) {
        Arrays.stream(accounts).forEach(Account::display);
    }
    public static void main(String [] args ) throws NegativeAmountException {
        Account ca = new CheckingAccount("Raj",10000);
        ca.deposit(5500);
        ca.withdraw(2000);

        Account sa = new SavingsAccount("Ami",5000);
        sa.deposit(3000);
        sa.withdraw(1000);
        ca.display();
        ca.printPassbook();
        Account[] ac = new Account[]{ca,sa};
        Arrays.sort(ac , Comparator.comparing(Account::getAccountNumber).thenComparing(Account::getBalance));
        display(ac);
    }
}
