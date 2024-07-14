package model;

public class Customer extends User {
    private final Account savings;
    private final Account checking;

    public Customer(int id, String name, int pin, Account savings, Account checking) {
        super(id, name, pin);
        this.savings = savings;
        this.checking = checking;
    }

    public Customer(Customer customer) {
        super(0, customer.getName(), 0);
        this.savings = new Account(customer.getSavings().getAccountNumber(), AccountType.SAVINGS, customer.getSavings().getBalance());
        this.checking = new Account(customer.getChecking().getAccountNumber(), AccountType.CHECKING, customer.getChecking().getBalance());
    }


    public Account getAccountByType(AccountType accountType) {
        return accountType == AccountType.SAVINGS ? savings : checking;
    }

    public void reset() {
        this.id = 0;
        this.name = "";
        this.pin = 0;
        this.savings.reset();
        this.checking.reset();
    }

    // Getters & Setters

    public void setName(String name) {
        this.name = name;
    }

    public Account getSavings() {
        return savings;
    }

    public Account getChecking() {
        return checking;
    }


    // Clone
    @Override
    public Customer clone() {
        return new Customer(this);
    }
}