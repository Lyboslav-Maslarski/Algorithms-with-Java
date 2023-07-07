package RecursionAndBacktracking;

public class EightQueensPuzzle {
    static char[][] board = new char[8][8];

    public static void main(String[] args) {
        for (int i = 0; i < board.length; i++) {
            board[i] = "--------".toCharArray();
        }

        findQueenPositions(0);

    }

    private static void findQueenPositions(int row) {
        if (row == 8) {
            printSolution();
        } else {
            for (int col = 0; col < 8; col++) {
                if (canPlaceQueen(row, col)) {
                    putQueen(row, col);
                    findQueenPositions(row + 1);
                    removeQueen(row, col);
                }
            }
        }
    }

    private static void removeQueen(int row, int col) {
        board[row][col] = '-';
    }

    private static void putQueen(int row, int col) {
        board[row][col] = '*';
    }

    private static boolean canPlaceQueen(int row, int col) {
        for (int c = 0; c < 8; c++) {
            if (board[row][c] == '*') {
                return false;
            }
        }

        for (int r = 0; r < 8; r++) {
            if (board[r][col] == '*') {
                return false;
            }
        }

        int r = row;
        int c = col;
        while (r >= 0 && c >= 0) {
            if (board[r--][c--] == '*') {
                return false;
            }
        }

        r = row;
        c = col;
        while (r < 8 && c < 8) {
            if (board[r++][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;
        while (r >= 0 && c < 8) {
            if (board[r--][c++] == '*') {
                return false;
            }
        }

        r = row;
        c = col;
        while (r < 8 && c >= 0) {
            if (board[r++][c--] == '*') {
                return false;
            }
        }
        return true;
    }

    private static void printSolution() {
        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
