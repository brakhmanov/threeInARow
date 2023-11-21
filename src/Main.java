import java.util.*;

public class Main {
    // Player and cpu positions in array list
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();
    public static void main(String[] args) {

        // Create 2D array for our board
        char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        // Call printGameBoard method
        printGameBoard(gameBoard);


        // Game loop
        while (true) {
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

            // Check the winner
            String result = checkWinner();
            System.out.println(result);
        }
    }

    // Create the method to print game board
    public static void printGameBoard(char[][] gameBoard) {
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
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
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

    // Check winner method
    public static String checkWinner() {

        // Row checker for every row with help of list
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        // Row checker for columns
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        // Diagonals checker
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(7, 5, 3);

        List<List> winConditions = new ArrayList<>();
        winConditions.add(topRow);
        winConditions.add(midRow);
        winConditions.add(botRow);
        winConditions.add(leftCol);
        winConditions.add(midCol);
        winConditions.add(rightCol);
        winConditions.add(cross1);
        winConditions.add(cross2);

        for(List l : winConditions) {
            if(playerPositions.containsAll(l)) {
                return "Congratulations! YOU WON!";
            } else if (cpuPositions.containsAll(l)) {
                return "You lost. Game over :(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "No one wins. It is a tie. ";
            }
        }


        return "";
    }
}