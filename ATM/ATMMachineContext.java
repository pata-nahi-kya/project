
import java.util.*;
import CoreClass.*;
import StatePattern.*;

public class ATMMachineContext {
    ATMState currentState;
    Card currentCard;
    Account currentAccount;
    ATMInventory atmInventory;
    Map<String, Account> accounts;
    ATMStateFactory stateFactory;
    TranscationType selectedOperation;

    public ATMMachineContext() {
        this.stateFactory = ATMStateFactory.getInstance();
        this.currentState = stateFactory.createIdleState();
        this.atmInventory = new ATMInventory();
        this.accounts = new HashMap<>();
        System.out.println("ATM initalized in:" + currentState.getStateName() + " state");
    }

    public void advanceState() {
        ATMState nextState = currentState.next(this);
        System.out.println("ATM transitioned to: " + nextState.getStateName() + " state");
        this.currentState = nextState;
    }

    public void insertCard(Card card) {
        if (currentState instanceof IdleState) {
            System.out.println("card inserted");
            setCurrentCard(card);
            advanceState();
        } else {
            System.out.println("Cannot insert card in current state: " + currentState.getStateName());
        }
    }

    public void enterPin(int pin) {
        if (currentState instanceof HasCardState) {
            if (currentCard != null && currentCard.validatePin(pin)) {
                System.out.println("PIN validated successfully");
                currentAccount = accounts.get(currentCard.getCardNumber());
                advanceState();
            } else {
                System.out.println("Invalid PIN. Please try again.");
            }
        } else {
            System.out.println("Cannot enter PIN in current state: " + currentState.getStateName());

        }
    }

    public void selectOperation(TranscationType transactionType) {
        if (currentState instanceof SelectOperationState) {
            System.out.println("Selected operation: " + transactionType);
            this.selectedOperation = transactionType;
            advanceState();
        } else {
            System.out.println(
                    "Cannot select operation in " + currentState.getStateName());
        }
    }

    // Perform the selected transaction
    public void performTransaction(double amount) {
    if (currentState instanceof TransactionState) {
    try {
    if (selectedOperation == TransactionType.WITHDRAW_CASH) {
    performWithdrawal(amount);
    } else if (selectedOperation == TransactionType.CHECK_BALANCE) {
    checkBalance();
    }
    // Ask if user wants another transaction
    advanceState();
    } catch (Exception e) {
    System.out.println("Transaction failed: " + e.getMessage());
    // Go back to select operation state
    currentState = stateFactory.createSelectOperationState();
    }
    } else {
    System.out.println(
    "Cannot perform transaction in " + currentState.getStateName());
    }
    }

    // Return card to user
    public void returnCard() {
        if (currentState instanceof HasCardState
                || currentState instanceof SelectOperationState
                || currentState instanceof TransactionState) {
            System.out.println("Card returned to customer");
            resetATM();
        } else {
            System.out.println("No card to return in " + currentState.getStateName());
        }
    }

    // Cancel current transaction
    public void cancelTransaction() {
        if (currentState instanceof TransactionState) {
            System.out.println("Transaction cancelled");
            returnCard();
        } else {
            System.out.println(
                    "No transaction to cancel in " + currentState.getStateName());
        }
    }

    // Helper method to perform withdrawal
    private void performWithdrawal(double amount) throws Exception {
        // Check if user has sufficient balance
        if (!currentAccount.withdraw(amount)) {
            throw new Exception("Insufficient funds in account");
        }
        // Check if ATM has sufficient cash
        if (!atmInventory.hasSufficientCash((int) amount)) {
            // Rollback the account withdrawal
            currentAccount.deposit(amount);
            throw new Exception("Insufficient cash in ATM");
        }
        Map<CashType, Integer> dispensedCash = atmInventory.dispenseCash((int) amount);
        if (dispensedCash == null) {
            // Rollback the account withdrawal
            currentAccount.deposit(amount);
            throw new Exception("Unable to dispense exact amount");
        }
        System.out.println("Transaction successful. Please collect your cash:");
        for (Map.Entry<CashType, Integer> entry : dispensedCash.entrySet()) {
            System.out.println(entry.getValue() + " x $" + entry.getKey().value);
        }
    }

    // Helper method to check balance

    

    private void checkBalance() {
        System.out.println(
                "Your current balance is: $" + currentAccount.getBalance());
    }

    private void resetATM() {
        this.currentCard = null;
        this.currentAccount = null;
        this.selectedOperation = null;
        this.currentState = stateFactory.createIdleState();
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public void setCurrentState(ATMState state) {
        this.currentState = state;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public ATMStateFactory getStateFactory() {
        return stateFactory;
    }

    public void setCurrentCard(Card card) {
        this.currentCard = card;
    }

    public void setCurrentAccount(Account account) {
        this.currentAccount = account;
    }

    public TranscationType getSelectionOperation() {
        return selectedOperation;
    }

    public void setSelectedOperation(TranscationType selectedOperation) {
        this.selectedOperation = selectedOperation;
    }

    public ATMInventory getAtmInventory() {
        return atmInventory;
    }

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}
