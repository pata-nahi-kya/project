package TicTacToeFinal;

public class ComputerPlayerStrategy implements PlayerStrategy {
    String playerName;

    ComputerPlayerStrategy(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public PositionTicTacToe makeMove(Board board) {
        System.out.println(playerName + " enter your move (row and column): ");
        int length = board.availablePositions.size();
         if(length == 0){
            System.out.println("No available positions left!");
            return null; // or handle as needed
        }
        int index = (int) (Math.random() * length);
        return board.availablePositions.get(index);
    }
}
