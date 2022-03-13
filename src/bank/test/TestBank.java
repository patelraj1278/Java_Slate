package bank.test;

import bank.Account;
import bank.Bank;
import bank.exceptions.NegativeAmountException;
import bank.exceptions.NoSuchAccountException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestBank {
    public static void main(String[] args) throws NegativeAmountException, NoSuchAccountException {
        String bankName = args[0];
        int bankCode = Integer.parseInt(args[1]);
        Bank bank = new Bank(bankName, bankCode);
        long acno1 = bank.openAccount(Bank.AccountType.CURRENT, "James", 1_00_000);
        long acno2 = bank.openAccount(Bank.AccountType.CURRENT, "Joshua", 1_00_000);
        long acno3 = bank.openAccount(Bank.AccountType.SAVINGS, "Jugal", 2_00_000);
        long acno4 = bank.openAccount(Bank.AccountType.CURRENT, "Jinal", 1_00_000);
        long acno5 = bank.openAccount(Bank.AccountType.SAVINGS, "Jeanne", 2_00_000);
        long acno6 = bank.openAccount(Bank.AccountType.CURRENT, "Nidhi", 1_00_000);
        long acno7 = bank.openAccount(Bank.AccountType.CURRENT, "Natalia", 3_00_000);
        long acno8 = bank.openAccount(Bank.AccountType.SAVINGS, "Namrata", 3_00_000);
        long acno9 = bank.openAccount(Bank.AccountType.CURRENT, "Tina", 11_00_000);
        long acno10 = bank.openAccount(Bank.AccountType.SAVINGS, "Tilly", 4_00_000);
        long acno11 = bank.openAccount(Bank.AccountType.SAVINGS, "Andrey", 10_00_000);
        long acno12 = bank.openAccount(Bank.AccountType.CURRENT, "Johanna", 4_00_000);
        long acno13 = bank.openAccount(Bank.AccountType.SAVINGS, "Cyna", 1_00_000);
        long acno14 = bank.openAccount(Bank.AccountType.SAVINGS, "Careena", 5_00_000);
        long acno15 = bank.openAccount(Bank.AccountType.SAVINGS, "Priyanka", 9_00_000);
        long acno16 = bank.openAccount(Bank.AccountType.SAVINGS, "Dipika", 5_00_000);
        long acno17 = bank.openAccount(Bank.AccountType.SAVINGS, "Salman", 7_00_000);
        long acno18 = bank.openAccount(Bank.AccountType.SAVINGS, "Salman", 8_00_000);

        bank.deposit(acno1, 11_000);
        bank.deposit(acno3, 1_000);
        bank.deposit(acno4, 8_000);
        bank.deposit(acno5, 25_000);
        bank.deposit(acno6, 95_000);
        bank.deposit(acno7, 2_99_000);
        bank.deposit(acno8, 100);
        bank.deposit(acno9, 10);


        bank.withdraw(acno10, 3_99_000);
        bank.withdraw(acno8, 2_99_000);
        bank.withdraw(acno7, 8_000);
        bank.withdraw(acno6, 25_000);
        bank.withdraw(acno5, 95_000);
        bank.withdraw(acno4, 99_000);
        bank.withdraw(acno3, 100);
        bank.withdraw(acno2, 95_000);

        bank.display(acno1);
        bank.deposit(acno1, 10_000);
        bank.display(acno1);
        bank.withdraw(acno1, 1_05_000);
        bank.printPassbook(acno1);

        //Java 8: Print display method of Account by Streaming Account Map
        bank.listAccounts();

        //Java 8: displaying all accounts which have a penalty transaction
        List<Account> accountList = bank.getAccountStream().filter(Account::hasPenalty).collect(Collectors.toList());
        accountList.stream().forEach(Account::getName);
    }
}
