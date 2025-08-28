package StatePattern;

public class IdleState implements ATMState {
    public IdleState(){
        System.out.println("system is ideal - please insert your card");
    }

    @Override
    public String getStateName(){
        return "Idle";
    }

    @Override
    public ATMState next(ATMMachineContext context){
        if(context.getCurrentCard != null){
            return context.getStateFactory().createHasCardState();
        }
    }
    return this;
}