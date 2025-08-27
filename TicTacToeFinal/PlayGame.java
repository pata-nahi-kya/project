package TicTacToeFinal;

public class PlayGame {
    public static void main(String[] args) {
        PlayerStrategy playerXStrategy = new HumanPlayerStrategy("Player X", Symbol.X);
        //PlayerStrategy playerOStrategy = new HumanPlayerStrategy("Player O", Symbol.O);
        PlayerStrategy computerPlayerStrategy = new ComputerPlayerStrategy("Computer", Symbol.O);
        TicTacToeGame game = new TicTacToeGame(playerXStrategy, computerPlayerStrategy, 3, 3);
        game.play();
    }
}
