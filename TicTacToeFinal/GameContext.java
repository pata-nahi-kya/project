package TicTacToeFinal;

public class GameContext {
    GameState currentState;

    

    public GameContext() {
        currentState = new XTurnState();
        
    }

    public void setState(GameState currentState) {
        this.currentState = currentState;
    }

    public GameState getState() {
        return currentState;
    }

    boolean isGameOver() {
        return currentState.isGameOver();
    }
    String getWinner() {
        return currentState.getWinnerName();
    }
}
