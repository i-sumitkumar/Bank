package api;

import exceptions.*;
import model.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A fake/demo API implementation
 * Assume this class is hosted on the Bank servers
 * Instead of actually calling the bank servers, it will return the demo data defined in this class
 */
public class BankServerApiDemoImpl implements BankServerApi {

    @Override
    public User getUserByIdAndPin(long id, int pin) throws LoginAttemptLimitException {
        int loginAttempts = userLoginAttempts.getOrDefault(id, 0);
        if (loginAttempts == MAX_LOGIN_ATTEMPTS_ALLOWED) throw new LoginAttemptLimitException();

        // check if user is a customer
        Customer customer = customers.get(id);
        if (customer != null) {
            if (customer.verifyPin(pin)) {
                userLoginAttempts.put(id, 0);
                return customer.clone();
            } else {
                userLoginAttempts.put(id, loginAttempts + 1);
                return null;
            }
        }

        // check if user is an employee
        Employee employee = employees.get(id);
        if (employee != null) {
            if (employee.verifyPin(pin)) {
                userLoginAttempts.put(id, 0);
                return employee.clone();
            } else {
                userLoginAttempts.put(id, loginAttempts + 1);
                return null;
            }
        }

        // user doesn't exist
        return null;
    }

    @Override
    public Customer deposit(long accountNumber, double amount) throws UserNotFoundException {
        Account acc = accountsMap.get(accountNumber);
        if (acc == null) throw new UserNotFoundException("A customer with this account number does not exist.");
        acc.deposit(amount);
        return accountToCustomer.get(accountNumber).clone();
    }

    @Override
    public Customer withdraw(long accountNumber, double amount) throws InsufficientFundsException, UserNotFoundException {
        Account acc = accountsMap.get(accountNumber);
        if (acc == null) throw new UserNotFoundException("A customer with this account number does not exist.");
        acc.withdraw(amount);
        return accountToCustomer.get(accountNumber).clone();
    }

    @Override
    public Customer transferTo(long sourceAccountNumber, long targetAccountNumber, double amount) throws InsufficientFundsException, UserNotFoundException {
        Customer sourceAccountCustomer = withdraw(sourceAccountNumber, amount);
        Customer targetAccountCustomer = deposit(targetAccountNumber, amount);
        return (sourceAccountCustomer.getName().equals(targetAccountCustomer.getName()))
                ? targetAccountCustomer
                : sourceAccountCustomer;
    }

    @Override
    public void sendATMNotification(long atmId, NotificationType notificationType) {
        System.out.printf(">>> Notification %s received from ATM ID: %d", notificationType, atmId);
    }

    @Override
    public void logATMStart(long atmId, ATM atm) {
        // Bank server will store all records to DB.
        System.out.printf("Start ATM: %d\n", atmId);
    }

    @Override
    public void logATMDeposit(long atmId, long userId, Map<Integer, Integer> additionalCashInventory) {
        // Bank server will store all records to DB.
        System.out.printf("depositCashTo ATM: %d by User: %d\n%s", atmId, userId, displayCashInventory(additionalCashInventory));
    }

    @Override
    public void logATMWithdraw(long atmId, long userId, Map<Integer, Integer> removalCashInventory) {
        // Bank server will store all records to DB.
        System.out.printf("withdrawCashFrom ATM: %d by User: %d\n%s", atmId, userId, displayCashInventory(removalCashInventory));
    }

    @Override
    public String getCustomerNameByAccountNumber(long accountNumber) {
        return accountToCustomer.get(accountNumber).getName();
    }

    private String displayCashInventory(Map<Integer, Integer> cashInventory) {
        StringBuilder sb = new StringBuilder();
        List<Integer> denominations = cashInventory.keySet().stream().sorted().collect(Collectors.toList());
        for (int denomination : denominations) {
            sb.append(String.format("%d: %d\n", denomination, cashInventory.get(denomination)));
        }
        return sb.toString();
    }


    // FAKE (DEMO) DATA:

    private final Map<Long, Customer> customers = new HashMap<>();
    private final Map<Long, Employee> employees = new HashMap<>();
    private final Map<Long, Account> accountsMap = new HashMap<>();
    private final Map<Long, Customer> accountToCustomer = new HashMap<>();
    private final Map<Long, Integer> userLoginAttempts = new HashMap<>();
    private final int MAX_LOGIN_ATTEMPTS_ALLOWED = 3;

    public BankServerApiDemoImpl() {
        setupDemoData();
    }

    private void setupDemoData() {
        Account customer1Checking = new Account(10001, AccountType.CHECKING, 500);
        Account customer1Savings = new Account(10002, AccountType.SAVINGS, 1000);
        Account customer2Checking = new Account(20001, AccountType.CHECKING, 5000);
        Account customer2Savings = new Account(20002, AccountType.SAVINGS, 10000);
        accountsMap.put(customer1Checking.getAccountNumber(), customer1Checking);
        accountsMap.put(customer1Savings.getAccountNumber(), customer1Savings);
        accountsMap.put(customer2Checking.getAccountNumber(), customer2Checking);
        accountsMap.put(customer2Savings.getAccountNumber(), customer2Savings);

        Customer customer1 = new Customer(1, "Alice", 1234, customer1Checking, customer1Savings);
        Customer customer2 = new Customer(2, "Bob", 1234, customer2Checking, customer2Savings);
        customers.put(customer1.getId(), customer1);
        customers.put(customer2.getId(), customer2);

        accountToCustomer.put(customer1Checking.getAccountNumber(), customer1);
        accountToCustomer.put(customer1Savings.getAccountNumber(), customer1);
        accountToCustomer.put(customer2Checking.getAccountNumber(), customer2);
        accountToCustomer.put(customer2Savings.getAccountNumber(), customer2);

        Employee employee1 = new Employee(100, "John", 5678);
        Employee employee2 = new Employee(200, "Jane", 5678);
        employees.put(employee1.getId(), employee1);
        employees.put(employee2.getId(), employee2);
    }
}
