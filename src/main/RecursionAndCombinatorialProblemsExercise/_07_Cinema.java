package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _07_Cinema {
    public static String[] seats;
    public static String[] combinations;
    public static boolean[] used;
    public static List<String> people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        people = Arrays.stream(br.readLine().split(", ")).collect(Collectors.toList());
        seats = new String[people.size()];

        String line = br.readLine();
        while (!"generate".equals(line)) {
            String[] command = line.split(" - ");

            String name = command[0];
            int position = Integer.parseInt(command[1]) - 1;

            seats[position] = name;
            people.remove(name);

            line = br.readLine();
        }

        combinations = new String[people.size()];
        used = new boolean[people.size()];

        permute(0);
    }

    private static void permute(int index) {
        if (index == combinations.length) {
            print();
        } else {
            for (int i = 0; i < people.size(); i++) {
                if (!used[i]) {
                    combinations[index] = people.get(i);
                    used[i] = true;
                    permute(index + 1);
                    used[i] = false;
                }
            }
        }
    }

    private static void print() {
        int index = 0;
        String[] out = new String[seats.length];
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == null) {
                out[i] = combinations[index++];
            } else {
                out[i] = seats[i];
            }
        }
        System.out.println(String.join(" ", out));
    }
}
