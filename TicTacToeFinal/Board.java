package TicTacToeFinal;

import java.util.ArrayList;

public class Board {
    private final int rows ;
    private final int columns;
    private final Symbol[][] grid;
    ArrayList<PositionTicTacToe> availablePositions = new ArrayList<>();

    Board(int rows , int columns ){
        this.rows = rows;
        this.columns = columns;
        this.grid = new Symbol[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Symbol.EMPTY; // Initialize all cells to EMPTY
            }
        }
    }

    Board(int size) { 
        this(size, size);
    }

    void playGame(){
    }

    boolean isValidMove(PositionTicTacToe position){
        if (position.getRow() < 0 || position.getRow() > rows || position.getCol() < 0 || position.getCol() > columns) {
            return false; // Position is out of bounds
        }
        return grid[position.getRow()][position.getCol()] == Symbol.EMPTY; // Check if the cell is empty
    }

    void makeMove(PositionTicTacToe position, Symbol symbol) {
        if (isValidMove(position)) {
            grid[position.getRow()][position.getCol()] = symbol; // Place the symbol on the grid
        } else {
            System.out.println("Invalid move! Try again.");
        }
    }
     
     public void printBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Symbol symbol = grid[i][j];
                switch (symbol) {
                    case X:
                        System.out.print(" X ");
                        break;
                    case O:
                        System.out.print(" O ");
                        break;
                    case EMPTY:
                    default:
                        System.out.print(" . ");
                }
                if (j < columns - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < rows - 1) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }
    
    void checkGameState(GameContext context){
        // Check rows for a win
        for (int i = 0; i < rows; i++) {
            if (isWinningLine(grid[i])) {
                context.setState(grid[i][0] == Symbol.X ? new XWinState() : new OWinState());
                return;
            }
        }

        // Check columns for a win
        for (int j = 0; j < columns; j++) {
            Symbol[] column = new Symbol[rows];
            for (int i = 0; i < rows; i++) {
                column[i] = grid[i][j];
            }
            if (isWinningLine(column)) {
                context.setState(column[0] == Symbol.X ? new XWinState() : new OWinState());
                return;
            }
        }

        // Check diagonals for a win
        Symbol[] diagonal1 = new Symbol[Math.min(rows, columns)];
        Symbol[] diagonal2 = new Symbol[Math.min(rows, columns)];
        for (int i = 0; i < Math.min(rows, columns); i++) {
            diagonal1[i] = grid[i][i];
            diagonal2[i] = grid[i][columns - 1 - i];
        }
        if (isWinningLine(diagonal1)) {
            context.setState(diagonal1[0] == Symbol.X ? new XWinState() : new OWinState());
            return;
        }
        if (isWinningLine(diagonal2)) {
            context.setState(diagonal2[0] == Symbol.X ? new XWinState() : new OWinState());
            return;
        }

        // Check for draw or continue
        boolean isDraw = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == Symbol.EMPTY) {
                    isDraw = false;
                    break;
                }
            }
            if (!isDraw) {
                break;
            }
        }
        if (isDraw) {
            context.setState(new DrawState());
        } else {
            context.setState(new XTurnState()); // Continue the game
        }
}

    boolean isWinningLine(Symbol[] line){

        Symbol firstSymbol = line[0];
        if (firstSymbol == Symbol.EMPTY) {
            return false; // An empty cell cannot be part of a winning line
        }
        for (Symbol symbol : line) {
            if (symbol != firstSymbol) {
                return false; // Found a different symbol, not a winning line
            }
        }
        return true; // All symbols are the same and not EMPTY, it's a winning line
    }

    ArrayList<PositionTicTacToe> getAvailablePositions() {
        availablePositions.clear();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == Symbol.EMPTY) {
                    availablePositions.add(new PositionTicTacToe(i, j));
                }
            }
        }
        return availablePositions;
    }
}
