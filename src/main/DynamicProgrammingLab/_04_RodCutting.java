package DynamicProgrammingLab;

import java.util.Arrays;
import java.util.Scanner;

public class _04_RodCutting {
    public static int[] bestPrices;
    public static int[] prevIndex;
    public static int[] prices;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        prices = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int length = Integer.parseInt(sc.nextLine());
        bestPrices = new int[length + 1];
        prevIndex = new int[length + 1];

        int maxProfit = cutRod(length);

        System.out.println(maxProfit);

        while (length - prevIndex[length] != 0) {
            System.out.print(prevIndex[length] + " ");
            length = length - prevIndex[length];
        }
        System.out.print(prevIndex[length]);
    }

    private static int cutRod(int length) {
        if (length == 0) {
            return 0;
        }

        if (bestPrices[length] > 0) {
            return bestPrices[length];
        }

        int currentBest = bestPrices[length];

        for (int i = 1; i <= length; i++) {
            currentBest = Math.max(currentBest, prices[i] + cutRod(length - i));
            if (currentBest > bestPrices[length]) {
                bestPrices[length] = currentBest;
                prevIndex[length] = i;
            }
        }

        return bestPrices[length];
    }
}
