package main;

public class Account {

    private long money;
    private String accNumber;
    private boolean isBlocked = false;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setIsBlocked(boolean isBlocked) {
        this.isBlocked = isBlocked;
    }

    public synchronized void block() {
        isBlocked = true;
    }

    public synchronized void putMoney(long moneyToPut) {
        money += moneyToPut;
    }

    public synchronized void takeMoney(long moneyToTake) throws InterruptedException {
        if (moneyToTake > money) {
            wait();
        }
        money -= moneyToTake;
        notify();
    }

    @Override
    public String toString() {
        return "Номер аккаунта: " + getAccNumber() + ". Остаток на счёте: " + getMoney() + " руб.";
    }


}
