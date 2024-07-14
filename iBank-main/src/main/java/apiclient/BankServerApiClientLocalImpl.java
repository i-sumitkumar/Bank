package apiclient;

import api.BankServerApi;
import exceptions.*;
import model.*;

import java.util.Map;

/**
 * A fake API client
 * Instead of actually calling the actual bank servers, it will return the demo data defined in this class
 */
public class BankServerApiClientLocalImpl implements BankServerApiClient {

    private final BankServerApi localBankServerApi;

    public BankServerApiClientLocalImpl(BankServerApi localBankServerApi) {
        this.localBankServerApi = localBankServerApi;
    }

    @Override
    public User getUserByIdAndPin(long id, int pin) throws LoginAttemptLimitException {
        return localBankServerApi.getUserByIdAndPin(id, pin);
    }

    @Override
    public Customer deposit(long accountNumber, double amount) throws UserNotFoundException {
        return localBankServerApi.deposit(accountNumber, amount);
    }

    @Override
    public Customer withdraw(long accountNumber, double amount) throws InsufficientFundsException, UserNotFoundException {
        return localBankServerApi.withdraw(accountNumber, amount);
    }

    @Override
    public Customer transferTo(long sourceAccountNumber, long targetAccountNumber, double amount) throws InsufficientFundsException, UserNotFoundException {
        return localBankServerApi.transferTo(sourceAccountNumber, targetAccountNumber, amount);
    }

    @Override
    public String getCustomerNameByAccountNumber(long accountNumber) {
        return localBankServerApi.getCustomerNameByAccountNumber(accountNumber);
    }

    @Override
    public void sendATMNotification(long atmId, NotificationType notificationType) {
        localBankServerApi.sendATMNotification(atmId, notificationType);
    }

    @Override
    public void logATMStart(long atmId, ATM atm) {
        localBankServerApi.logATMStart(atmId, atm);
    }

    @Override
    public void logATMDeposit(long atmId, long userId, Map<Integer, Integer> additionalCashInventory) {
        localBankServerApi.logATMDeposit(atmId, userId, additionalCashInventory);
    }

    @Override
    public void logATMWithdraw(long atmId, long userId, Map<Integer, Integer> removalCashInventory) {
        localBankServerApi.logATMWithdraw(atmId, userId, removalCashInventory);
    }
}
