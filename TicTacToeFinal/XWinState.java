package TicTacToeFinal;

public class XWinState implements GameState {
    private String winnerName = "Player X";

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
