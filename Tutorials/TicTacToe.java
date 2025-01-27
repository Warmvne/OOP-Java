//Code in Java a Tic-Tac-Toe game. 
//In this game, two players alternate placing Xs and Os into a grid until one player has three matching symbols in a row, either horizontally, vertically, or diagonally. 
//Create a game in which the user is presented with a three-by-three grid containing the digits 1 through 9.When the user chooses a position by typing a number, place an X in the appropriate spot. 
//Generate a random number for the position where the computer will place an O. 
//Do not allow the player or the computer to place a symbol where one has already been placed. 
//Figure below shows the first four windows in a typical game. When either the player or computer has three symbols in a row, declare a winner; if all positions have been exhausted and no one has three symbols in a row, declare a tie.

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
        // Create a 3x3 board
        char[][] board = new char[3][3];

        // Initialize the board with empty spaces
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }

        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Create a Random object for computer's move
        Random random = new Random();

        // Keep track of whose turn it is
        boolean isPlayerTurn = true;

        // Keep playing until someone wins or there is a tie
        while (true) {
            // Print the board
            printBoard(board);

            // Get the user's move
            int row, col;
            if (isPlayerTurn) {
                System.out.print("Enter your move (row [1-3] column [1-3]): ");
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            } else {
                // Generate a random move for the computer
                row = random.nextInt(3);
                col = random.nextInt(3);
            }

            // Make sure the position is empty
            if (board[row][col] == ' ') {
                // Place an X or O in the position
                board[row][col] = isPlayerTurn ? 'X' : 'O';

                // Check for a winner
                if (isWinner(board)) {
                    printBoard(board);
                    System.out.println(isPlayerTurn ? "You win!" : "Computer wins!");
                    break;
                }

                // Check for a tie
                if (isTie(board)) {
                    printBoard(board);
                    System.out.println("It's a tie!");
                    break;
                }

                // Switch turns
                isPlayerTurn = !isPlayerTurn;
            } else {
                System.out.println("Position already taken!");
            }
        }
    }

    // Print the board
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Check for a winner
    public static boolean isWinner(char[][] board) {
        // Check for a horizontal win
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return true;
            }
        }

        // Check for a vertical win
        for (int j = 0; j < 3; j++) {
            if (board[0][j] != ' ' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return true;
            }
        }

        // Check for a diagonal win
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }

    // Check for a tie
    public static boolean isTie(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}
