package DynamicProgrammingExercise;

import java.util.Scanner;

public class _01_BinomialCoefficients {
    public static long[][] memory;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        memory = new long[n + 1][k + 1];

        System.out.println(calcBinom(n, k));
    }

    private static long calcBinom(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }

        if (memory[n][k] != 0) {
            return memory[n][k];
        }

        memory[n][k] = calcBinom(n - 1, k) + calcBinom(n - 1, k - 1);
        return memory[n][k];
    }
}
