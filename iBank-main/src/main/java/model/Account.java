package model;

import exceptions.InsufficientFundsException;

public class Account {
    private long accountNumber;
    private final AccountType accountType;
    private double balance;

    public Account(long accountNumber, AccountType accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
    }

    public void checkFunds(double amount) throws InsufficientFundsException {
        if (amount > balance) throw new InsufficientFundsException();
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        checkFunds(amount);
        balance -= amount;
    }

    public void reset() {
        this.accountNumber = 0;
        this.balance = 0;
    }

    // Getters & Setters

    public long getAccountNumber() {
        return accountNumber;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }
}