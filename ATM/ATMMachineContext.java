
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
    public ATMMachineContext(){
        this.stateFactory = stateFactory.getInstance();
        this.currentState = stateFactory.createIdleState();
        this.atmInventory = new ATMInventory();
        this.accounts = new HashMap<>();
        System.out.println("ATM initalized in:" + currentState.getStateName() + " state");
    }

    public void advanceState() {
        ATMState nexttState = currentState.next(this);
        System.out.println("ATM transitioned to: " + currentState.getStateName() + " state");
    }



    
}
