package service;

import apiclient.BankServerApiClient;
import model.ATM;
import model.NotificationType;

import java.util.Map;

public class ATMServiceImpl implements ATMService {

    private final BankServerApiClient bankServerApiClient;

    public ATMServiceImpl(BankServerApiClient bankServerApiClient) {
        this.bankServerApiClient = bankServerApiClient;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void logATMStart(long atmId, ATM atm) {
        bankServerApiClient.logATMStart(atmId, atm);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void sendNotification(long atmId, NotificationType notificationType) {
        bankServerApiClient.sendATMNotification(atmId, notificationType);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void logATMDeposit(long atmId, long userId, Map<Integer, Integer> additionalCashInventory) {
        bankServerApiClient.logATMDeposit(atmId, userId, additionalCashInventory);
    }

    /**
     * @inheritDoc
     */
    @Override
    public void logATMWithdraw(long atmId, long userId, Map<Integer, Integer> removalCashInventory) {
        bankServerApiClient.logATMWithdraw(atmId, userId, removalCashInventory);
    }
}
