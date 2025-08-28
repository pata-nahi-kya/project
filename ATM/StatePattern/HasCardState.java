package StatePattern;

public class HasCardState implements ATMState {
    public HasCardState(){
        System.out.println("ATM is in Has card state - please enter your pin");
    }
    @Override
    public String getStateName(){
        return "HasCard";
    }
    @Override
    public ATMState next(ATMMachineContext context) {
        if(context.getCurrentCard == null){
            return context.getStateFactory().createIdleState();

        }
        if(context.getCurrentAccount() != null){
            return context.getStateFactory().createSelectOperationState();
        }
        return this;
    }

    



    
}
