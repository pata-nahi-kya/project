package TicTacToeFinal;

public class PlayGame {
    public static void main(String[] args) {
        PlayerStrategy playerXStrategy = new HumanPlayerStrategy("Player X");
        //PlayerStrategy playerOStrategy = new HumanPlayerStrategy("Player O");
        PlayerStrategy computerPlayerStrategy = new ComputerPlayerStrategy("Computer");
        TicTacToeGame game = new TicTacToeGame(playerXStrategy, computerPlayerStrategy, 3, 3);
        game.play();
    }
}
