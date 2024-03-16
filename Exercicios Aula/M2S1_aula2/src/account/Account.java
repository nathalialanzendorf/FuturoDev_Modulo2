package account;

public class Account {

    int agency;
    int number;
    double balance;

    public void deposit(double value) {
        balance = balance + value;
    }

    public void withdraw(double value) {
        balance = balance - value;
    }

    public void transfer(double value, Account destiny) {
        balance = balance - value;
        destiny.balance = destiny.balance + value;
    }
 }