package TicTacToeFinal;

public class DrawState implements GameState {
    @Override
    public void next(GameContext context, Player player, boolean hasWon) {

        
    }

    @Override
    public boolean isGameOver() {
        return true;
    }

    @Override
    public String getWinnerName() {
        return null; // No winner in a draw
    }
}
