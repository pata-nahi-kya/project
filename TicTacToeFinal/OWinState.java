package TicTacToeFinal;

public class OWinState implements GameState {
    private String winnerName = "Player O";

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {

    
    }

    @Override
    public boolean isGameOver() {
        return true;
    }

    @Override
    public String getWinnerName() {
        return winnerName;
    }

}
