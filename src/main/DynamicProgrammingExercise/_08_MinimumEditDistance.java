package DynamicProgrammingExercise;

import java.util.Scanner;

public class _08_MinimumEditDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int replace = Integer.parseInt(sc.nextLine());
        int insert = Integer.parseInt(sc.nextLine());
        int delete = Integer.parseInt(sc.nextLine());

        char[] first = sc.nextLine().toCharArray();
        char[] second = sc.nextLine().toCharArray();

        int[][] table = new int[first.length + 1][second.length + 1];

        for (int i = 1; i <= first.length; i++) {
            table[i][0] = table[i - 1][0] + delete;
        }

        for (int i = 1; i <= second.length; i++) {
            table[0][i] = table[0][i - 1] + insert;
        }

        for (int i = 1; i <= first.length; i++) {
            for (int j = 1; j <= second.length; j++) {
                if (first[i - 1] == second[j - 1]) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.min(table[i][j - 1] + insert,
                            Math.min(table[i - 1][j - 1] + replace, table[i - 1][j] + delete));
                }
            }
        }

        System.out.println("Minimum edit distance: " + table[first.length][second.length]);
    }
}
