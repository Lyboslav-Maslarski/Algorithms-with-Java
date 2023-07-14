package ExamPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClusterBorder {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] singleEntryTimes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] pairEntryTimes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] memory = new int[singleEntryTimes.length + 1];
        memory[1] = singleEntryTimes[0];

        for (int i = 2; i <= singleEntryTimes.length; i++) {
            int singleShipTime = memory[i - 1] + singleEntryTimes[i - 1];
            int pairShipsTime = memory[i - 2] + pairEntryTimes[i - 2];
            memory[i] = Math.min(singleShipTime, pairShipsTime);
        }

        System.out.println("Optimal Time: " + memory[singleEntryTimes.length]);

        int index = singleEntryTimes.length;
        List<String> output = new ArrayList<>();

        while (index > 0) {
            if (memory[index - 1] + singleEntryTimes[index - 1] == memory[index]) {
                output.add("Single " + index);
                index--;
            } else {
                output.add(String.format("Pair of %d and %d", index - 1, index));
                index -= 2;
            }
        }

        Collections.reverse(output);
        System.out.println(String.join(System.lineSeparator(), output));
    }
}
