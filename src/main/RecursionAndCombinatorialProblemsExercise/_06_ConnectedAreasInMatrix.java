package RecursionAndCombinatorialProblemsExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class _06_ConnectedAreasInMatrix {
    public static char[][] matrix;
    public static List<int[]> areas;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        int cols = Integer.parseInt(sc.nextLine());

        matrix = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }

        areas = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == '-') {
                    areas.add(new int[]{row, col, 0});
                    findArea(row, col);
                }
            }
        }

        AtomicInteger counter = new AtomicInteger(1);
        System.out.println("Total areas found: " + areas.size());
        areas.stream()
                .sorted((f, s) -> s[2] - f[2])
                .forEach(a -> System.out.printf("Area #%d at (%d, %d), size: %d%n", counter.getAndIncrement(),a[0], a[1], a[2]));
    }

    private static void findArea(int row, int col) {
        if (row < 0 || row == matrix.length || col < 0 || col == matrix[row].length ||
                matrix[row][col] == 'v' || matrix[row][col] == '*') {
            return;
        }

        matrix[row][col] = 'v';
        areas.get(areas.size() - 1)[2]++;

        findArea(row - 1, col);
        findArea(row + 1, col);
        findArea(row, col - 1);
        findArea(row, col + 1);
    }
}
