package DynamicProgrammingExercise;

import java.util.Scanner;

public class _06_WordDifferences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] first = sc.nextLine().toCharArray();
        char[] second = sc.nextLine().toCharArray();

        int[][] table = new int[first.length + 1][second.length + 1];

        for (int i = 0; i <= first.length; i++) {
            for (int j = 0; j <= second.length; j++) {
                if (i == 0) {
                    table[i][j] = j;
                } else if (j == 0) {
                    table[i][j] = i;
                } else if (first[i - 1] == second[j - 1]) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.min(table[i - 1][j], table[i][j - 1]) + 1;
                }
            }
        }

        System.out.println("Deletions and Insertions: " + table[first.length][second.length]);
    }
}
