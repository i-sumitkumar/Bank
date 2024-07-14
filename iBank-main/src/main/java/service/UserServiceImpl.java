package service;

import apiclient.BankServerApiClient;
import exceptions.InsufficientFundsException;
import exceptions.LoginAttemptLimitException;
import exceptions.UserNotFoundException;
import model.Customer;
import model.User;

public class UserServiceImpl implements UserService {

    private final BankServerApiClient bankServerApiClient;

    public UserServiceImpl(BankServerApiClient bankServerApiClient) {
        this.bankServerApiClient = bankServerApiClient;
    }

    /**
     * @inheritDoc
     */
    @Override
    public User getUserByIdAndPin(long id, int pin) throws LoginAttemptLimitException {
        return bankServerApiClient.getUserByIdAndPin(id, pin);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Customer deposit(long accountNumber, double amount) throws UserNotFoundException {
        return bankServerApiClient.deposit(accountNumber, amount);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Customer withdraw(long accountNumber, double amount) throws InsufficientFundsException, UserNotFoundException {
        return bankServerApiClient.withdraw(accountNumber, amount);
    }

    /**
     * @inheritDoc
     */
    @Override
    public Customer transferTo(long sourceAccountNumber, long targetAccountNumber, double amount) throws InsufficientFundsException, UserNotFoundException {
        return bankServerApiClient.transferTo(sourceAccountNumber, targetAccountNumber, amount);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String getCustomerNameByAccountNumber(long accountNumber) {
        return bankServerApiClient.getCustomerNameByAccountNumber(accountNumber);
    }
}
