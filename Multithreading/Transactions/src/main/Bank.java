package main;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Bank {

    private ConcurrentMap<String, Account> accounts = new ConcurrentHashMap<>();
    private final Random random = new Random();



    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }



    public synchronized void transfer(String fromAccountNum, String toAccountNum, long amount)
            throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);

        if (fromAccount.isBlocked() || toAccount.isBlocked()) {
            return;
        }

        if (amount > 50_000 && isFraud(fromAccountNum, toAccountNum, amount)) {
                fromAccount.block();
                toAccount.block();
                return;
        }

        transaction(amount, fromAccount, toAccount);

    }


    public long getBalance(String accountNum) {
        Account account = accounts.get(accountNum);
        return account.getMoney();
    }


    public synchronized long getSumAllAccounts() {
        return accounts.values().stream().mapToLong(Account::getMoney).sum();
    }

    private synchronized void transaction(long money, Account fromAccount, Account toAccount) {
        try {
            fromAccount.takeMoney(money);
            toAccount.putMoney(money);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public void addAccountToBank(Account account) {
        accounts.put(account.getAccNumber(), account);
    }

}
