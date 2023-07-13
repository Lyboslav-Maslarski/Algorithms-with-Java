package DynamicProgrammingExercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _02_LongestZigZagSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[][] table = new int[numbers.length + 1][2];
        int[][] prev = new int[numbers.length + 1][2];
        table[0][0] = 1;
        prev[0][0] = -1;
        table[0][1] = 1;
        prev[0][1] = -1;

        int maxLength = 0;
        int bestRow = 0;
        int bestCol = 0;

        for (int currentIndex = 0; currentIndex < numbers.length; currentIndex++) {
            int currentNumber = numbers[currentIndex];

            for (int prevIndex = currentIndex - 1; prevIndex >= 0; prevIndex--) {
                int prevNumber = numbers[prevIndex];
                if (currentNumber > prevNumber && table[currentIndex][0] <= table[prevIndex][1] + 1) {
                    table[currentIndex][0] = table[prevIndex][1] + 1;
                    prev[currentIndex][0] = prevIndex;
                } else if (currentNumber < prevNumber && table[currentIndex][1] <= table[prevIndex][0] + 1) {
                    table[currentIndex][1] = table[prevIndex][0] + 1;
                    prev[currentIndex][1] = prevIndex;
                }
            }
            if (maxLength < table[currentIndex][0]) {
                maxLength = table[currentIndex][0];
                bestRow = currentIndex;
                bestCol = 0;
            } else if (maxLength < table[currentIndex][1]) {
                maxLength = table[currentIndex][1];
                bestRow = currentIndex;
                bestCol = 1;
            }
        }

        Deque<Integer> zigZag = new ArrayDeque<>();
        while (bestRow >= 0) {
            zigZag.push(numbers[bestRow]);
            bestRow = prev[bestRow][bestCol];
            bestCol = bestCol == 0 ? 1 : 0;
        }

        while (!zigZag.isEmpty()) {
            System.out.print(zigZag.pop() + " ");
        }
    }
}
