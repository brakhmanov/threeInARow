import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create 2D array for our board
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        // Call printGameBoard method
        printGameBoard(gameBoard);


        Scanner scan = new Scanner(System.in);
        // Ask player to choose position to place X or O
        System.out.println("Choose position (1-9): ");
        int playerPos = scan.nextInt();

        // Calling placePiece method for player to place X
        placePiece(gameBoard, playerPos, "player");

        // Same method but with Random for computer to place O
        Random rand = new Random();
        int cpuPos = rand.nextInt(9) + 1;
        placePiece(gameBoard, cpuPos, "cpu");

        // Print game board with X that changed position
        printGameBoard(gameBoard);
    }

    // Create the method to print game board
    public static void printGameBoard(char[][]gameBoard) {
        // Print out the game board using 2 nested loops
        for (char[] row : gameBoard) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    // Create own method for placing the X to reuse later
    public static void placePiece(char[][] gameBoard, int pos, String user) {

        // Variable to set (X or O)
        char symbol = ' ';

        // If playing against computer set the variable to O
        if(user.equals("player")) {
            symbol = 'X';
        } else if (user.equals("cpu")) {
            symbol = 'O';

        }

        // Change space character with X or O (symbol) with switch loop
        switch (pos) {
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;
        }
    }
}