package StatePattern;

public class SelectOperationState implements ATMState {

    SelectOperationState(){
        System.out.println("your systenm is now idle to select operation");   
    }

    @Override
    public String getStateName(){
        return "SelectOperation";
    }

    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard() == null){
            return context.getStateFactory().createIdleState();
        }
        if(context.getCurrentAccount() == null){
            return context.getStateFactory().createHasCardState();
        }
        return context.getStateFactory().createTransactionState();
    }

    

}
