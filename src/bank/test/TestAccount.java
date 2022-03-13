package bank.test;

import bank.Account;
import bank.subclass.CurrentAccount;
import bank.subclass.SavingsAccount;
import bank.exceptions.NegativeAmountException;
import bank.interfaces.Penalty;

import java.util.Arrays;
import java.util.Comparator;

public class TestAccount {
    public static void main(String[] args) throws NegativeAmountException {

        //Basic Testing
        /*Account ac = new Account("JPMC",100000);
        ac.deposit(200);
        ac.withdraw(50);
        ac.display();
        ac.printPassbook();*/

        //Basic Testing of Sub Class CurrentAccount Transaction
        //CurrentAccount ca = new CurrentAccount("JPMC", 10001);
        //System.out.println("before penalty");
        //ca.display();
        //ca.printPassbook();

        //Testing Account with Penalty Functional Interface
        CurrentAccount ca = new CurrentAccount("JPMC", 10001);
        System.out.println("Before penalty");
        ca.display();
        //ca.setPenalty(Penalty.ZERO_PENALTY);
        ca.setPenalty(Penalty.fixed(300));
        ca.withdraw(9000);
        System.out.println("After penalty");
        ca.display();
        ca.printPassbook();


        //Testing Account with Java 8 Sorting
        Account[] accounts = new Account[5];
        try {
            accounts[0] = new SavingsAccount(12321, "John", 1_00_000);
            accounts[1] = new CurrentAccount(23123, "jane", 1_00_000);
            accounts[2] = new CurrentAccount(12312, "John", 50_000);
            accounts[3] = new SavingsAccount(33411, "Joseph", 1_50_000);
            accounts[4] = new CurrentAccount(23344, "Janet", 75_000);
            System.out.println("before sorting");
            display(accounts);
        } catch (NegativeAmountException nae) {
            nae.printStackTrace();
        }

        //Java8 :Sort By Name :Create a comparator to order by name, then sort and display
        Arrays.sort(accounts, Comparator.comparing(Account::getName));
        System.out.println("after sorting by name");
        display(accounts);

        //Java8 :Sort By Balance :Create a comparator to order by balances, then sort and display
        Arrays.sort(accounts, Comparator.comparingLong(Account::getBalance));
        System.out.println("after sorting by balance");
        display(accounts);

        // Java8 :Sort By Natural Order :create a comparator to order by the natural ordering of Account, ie. according to Comparable<Account>
        Arrays.sort(accounts, Comparator.naturalOrder());
        System.out.println("after sorting by natural order");
        display(accounts);

        // Java8 :Sort By Reverse Order :create a comparator to order by the reverse ordering of Account, ie. according to Comparable<Account>
        Arrays.sort(accounts, Comparator.reverseOrder());
        System.out.println("after sorting by reverse order");
        display(accounts);

        // Java8 :Order by name ignoring the case : create a comparator to order by name ignoring the case, then display
        Arrays.sort(accounts, Comparator.comparing(Account::getName,String.CASE_INSENSITIVE_ORDER));
        System.out.println("after sorting by name case insensitive");
        display(accounts);

        // Java8 : sort the array by name and then on balances.
//        Arrays.sort(accounts, Comparator.comparing(Account::getName).thenComparing(Comparator.comparingLong(Account::getBalance)));
        Arrays.sort(accounts, Comparator.comparing(Account::getName).thenComparingLong(Account::getBalance));
        System.out.println("after sorting by name then on balance");
        display(accounts);

        // Java8 : create a Comparator by Account type. then sort them by balance and display
        Arrays.sort(accounts, Comparator.comparing(Account::getClass,Comparator.comparing(Class::getName))
                .thenComparingLong(Account::getBalance));
        System.out.println("after sorting by type then on balance");
        display(accounts);

        // Java8 : create a Comparator by Account type. then sort them by balance and display & then reverse them
        Arrays.sort(accounts, Comparator.comparing(Account::getClass,Comparator.comparing(Class::getName))
                .thenComparingLong(Account::getBalance).reversed());
        System.out.println("after sorting by type then on balance & reverse them");
        display(accounts);

    }
    private static void display(Account[] accounts) {
                /*
                        for (Account ac : accounts) {
                            ac.display();
                        }
                */
        Arrays.stream(accounts).forEach(Account::display);
    }

}
