package test;

import junit.framework.TestCase;
import main.Account;
import main.Bank;
import org.junit.Before;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class BankTest extends TestCase {

    private Bank bank;
    private ConcurrentMap<String, Account> accounts = new ConcurrentHashMap<>();
    private Account account1;
    private Account account2;
    private Account account3;
    private Account account4;
    private Account account5;

    @Override
    protected void setUp() {
        bank = new Bank();
        account1 = new Account("1", 50_000);
        account2 = new Account("2", 50_000);
        account3 = new Account("3", 50_000);
        account4 = new Account("4", 100_000);
        account5 = new Account("5", 100_000);

        accounts.put("1", account1);
        accounts.put("2", account2);
        accounts.put("3", account3);
        accounts.put("4", account4);
        accounts.put("5", account5);

        bank.addAccountToBank(account1);
        bank.addAccountToBank(account2);
        bank.addAccountToBank(account3);
        bank.addAccountToBank(account4);
        bank.addAccountToBank(account5);
    }

    @Before
    public void emptyBank() {
        bank = null;
    }


    public void testTransferLessThanLimit() throws InterruptedException {
        bank.transfer("1", "2", 5_000);
        long actualFrom = account1.getMoney();
        long expectedFrom = 45_000;
        long actualTo = account2.getMoney();
        long expectedTo = 55_000;

        assertEquals(expectedFrom, actualFrom);
        assertEquals(expectedTo, actualTo);
    }


    public void testAllSumMoneyAccounts() {
        long expected = account1.getMoney() + account2.getMoney() + account3.getMoney() +
                account4.getMoney() + account5.getMoney();
        long actual = bank.getSumAllAccounts();
        assertEquals(expected, actual);
    }


    public void testTransferMoreThanLimit() throws InterruptedException {
        bank.transfer(account4.getAccNumber(), account5.getAccNumber(), 60_000);
        long expectedAccOne;
        long expectedAccTwo;

        if (account4.isBlocked()) {
            expectedAccOne = 100_000;
            expectedAccTwo = 100_000;
        } else {
            expectedAccOne = 40_000;
            expectedAccTwo = 160_000;
        }

        long actualAccOne = bank.getBalance(account4.getAccNumber());
        long actualAccTwo = bank.getBalance(account5.getAccNumber());

        assertEquals(expectedAccOne, actualAccOne);
        assertEquals(expectedAccTwo, actualAccTwo);
    }


    public void testSumMoneyAfterTransfer() throws InterruptedException {
        bank.transfer(account1.getAccNumber(), account2.getAccNumber(), 10_000);

        long expectedSumMoneyAfterTransfer = 350_000;
        long actualSumMoneyAfterTransfer = bank.getSumAllAccounts();

        assertEquals(expectedSumMoneyAfterTransfer, actualSumMoneyAfterTransfer);
    }

}
