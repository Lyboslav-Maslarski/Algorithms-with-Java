package DynamicProgrammingExercise;

import java.util.*;

public class _05_SumWithLimitedCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] coins = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int targetSum = Integer.parseInt(sc.nextLine());

        Map<Integer, Integer> dp = new HashMap<>();

        int result = 0;
        dp.put(0, 0);

        for (int currentCoin : coins) {

            for (Integer number : new ArrayList<>(dp.keySet())) {
                int newSum = currentCoin + number;

                if (newSum == targetSum) {
                    result++;
                }
                dp.putIfAbsent(newSum, number);
            }
        }
        System.out.println(result);
    }
}
