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
        int pos = scan.nextInt();
        System.out.println(pos);

        // Change space character with X or O with switch loop
        switch (pos) {
            case 1:
                gameBoard[0][0] = 'X';
                break;
            case 2:
                gameBoard[0][0] = 'X';
                break;
            case 3:
                gameBoard[0][0] = 'X';
                break;
            case 4:
                gameBoard[0][0] = 'X';
                break;
            case 5:
                gameBoard[0][0] = 'X';
                break;
            case 6:
                gameBoard[0][0] = 'X';
                break;
            case 7:
                gameBoard[0][0] = 'X';
                break;
            case 8:
                gameBoard[0][0] = 'X';
                break;
            case 9:
                gameBoard[0][0] = 'X';
                break;
        }
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
}