package DynamicProgrammingExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _03_DividingPresents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] gifts = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int totalSum = Arrays.stream(gifts).sum();
        int halfSum = totalSum / 2;
        int[] table = new int[totalSum + 1];

        Arrays.fill(table, -1);
        table[0] = 0;

        for (int i = 0; i < gifts.length; i++) {
            int currentGift = gifts[i];

            for (int prevGiftIndex = totalSum - gifts[i]; prevGiftIndex >= 0; prevGiftIndex--) {
                if (table[prevGiftIndex] != -1 && table[prevGiftIndex + currentGift] == -1) {
                    table[prevGiftIndex + currentGift] = i;
                }
            }
        }

        while (table[halfSum] == -1) {
            halfSum--;
        }

        int difference = totalSum - halfSum * 2;

        System.out.println("Difference: " + difference);
        System.out.println("Alan:" + halfSum + " Bob:" + (totalSum - halfSum));

        List<String> alanGifts = new ArrayList<>();
        while (halfSum > 0) {
            alanGifts.add(String.valueOf(gifts[table[halfSum]]));
            halfSum -= gifts[table[halfSum]];
        }

        System.out.println("Alan takes: " + String.join(" ", alanGifts));
        System.out.println("Bob takes the rest.");
    }
}