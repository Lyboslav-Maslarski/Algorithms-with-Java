package DynamicProgrammingExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _04_SumWithUnlimitedCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] coins = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int targetSum = Integer.parseInt(sc.nextLine());

        int[] table = new int[targetSum + 1];
        table[0] = 1;

        for (int coin : coins) {
            for (int j = coin; j <= targetSum; j++) {
                table[j] += table[j - coin];
            }
        }
        System.out.println(table[targetSum]);
    }
}
