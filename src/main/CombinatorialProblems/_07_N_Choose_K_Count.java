package CombinatorialProblems;

import java.util.Scanner;

public class _07_N_Choose_K_Count {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(binom(n, k));
    }

    private static int binom(int n, int k) {
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            return 1;
        }
        return binom(n - 1, k - 1) + binom(n - 1, k);
    }
}
