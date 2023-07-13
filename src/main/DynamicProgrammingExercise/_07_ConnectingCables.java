package DynamicProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _07_ConnectingCables {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cables = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] destinations = new int[cables.length];

        for (int i = 0; i < destinations.length; i++) {
            destinations[i] = i + 1;
        }

        int[][] table = new int[cables.length + 1][cables.length + 1];

        for (int i = 1; i <= cables.length; i++) {
            for (int j = 1; j <= cables.length; j++) {
                if (destinations[i - 1] == cables[j - 1]) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        System.out.println("Maximum pairs connected: " + table[cables.length][cables.length]);
    }
}
