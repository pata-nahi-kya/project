package TicTacToeFinal;

public class TicTacToeGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private GameContext gameContext;

    public TicTacToeGame(PlayerStrategy playerXStrategy, PlayerStrategy playerOStrategy,int rows , int columns) {
        this.board = new Board(rows,columns);
        this.playerX = new Player("player_x" , Symbol.X);
        this.playerO = new Player("player_o" , Symbol.O);
        this.currentPlayer = playerX;
        this.gameContext = new GameContext();
        
    }

    void play(){
        do{
            board.printBoard();
            PositionTicTacToe position = currentPlayer.makeMove(board);
            board.makeMove(position, currentPlayer.getSymbol());
            board.checkGameState(gameContext);
            switchPlayer();
        }while(!gameContext.isGameOver());
        announceResult();
    }

    void switchPlayer(){
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        } else {
            currentPlayer = playerX;
        }
    }

    void announceResult(){
        if (gameContext.isGameOver()) {
            if (gameContext.getWinner() != null) {
                System.out.println("Congratulations " + gameContext.getWinner() + ", you have won!");
            } else {
                System.out.println("It's a draw!");
            }
        }
    }

}
