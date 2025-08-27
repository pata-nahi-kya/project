package TicTacToeFinal;

import java.util.ArrayList;

public class ComputerPlayerStrategy extends Player {
    Symbol playerSymbol;
    String playerName;

    ComputerPlayerStrategy(String playerName, Symbol playerSymbol) {
        super(playerName, playerSymbol);
        this.playerSymbol = playerSymbol;
        this.playerName = playerName;
    }

    @Override
    public PositionTicTacToe makeMove(Board board) {
        System.out.println(playerName + " is thinking...");
        
        // Get available positions
        ArrayList<PositionTicTacToe> availablePositions = board.getAvailablePositions();
        
        if (availablePositions.isEmpty()) {
            System.out.println("No available positions left!");
            return null;
        }
        
        // Random selection
        int randomIndex = (int) (Math.random() * availablePositions.size());
        PositionTicTacToe selectedPosition = availablePositions.get(randomIndex);
        
        System.out.println(playerName + " chooses position: (" + 
                          selectedPosition.getRow() + ", " + selectedPosition.getCol() + ")");
        
        return selectedPosition;
    }
}
