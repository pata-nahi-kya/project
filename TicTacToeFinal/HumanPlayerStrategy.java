package TicTacToeFinal;

import java.util.Scanner;

public class HumanPlayerStrategy implements PlayerStrategy{ 
    Scanner sc = new Scanner(System.in);
        String playerName;
        

        HumanPlayerStrategy(String playerName){
            this.playerName = playerName;
        }
        @Override
        public PositionTicTacToe makeMove(Board board){
            System.out.println(playerName + " enter your move (row and column): ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            return new PositionTicTacToe(row, col);
        }
    
}


