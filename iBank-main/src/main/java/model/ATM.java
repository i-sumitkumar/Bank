package model;

import exceptions.ATMCashFullException;
import exceptions.InsufficientAtmCashException;

import java.util.Map;

public class ATM {
    private final long id;
    private final Map<Integer, Integer> cashInventory;
    private final int MAX_DENOMINATION_COUNT;
    private final int ALMOST_FULL_THRESHOLD;
    private final int ALMOST_EMPTY_THRESHOLD;

    public ATM(long id, Map<Integer, Integer> cashInventory, int MAX_DENOMINATION_COUNT, int ALMOST_FULL_THRESHOLD, int ALMOST_EMPTY_THRESHOLD) {
        this.id = id;
        this.cashInventory = cashInventory;
        this.MAX_DENOMINATION_COUNT = MAX_DENOMINATION_COUNT;
        this.ALMOST_FULL_THRESHOLD = ALMOST_FULL_THRESHOLD;
        this.ALMOST_EMPTY_THRESHOLD = ALMOST_EMPTY_THRESHOLD;
    }

    public void depositCash(Map<Integer, Integer> additionalCashInventory) throws ATMCashFullException {
        for (Map.Entry<Integer, Integer> entry : additionalCashInventory.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            int newCount = cashInventory.getOrDefault(denomination, 0) + count;
            if (newCount > MAX_DENOMINATION_COUNT) throw new ATMCashFullException();
            cashInventory.put(denomination, newCount);
        }
        checkCashInventoryWarning();
    }

    public void withdrawCash(Map<Integer, Integer> removalCashInventory) throws InsufficientAtmCashException {
        for (Map.Entry<Integer, Integer> entry : removalCashInventory.entrySet()) {
            int denomination = entry.getKey();
            int count = entry.getValue();
            int newCount = cashInventory.getOrDefault(denomination, 0) - count;
            if (newCount < 0) throw new InsufficientAtmCashException();
            cashInventory.put(denomination, newCount);
        }
    }

    public NotificationType checkCashInventoryWarning() {
        for (Map.Entry<Integer, Integer> CashInventoryEntry : cashInventory.entrySet()) {
            if (CashInventoryEntry.getValue() > ALMOST_FULL_THRESHOLD || CashInventoryEntry.getValue() < ALMOST_EMPTY_THRESHOLD)
                return NotificationType.INVENTORY_WARNING;
        }
        return null;
    }


    // Getters & Setters

    public Map<Integer, Integer> getCashInventory() {
        return cashInventory;
    }

    public long getId() {
        return id;
    }
}