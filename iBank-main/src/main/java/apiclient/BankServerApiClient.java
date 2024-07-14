package apiclient;

import exceptions.*;
import model.*;

import java.util.Map;

/**
 * Bank Server Api Client
 * Classes implementing this interface, will be able to connect to the bank servers and send/receive data
 */
public interface BankServerApiClient {

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
