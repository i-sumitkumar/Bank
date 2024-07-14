package service;

import exceptions.InsufficientFundsException;
import exceptions.LoginAttemptLimitException;
import exceptions.UserNotFoundException;
import model.Customer;
import model.User;

public interface UserService {

    /**
     * Finds the User (Customer or Employee) based on the provided id and pin
     *
     * @param id  user id
     * @param pin user password
     * @return if the provided data is verified, returns the Customer or Employee object, otherwise null.
     * @throws LoginAttemptLimitException if the user has 3 unsuccessful login attempts
     */
    User getUserByIdAndPin(long id, int pin) throws LoginAttemptLimitException;

    /**
     * Adds the provided amount to the provided account and returns the updated Customer object.
     *
     * @param accountNumber the money will be added to this account
     * @param amount        the amount of money that should be added to the account
     * @return the Customer object (with updated balance in their account)
     * @throws UserNotFoundException if the account number does not exist
     */
    Customer deposit(long accountNumber, double amount) throws UserNotFoundException;

    /**
     * Deducts the provided amount from the provided account and returns the updated Customer object.
     *
     * @param accountNumber money will be deducted from this account
     * @param amount        the amount of money that should be deducted from the account
     * @return the Customer object (with updated balance in their account)
     * @throws InsufficientFundsException if the account balance is less than the requested amount
     * @throws UserNotFoundException      if the account number does not exist
     */
    Customer withdraw(long accountNumber, double amount) throws InsufficientFundsException, UserNotFoundException;

    /**
     * This method can be used for:
     * A) transfer money between the accounts of the same customer
     * B) transfer money between different customers
     * The return value of this method, is always the source account holder
     *
     * @param sourceAccountNumber money to be deducted from this account
     * @param targetAccountNumber money to be added to this account
     * @param amount the amount of money to transfer
     * @return the customer who holds the source account (with updated balance in their account)
     * @throws InsufficientFundsException if the source account balance is less than the requested amount
     * @throws UserNotFoundException      if the source or target account numbers do not exist
     */
    Customer transferTo(long sourceAccountNumber, long targetAccountNumber, double amount) throws InsufficientFundsException, UserNotFoundException;

    /**
     * Returns the customer name, when provided with the account number
     * This can be used when a customer is transferring money to another customer.
     * Using the method they can see the name of the target account holder, as a confirmation.
     *
     * @param accountNumber the customer who owns this account number will be fetched
     * @return the customer name who owns the provided account number
     */
    String getCustomerNameByAccountNumber(long accountNumber);
}
