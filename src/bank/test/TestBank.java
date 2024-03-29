package bank.test;

import bank.Account;
import bank.Bank;
import bank.exceptions.NegativeAmountException;
import bank.exceptions.NoSuchAccountException;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
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

        //Test Accout Method from Bank class
        bank.display(acno1);
        bank.deposit(acno1, 10_000);
        bank.display(acno1);
        bank.withdraw(acno1, 1_05_000);
        bank.printPassbook(acno1);

        //Java 8: Print display method of Account by Streaming Account Map
        bank.listAccounts();

        //Java 8: displaying all accounts which have a penalty transaction
        System.out.println("displaying all accounts which have a penalty transaction");
        bank.getAccountStream().filter(Account::hasPenalty).forEach(Account::display);

        //Java 8: getList of Accounts with penalty
        List<Account> accountList = bank.getAccountStream().filter(Account::hasPenalty).collect(Collectors.toList());
        System.out.println("GetList of Accounts with penalty ="+accountList);

        //Java 8: Get the Account with the maximum number of transactions
        Account maxTransAccount = bank.getAccountStream().max(Comparator.comparingInt(ac -> ac.getPassbook().size())).get();
        System.out.println("Get the Account with the maximum number of transactions ="+maxTransAccount);

        //Java 8: Get the highest transaction amount
        long highestTransAmount =bank.getAccountStream().flatMap(Account::getTransactionStream).mapToLong(Account.Transaction::getAmount).max().getAsLong();
        System.out.println(highestTransAmount);


        //Java 8: Using Collectors.groupingBy :  get a map of namewise list of accounts
        Map<String, List<Account>> namewiseAccounts = bank.getAccountStream().collect(Collectors.groupingBy(Account::getName));
        System.out.println("namewise accounts:"+namewiseAccounts);

        //Java 8: Using Collectors.groupingBy :  get a partition of accounts with and without penalty
        Map<Boolean, List<Account>> penaltywiseAccounts = bank.getAccountStream()
                .collect(Collectors.partitioningBy(Account::hasPenalty));
        System.out.println("with and without penalty accounts:"+penaltywiseAccounts);

        //Java 8: Using Collectors.groupingBy :  get a map of namewise sum of balance
        Map<String, Long> namewiseBalances = bank.getAccountStream()
                .collect(Collectors.groupingBy(Account::getName,
                        Collectors.summingLong(Account::getBalance)));
        System.out.println("namewise balance sum:"+ namewiseBalances);

        //Java 8: Sort the list, on different criteria - Account GET NAME
        System.out.println("Sorting Based on Account's Name ::"+bank.getAccountStream().sorted(Comparator.comparing(Account::getName)).collect(Collectors.toList()));


        //Java 8: Get summary statistics for all the account balances  [NOTE : THIS WILL RETURN 38 COUNT AS 2 TRANSACTION GOT PENALTY]
        LongSummaryStatistics balanceStatistics = bank.getAccountStream()
                .collect(Collectors.summarizingLong(Account::getBalance));
        System.out.println(balanceStatistics);

        //Java 8: Get the summary statistics for the transaction amounts
        LongSummaryStatistics amountSummaryStatistics = bank.getAccountStream()
                .flatMap(Account::getTransactionStream)
                .mapToLong(Account.Transaction::getAmount)
                .summaryStatistics();
        System.out.println(amountSummaryStatistics);

        //Java 8: Get the summary statistics for the transaction net-amounts
        LongSummaryStatistics netAmountSummaryStatistics = bank.getAccountStream()
                .flatMap(Account::getTransactionStream)
                .mapToLong(Account.Transaction::getNetAmount)
                .summaryStatistics();
        System.out.println(netAmountSummaryStatistics);

        //Java 8: Create the Collector using the four components
        Collector<Account,?,List<Account>> accountListCollector = Collector.of(
                ArrayList<Account>::new,    // <supplier>
//                        (accountList, account) -> accountList.add(account), // accumulator
                ArrayList::add, // accumulator <BiConsumer>
                (list1, list2) -> {list1.addAll(list2); return list1;}, // combiner <BinaryOperator>
                Collections::unmodifiableList); // finisher <Function>
        List<Account> accountList1 = bank.getAccountStream().filter(Account::hasPenalty).collect(accountListCollector);
        System.out.println("unmodifiableList of Account which has hasPenalty =>"+accountList1);

    }
}
