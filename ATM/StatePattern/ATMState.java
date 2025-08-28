package StatePattern;
import ATM.ATMMachineContext;

public interface ATMState {
    String getStateName();
    ATMState next(ATMMachineContext context);
    
}
