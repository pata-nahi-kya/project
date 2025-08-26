package TicTacToe;

import java.util.Scanner;

public class TicTacToeDesign {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input , row , col;
        // Create the game board
        char[][] board = {
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' },
                { ' ', ' ', ' ' }
        };
        System.out.print("Enter 0-8");

        // Display the initial board
        displayBoard(board);
        while (!isGameOverForWhile(board)) {
            // Get player input and update the board
            System.out.println("it turn of X enter 0your move");
            input = sc.nextInt();
            row = input / 3;
            col = input % 3;
            
            if (board[row][col] == ' ') {
                board[row][col] = 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
            displayBoard(board);
            if (isWinner(board, 'X')) {
                System.out.println("Player X wins!");
                break;
            }
            
            // second player turn
            System.out.print(" it turn of O enter your move ");
            input = sc.nextInt();
            row = input / 3;
            col = input % 3;

            if (board[row][col] == ' ') {
                board[row][col] = 'O';
            } else {
                System.out.println("Invalid move. Try again.");
            }
            displayBoard(board);
            if (isWinner(board, 'O')) {
                System.out.println("Player O wins!");
                break;
            }
            
        }
        if (isDraw(board)) {
            System.out.println("It's a draw!");
        }

        sc.close();
    }

    private static boolean isGameOverForWhile(char[][] board) {
        return isGameOver(board);
    }

    // Method to display the game board
    public static void displayBoard(char[][] board) {
        System.out.println("Current Board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print("| " + cell + " ");
            }
            System.out.println("|");
        }
    }

    // method to check if game is over
    public static boolean isGameOver(char[][] board) {
        return isWinner(board, 'X') || isWinner(board, 'O') || isDraw(board);
    }

    public static boolean isWinner(char[][] board, char player) {
        // Check rows, columns, and diagonals for a win
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Check rows
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Check columns
                return true;
            }
        }
        // Check diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Main diagonal
                (board[0][2] == player && board[1][1] == player && board[2][0] == player) ) { // Anti diagonal
            return true;
        }
        return false;
    }

    public static boolean isDraw(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false; // Found an empty cell, not a draw
                }
            }
        }
        return true; // No empty cells, it's a draw
    }

}
