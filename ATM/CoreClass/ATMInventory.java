package CoreClass;

import java.util.Map;

public class ATMInventory {
    private Map<CashType, Integer> cashInventory;

    public ATMInventory() {
        cashInventory = new Map<>(CashType.class);
        for (CashType type : CashType.values()) {
            cashInventory.put(type, 0);
        }
    }

    public boolean hasSufficientCash(int amount) {
        return getTotalCash() >= amount;
    }
    
    public Map<CashType, Integer> dispenseCash(int amount) {
        if(!hasSufficientCash(amount)){
            return null;
        }
        Map<CashType, Integer> dispensed = new Map<>(CashType.class);
        int remainingAmount = amount;

        for (CashType type : CashType.values()) {
            int count = Math.min(remainingAmount / type.getValue(), cashInventory.get(type));
            if (count > 0) {
                dispensed.put(type, count);
                remainingAmount -= count * type.getValue();
            }
        }

        if (remainingAmount == 0) {
            for (CashType type : dispensed.keySet()) {
                removeCash(type, dispensed.get(type));
            }
            return dispensed;
        } else {
            return null;
        }
    }

    public void initializeInventory() {
        cashInventory.put(CashType.HUNDRED, 10);
        cashInventory.put(CashType.FIFTY, 10);
        cashInventory.put(CashType.TWENTY, 20);
        cashInventory.put(CashType.TEN, 30);
        cashInventory.put(CashType.FIVE, 20);
    }

    public void addCash(CashType type, int count) {
        
        cashInventory.put(type, cashInventory.get(type) + count);
    }

    public boolean removeCash(CashType type, int count) {
        int currentCount = cashInventory.get(type);
        if (currentCount >= count) {
            cashInventory.put(type, currentCount - count);
            return true;
        }
        return false;
    }

    public int getCashCount(CashType type) {
        return cashInventory.get(type);
    }

    public double getTotalCash() {
        double total = 0;
        for (CashType type : CashType.values()) {
            total += type.getValue() * cashInventory.get(type);
        }
        return total;
    }
}
