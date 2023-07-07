package RecursionAndBacktracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindAllPathsInALabyrinth {
    public static List<Character> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        char[][] matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        findPath(matrix, 0, 0, ' ');

    }

    private static void findPath(char[][] matrix, int row, int col, char direction) {
        if (row < 0 || row == matrix.length
                || col < 0 || col == matrix[row].length
                || matrix[row][col] == '*'
                || matrix[row][col] == 'v') {
            return;
        }

        if (matrix[row][col] == 'e') {
            path.add(direction);
            printPath(path);
        } else if (matrix[row][col] == '-') {
            matrix[row][col] = 'v';
            path.add(direction);

            findPath(matrix, row + 1, col, 'D');
            findPath(matrix, row, col + 1, 'R');
            findPath(matrix, row, col - 1, 'L');
            findPath(matrix, row - 1, col, 'U');

            matrix[row][col] = '-';
        }

        path.remove(path.size() - 1);
    }

    private static void printPath(List<Character> path) {
        for (Character character : path) {
            if (character != ' ') {
                System.out.print(character);
            }
        }
        System.out.println();
    }
}
