package DynamicProgrammingLab;

import java.util.*;
import java.util.stream.Collectors;

public class _02_LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] sequence = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int[] length = new int[sequence.length];
        int[] prev = new int[sequence.length];
        Arrays.fill(prev, -1);

        int maxLength = 0, maxIndex = -1;

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int bestLength = 1;
            int bestIndex = -1;

            for (int j = 0; j < i; j++) {
                if (sequence[j] < current && length[j] + 1 > bestLength) {
                    bestLength = length[j] + 1;
                    bestIndex = j;
                }
            }

            prev[i] = bestIndex;
            length[i] = bestLength;

            if (maxLength < bestLength) {
                maxLength = bestLength;
                maxIndex = i;
            }
        }

        List<Integer> LIS = new ArrayList<>();

        while (maxIndex != -1) {
            LIS.add(sequence[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(LIS);
        System.out.println(LIS.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
