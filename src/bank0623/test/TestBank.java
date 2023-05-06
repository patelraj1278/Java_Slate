package bank0623.test;

import bank0623.Account;
import bank0623.Bank;
import bank0623.NegativeAmountException;
import bank0623.NoSuchAccountException;

import java.util.Comparator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class TestBank {
    public static void main(String [] args) throws NegativeAmountException, NoSuchAccountException {
        String bankName = args[0];
        int bankCode = Integer.parseInt(args[1]);
        Bank bank = new Bank(bankName,bankCode);
        long act1 = bank.openAccount(Bank.AccountType.CHECKING,"Raj",1000);
        long act2 = bank.openAccount(Bank.AccountType.SAVINGS,"Ami",2000);
        bank.deposit(act1,5000);
        bank.withdraw(act1,6000);
        bank.deposit(act2,1000);
        bank.withdraw(act2,4000);
        bank.listAccounts();
        bank.printPassbook(act1);
        bank.printPassbook(act2);

        bank.getAccountStream().filter(Account::hasPenalty).forEach(Account::display);
        LongSummaryStatistics balanceSummaryStatistics = bank.getAccountStream().collect(Collectors.summarizingLong(Account::getBalance));
        System.out.println("balanceSummaryStatistics =>"+balanceSummaryStatistics);

        Account maxTransactionAccount = bank.getAccountStream().max(Comparator.comparingInt(ac-> ac.getPassbook().size())).get();
        System.out.println("maxTransactionAccount =>"+maxTransactionAccount);

        long highestTransactionAmount  = bank.getAccountStream().flatMap(Account::getTransactionStream).max(Comparator.comparingLong(Account.Transaction::getTransactionAmount)).get().getTransactionAmount();
        System.out.println("highestTransactionAmount =>"+highestTransactionAmount);

        LongSummaryStatistics amountSummaryStatistics = bank.getAccountStream().flatMap(Account::getTransactionStream)
                .mapToLong(Account.Transaction::getTransactionAmount)
                .summaryStatistics();
        System.out.println("amountSummaryStatistics =>"+amountSummaryStatistics);

        Map<String, List<Account>> nameWiseAccountMap=  bank.getAccountStream().collect(Collectors.groupingBy(Account::getAccountName,Collectors.toList()));
        System.out.println("nameWiseAccountMap =>"+nameWiseAccountMap);

        Map<Boolean, List<Account>> penaltywiseAccounts = bank.getAccountStream().collect(Collectors.partitioningBy(Account::hasPenalty,Collectors.toList()));
        System.out.println("penaltywiseAccounts =>"+penaltywiseAccounts);

        Map<String, Long> namewiseBalances = bank.getAccountStream().collect(Collectors.groupingBy(Account::getAccountName,Collectors.summingLong(Account::getBalance)));
        System.out.println("namewise balance sum:"+ namewiseBalances);

        bank.getAccountStream().sorted(Comparator.comparingLong(Account::getAccountNumber)).forEach(x-> {
            System.out.println(x.getAccountName()+"->"+x.getTransactionStream().count());
        });

    }

}
