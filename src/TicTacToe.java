import java.util.Scanner;
public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String board[][] = new String[ROWS][COLS];

    static void main(String[] args) {
        Scanner pipe = new Scanner(System.in);
        boolean playing = true;
        String player = "X";
        int moveCount = 0;
        int arrayCol = 0;
        int arrayRow = 0;
        boolean validMove = false;


        do {
            /* clear board and set player to X */

            clearBoard();
            player = "X";
            do {

                /* first board display */

                display();

                /* get coords for board move */
                do {
                    int rowmove = SafeInput.getRangedInt(pipe, player + " player enter the row you wish to place your move in", 1, 3);
                    int colmove = SafeInput.getRangedInt(pipe, player + " player enter the column you wish to place your move in", 1, 3);


                    /* convert to array coords */
                    arrayCol = colmove - 1;
                    arrayRow = rowmove - 1;

                    /* verify move validity */

                    validMove = isValidMove(arrayRow, arrayCol);

                    if (!validMove) {
                        System.out.println("Invalid move! Try again.");
                    }

                } while (!validMove);

                /* record move on board */

                board[arrayRow][arrayCol] = player;
                display();
                System.out.println();

                /* add to move counter */

                moveCount++;

                /* check for win or tie after count is five then continue until game end */
                if (moveCount >= 5) {
                    if (isWin(player)) {
                        System.out.println("Congratulations! " + player + " player wins!");
                        break;
                    } else if (isTie()) {
                        System.out.println("Game is a Draw!");
                    }
                }
                /* if win or tie anouncement*/

                /* toggle player */
                if (player.equals("X")) {
                    player = "O";
                } else {
                    player = "X";
                }

            } while (moveCount < 9);

            /* prompt rematch */
            pipe.nextLine();
            boolean continuePlaying = SafeInput.getYNConfirm(pipe,"Would you like to play again?");

            if (continuePlaying) {
                moveCount = 0;
            } else if (!continuePlaying) {
                playing = false;
            }

        } while (playing);

    }

    private static void clearBoard() {
        for (int square = 0; square < board.length; square++) {
            board[square][0] = " ";
            board[square][1] = " ";
            board[square][2] = " ";
        }
    }

    private static void display() {
        for (int square = 0; square < board.length; square++) {
            System.out.print("[" + board[0][square] + "]");
            System.out.print("[" + board[1][square] + "]");
            System.out.print("[" + board[2][square] + "]");
            System.out.println();
        }
    }

    private static boolean isValidMove(int row, int col) {
        if (board[row][col].equals("X") || board[row][col].equals("O")) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean isWin(String player) {
        if (isColWin(player)) {
            return true;
        } else if (isRowWin(player)) {
            return true;
        } else if (isDiagnalWin(player)) {
            return true;
        } else
            return false;
    }

    private static boolean isColWin(String player) {
        if (board[0][0].equals(player) && board[0][1].equals(player) && board[0][2].equals(player)) {
            return true;
        } else if (board[1][0].equals(player) && board[1][1].equals(player) && board[1][2].equals(player)) {
            return true;
        } else if (board[2][0].equals(player) && board[2][1].equals(player) && board[2][2].equals(player)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isRowWin(String player) {
        if (board[0][0].equals(player) && board[1][0].equals(player) && board[2][0].equals(player)) {
            return true;
        } else if (board[0][1].equals(player) && board[1][1].equals(player) && board[2][1].equals(player)) {
            return true;
        } else if (board[0][2].equals(player) && board[1][2].equals(player) && board[2][2].equals(player)) {
            return true;
        } else
            return false;
    }

    private static boolean isDiagnalWin(String player) {
        if (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) {
            return true;
        } else if (board[2][0].equals(player) && board[1][1].equals(player) && board[0][2].equals(player)) {
            return true;
        } else
            return false;
    }

    private static boolean isTie() {
        int row1Blocked = 0;
        int col1Blocked = 0;
        int row2Blocked = 0;
        int col2Blocked = 0;
        int row3Blocked = 0;
        int col3Blocked = 0;
        int diagnal1Blocked = 0;
        int diagonal2Blocked = 0;

            if ((board[0][0].equals("X") || board[0][0].equals("O")) && (board[1][0].equals("X") || board[1][0].equals("O")) && (board[2][0].equals("X") || board[2][0].equals("O"))) {
                 row1Blocked = 1;
            }
            if ((board[0][1].equals("x") || board[0][1].equals("O")) && (board[1][1].equals("X") || board[1][1].equals("O")) && (board[2][1].equals("X") || board[2][1].equals("O"))) {
                 row2Blocked = 1;
            }
            if ((board[0][2].equals("X") || board[0][2].equals("O")) && (board[1][2].equals("X") || board[1][2].equals("O")) && (board[2][2].equals("X") || board[2][2].equals("O"))) {
                row3Blocked = 1;
            }
            if((board[0][0].equals("X") || board[0][0].equals("O")) && (board[0][1].equals("X") || board[0][1].equals("O")) && (board[0][2].equals("X") || board[0][2].equals("O"))) {
                col1Blocked = 1;
            }
            if((board[1][0].equals("X") || board[1][0].equals("O")) && (board[1][1].equals("X") || board[1][1].equals("O")) && (board[1][2].equals("X") || board[1][2].equals("O"))) {
                col2Blocked = 1;
            }
            if ((board[2][0].equals("X") || board[2][0].equals("O")) && (board[2][1].equals("X") || board[2][1].equals("O")) && (board[2][2].equals("X") || board[2][2].equals("O"))) {
                col3Blocked = 1;
            }
            if((board[0][0].equals("X") || board[0][0].equals("O")) && (board[1][1].equals("X") || board[1][1].equals("O")) && (board[2][2].equals("X") || board[2][2].equals("O"))) {
                diagnal1Blocked = 1;
            }
            if((board[2][0].equals("X") || board[2][0].equals("O")) && (board[1][1].equals("X")  || board[1][1].equals("O")) && (board[0][2].equals("X") || board[0][2].equals("O"))) {
                diagonal2Blocked = 1;
            }
        int totalBlocked = row1Blocked + row2Blocked + row3Blocked + col1Blocked + col2Blocked + col3Blocked + diagnal1Blocked + diagonal2Blocked;

            if ( totalBlocked == 8) {
                return true;
            }else{
                return false;
            }
    }
}