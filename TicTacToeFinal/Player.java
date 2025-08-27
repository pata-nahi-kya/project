package TicTacToeFinal;

import java.util.Scanner;

public class Player implements PlayerStrategy {
    private Scanner sc = new Scanner(System.in);
    private String name;
    private Symbol symbol;

    public Player(String name, Symbol symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    @Override
    public PositionTicTacToe makeMove(Board board) {
        while (true) {
            System.out.println(name + " (" + symbol + "), enter your move (row and column): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            PositionTicTacToe position = new PositionTicTacToe(row, col);
            if (board.isValidMove(position)) {
                return position;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

    }

}
