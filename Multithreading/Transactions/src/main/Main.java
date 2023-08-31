package main;


public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        Account firstAccount = new Account("1", 50000);
        Account secondAccount = new Account("2", 50000);
        Account thirdAccount = new Account("3", 50000);

        bank.addAccountToBank(firstAccount);
        bank.addAccountToBank(secondAccount);
        bank.addAccountToBank(thirdAccount);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    bank.transfer("1", "2", 1000);
                    bank.transfer("1", "3", 1000);
                    bank.transfer("2", "1", 1000);
                    bank.transfer("2", "3", 1000);
                    bank.transfer("3", "1", 1000);
                    bank.transfer("3", "2", 1000);
                    bank.transfer("1", "3", 1000);
                    bank.transfer("2", "3", 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();


        }

        System.out.println(firstAccount);
        System.out.println(secondAccount);
        System.out.println(thirdAccount);
    }
}
