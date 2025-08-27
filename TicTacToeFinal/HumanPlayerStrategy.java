package TicTacToeFinal;

import java.util.Scanner;

public class HumanPlayerStrategy extends Player{ 
    Scanner sc = new Scanner(System.in);
    String playerName;
    Symbol playerSymbol;
    public HumanPlayerStrategy(String playerName, Symbol playerSymbol) {
        super(playerName,playerSymbol);
        this.playerName = playerName;
        this.playerSymbol = playerSymbol;
    }

    @Override
    public PositionTicTacToe makeMove(Board board) {
        System.out.println(playerName + " enter your move (row and column): ");
        int row = sc.nextInt();
        int col = sc.nextInt();
            return new PositionTicTacToe(row, col);
        }
    
}


