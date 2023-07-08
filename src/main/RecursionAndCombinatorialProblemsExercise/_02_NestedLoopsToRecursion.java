package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class _02_NestedLoopsToRecursion {
    public static StringBuilder sb = new StringBuilder();
    public static int[] numbers;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        numbers = new int[n];

        permute(0);
        System.out.print(sb);
    }

    private static void permute(int index) {
        if (index == numbers.length) {
            printArr();
        } else {
            for (int i = 1; i <= n; i++) {
                numbers[index] = i;
                permute(index + 1);
            }
        }
    }

    private static void printArr() {
        sb.append(Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining(" ")))
                .append(System.lineSeparator());
    }
}