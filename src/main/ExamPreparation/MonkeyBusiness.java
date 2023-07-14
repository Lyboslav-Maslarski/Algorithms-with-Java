package ExamPreparation;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class MonkeyBusiness {
    public static int[] numbers;
    public static int[] expression;
    public static int n;
    public static int solutions;
    public static StringBuilder stringBuilder = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        numbers = IntStream.rangeClosed(1, n).toArray();
        expression = new int[n];

        variations(0);

        System.out.println(stringBuilder.toString().trim());
        System.out.println("Total Solutions: " + solutions);
    }

    private static void variations(int index) {
        if (index >= n) {
            printSolution();
            return;
        }

        expression[index] = numbers[index];
        variations(index + 1);

        expression[index] = -numbers[index];
        variations(index + 1);
    }

    private static void printSolution() {
        int sum = Arrays.stream(expression).sum();
        if (sum == 0) {
            solutions++;
            for (int num : expression) {
                stringBuilder.append(num > 0 ? "+" + num : num).append(" ");
            }
            stringBuilder.append(System.lineSeparator());
        }
    }
}
