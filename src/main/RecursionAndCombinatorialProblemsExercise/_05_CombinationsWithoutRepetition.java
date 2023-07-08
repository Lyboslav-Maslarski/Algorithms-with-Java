package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _05_CombinationsWithoutRepetition {
    static int[] variations;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        variations = new int[k];

        combinations(0, 1);
    }

    private static void combinations(int index, int start) {
        if (index == variations.length) {
            for (int variation : variations) {
                System.out.print(variation + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i <= n; i++) {
            variations[index] = i;
            combinations(index + 1, i + 1);
        }
    }
}
