public class Board {
    // Create 2D array for board 3x3
    char [][] board = new char[3][3];

    // Fill the board with help of nested loop
    // r represents rows and c represents columns
    for( int r = 0; r < 3; r++) {
        for( int c = 0; c < 3; c++) {
            board[r][c] = ' ';
        }
    }

    // drawBoard function
    public static void drawBoard(char[][] board) {
        for( int r= 0; r < 3; r++) {
            for( int c=0; c < 3; c++) {
                System.out.println(board[r][c]);
            }
        }
    }

}
