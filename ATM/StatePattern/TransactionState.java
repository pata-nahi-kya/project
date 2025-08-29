package StatePattern;

public class TransactionState implements ATMState{

    @Override
    public String getStateName() {
        return "TransactionState";
    }


    


    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() == null){
            return context.getStateFactory().createIdleState();
        }
        if(context.getCurrentAccount() == null){
            return context.getStateFactory().createHasCardState();
        }
        return context.getStateFactory().createSelectOperationState();
    }
}