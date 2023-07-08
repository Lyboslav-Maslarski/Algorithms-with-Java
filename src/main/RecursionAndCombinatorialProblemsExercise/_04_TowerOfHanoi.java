package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.stream.Collectors;

public class _04_TowerOfHanoi {
    public static StringBuilder sb = new StringBuilder();
    public static Deque<Integer> source = new ArrayDeque<>();
    public static Deque<Integer> spare = new ArrayDeque<>();
    public static Deque<Integer> destination = new ArrayDeque<>();
    public static int steps = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int disks = Integer.parseInt(bf.readLine());

        for (int i = disks; i >= 1; i--) {
            source.push(i);
        }

        print();
        solve(disks, source, destination, spare);

        System.out.print(sb.toString());
    }

    private static void solve(int disk, Deque<Integer> source, Deque<Integer> destination, Deque<Integer> spare) {
        if (disk == 1) {
            destination.push(source.pop());
            sb.append("Step #").append(steps++).append(": Moved disk").append(System.lineSeparator());
            print();
        } else {
            solve(disk - 1, source, spare, destination);
            solve(1, source, destination, spare);
            solve(disk - 1, spare, destination, source);
        }
    }

    private static void print() {
        sb.append(String.format("Source: %s%nDestination: %s%nSpare: %s%n%n",
                formatRod(source), formatRod(destination), formatRod(spare)));
    }

    private static String formatRod(Deque<Integer> deque) {
        return deque.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
}