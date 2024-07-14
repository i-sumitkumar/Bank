package service;

import model.ATM;
import model.NotificationType;

import java.util.Map;

public interface ATMService {

    /**
     * Sends a notification, informing the bank server that the ATM is low on cash or has too much cash in its inventory
     *
     * @param atmId            the identification number of the ATM
     * @param notificationType either INVENTORY_ALMOST_EMPTY or INVENTORY_ALMOST_FULL
     */
    void sendNotification(long atmId, NotificationType notificationType);

    /**
     * Informs the bank server that the ATM app is started up
     *
     * @param atmId id of the current atm
     * @param atm   object with info such as atm cash inventory
     */
    void logATMStart(long atmId, ATM atm);

    /**
     * Informs the bank server that cash is deposited in this ATM
     *
     * @param atmId                   id of the current ATM
     * @param userId                  the id of the user who deposited the money (Customer / Employee)
     * @param additionalCashInventory the number of bills added for each denomination
     */
    void logATMDeposit(long atmId, long userId, Map<Integer, Integer> additionalCashInventory);

    /**
     * Informs the bank server that cash is withdrawn from this ATM
     *
     * @param atmId                id of the current ATM
     * @param userId               the id of the user who withdrew the money (Customer / Employee)
     * @param removalCashInventory the number of bills removed for each denomination
     */
    void logATMWithdraw(long atmId, long userId, Map<Integer, Integer> removalCashInventory);
}
