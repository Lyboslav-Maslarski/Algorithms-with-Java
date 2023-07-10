package GraphTheoryTraversalAndShortestPathsExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _07_TheMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        char[][] matrix = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            matrix[i] = scan.nextLine().replaceAll(" ", "").toCharArray();
        }

        char fillChar = scan.nextLine().charAt(0);
        int[] startCharCoordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = startCharCoordinates[0];
        int col = startCharCoordinates[1];
        char startChar = matrix[row][col];

        fillMatrix(matrix, fillChar, startChar, row, col);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char c : chars) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, char fillChar, char startChar, int row, int col) {
        if (matrix[row][col] != startChar) {
            return;
        }

        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) {
            fillMatrix(matrix, fillChar, startChar, row + 1, col);
        }
        if (col + 1 < matrix[row].length) {
            fillMatrix(matrix, fillChar, startChar, row, col + 1);
        }
        if (row - 1 >= 0) {
            fillMatrix(matrix, fillChar, startChar, row - 1, col);
        }
        if (col - 1 >= 0) {
            fillMatrix(matrix, fillChar, startChar, row, col - 1);
        }
    }
}
