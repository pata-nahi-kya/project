package TicTacToeFinal;

public class OTurnState implements GameState {
    private String winnerName;

    @Override
    public void next(GameContext context, Player player, boolean hasWon) {
        if (hasWon) {
            context.setState(player.getSymbol() == Symbol.X ? new XWinState() : new OWinState());
            return;
        } else {
            context.setState(new XTurnState());

        }
    }

    @Override
    public boolean isGameOver() {
        return false;
    }

    @Override
    public String getWinnerName() {
      
        return null;
    }
