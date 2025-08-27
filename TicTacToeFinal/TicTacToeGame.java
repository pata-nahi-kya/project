package TicTacToeFinal;

public class TicTacToeGame {
    private Board board;
    private PlayerStrategy playerXStrategy;
    private PlayerStrategy playerOStrategy;
    private PlayerStrategy currentPlayerStrategy;
    private Symbol currentSymbol;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy playerXStrategy, PlayerStrategy playerOStrategy, int rows, int columns) {
        this.board = new Board(rows, columns);
        this.playerXStrategy = playerXStrategy;
        this.playerOStrategy = playerOStrategy;
        this.currentPlayerStrategy = playerXStrategy; // Start with X
        this.currentSymbol = Symbol.X;
        this.gameContext = new GameContext();
    }

    void play() {
        System.out.println("Game Started!");
        do {
            board.printBoard();
            PositionTicTacToe position = currentPlayerStrategy.makeMove(board);
            if (position != null) {
                board.makeMove(position, currentSymbol);
                board.checkGameState(gameContext);
                if (!gameContext.isGameOver()) {
                    switchPlayer();
                }
            }
        } while (!gameContext.isGameOver());
        
        board.printBoard(); // Show final board
        announceResult();
    }

    void switchPlayer() {
        if (currentPlayerStrategy == playerXStrategy) {
            currentPlayerStrategy = playerOStrategy;
            currentSymbol = Symbol.O;
        } else {
            currentPlayerStrategy = playerXStrategy;
            currentSymbol = Symbol.X;
        }
    }

    void announceResult() {
        if (gameContext.isGameOver()) {
            if (gameContext.getWinner() != null) {
                System.out.println("Congratulations " + gameContext.getWinner() + ", you have won!");
            } else {
                System.out.println("It's a draw!");
            }
        }
    }
}