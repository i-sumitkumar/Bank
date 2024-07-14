package api;

import exceptions.*;
import model.*;

import java.util.Map;

/**
 * An imaginary bank server API
 * Assume this interface is hosted on the Bank servers
 * Classes implementing this interface, will be able to connect to the Bank Database and retrieve/manipulate data
 */
public interface BankServerApi {

    // USER Services

    User getUserByIdAndPin(long id, int pin) throws LoginAttemptLimitException;

    Customer deposit(long accountNumber, double amount) throws UserNotFoundException;
    Customer withdraw(long accountNumber, double amount) throws InsufficientFundsException, UserNotFoundException;
    Customer transferTo(long sourceAccountNumber, long targetAccountNumber, double amount) throws InsufficientFundsException, UserNotFoundException;

    String getCustomerNameByAccountNumber(long accountNumber);


    // ATM Services

    void sendATMNotification(long atmId, NotificationType notificationType);

    void logATMStart(long atmId, ATM atm);

    void logATMDeposit(long atmId, long userId, Map<Integer, Integer> additionalCashInventory);

    void logATMWithdraw(long atmId, long userId, Map<Integer, Integer> removalCashInventory);
}
