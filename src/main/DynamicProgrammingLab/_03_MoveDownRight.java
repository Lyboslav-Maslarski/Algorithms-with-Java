package DynamicProgrammingLab;

import java.util.*;

public class _03_MoveDownRight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] table = new int[rows][cols];
        table[0][0] = matrix[0][0];

        for (int col = 1; col < cols; col++) {
            table[0][col] = table[0][col - 1] + matrix[0][col];
        }

        for (int row = 1; row < rows; row++) {
            table[row][0] = table[row - 1][0] + matrix[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                table[row][col] = Math.max(table[row][col - 1], table[row - 1][col]) + matrix[row][col];
            }
        }

        int row = rows - 1;
        int col = cols - 1;

        List<String> path = new ArrayList<>();
        path.add(String.format("[%d, %d]", row, col));

        while (row > 0 && col > 0) {
            int top = table[row - 1][col];
            int left = table[row][col - 1];

            if (top > left) {
                row--;
            } else {
                col--;
            }
            path.add(String.format("[%d, %d]", row, col));
        }

        while (row > 0) {
            row--;
            path.add(String.format("[%d, %d]", row, col));
        }

        while (col > 0) {
            col--;
            path.add(String.format("[%d, %d]", row, col));
        }

        Collections.reverse(path);
        System.out.println(String.join(" ", path));
    }
}
