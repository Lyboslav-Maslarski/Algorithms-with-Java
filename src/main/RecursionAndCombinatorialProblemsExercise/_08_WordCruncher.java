package RecursionAndCombinatorialProblemsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class _08_WordCruncher {

    public static List<String> words;
    public static List<String> combined = new ArrayList<>();
    public static String target;
    public static Map<Integer, List<String>> table = new HashMap<>();
    public static Map<String, Integer> occurrences = new HashMap<>();
    public static Set<String> out = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        words = Arrays.stream(sc.nextLine().split(", ")).collect(Collectors.toList());
        target = sc.nextLine();

        words.removeIf(w -> !target.contains(w));

        for (String substr : words) {
            occurrences.putIfAbsent(substr, 0);
            occurrences.put(substr, occurrences.get(substr) + 1);

            int index = target.indexOf(substr);
            while (index >= 0) {
                table.putIfAbsent(index, new ArrayList<>());
                table.get(index).add(substr);

                index = target.indexOf(substr, index + 1);
            }
        }

        permute(0);

        out.forEach(System.out::println);
    }

    private static void permute(int index) {
        if (index == target.length()) {
            print();
        } else if (table.containsKey(index)) {
            List<String> strings = table.get(index);
            for (String str : strings) {
                if (occurrences.get(str) > 0) {
                    occurrences.put(str, occurrences.get(str) - 1);
                    combined.add(str);
                    permute(index + str.length());
                    combined.remove(combined.size() - 1);
                    occurrences.put(str, occurrences.get(str) + 1);
                }
            }
        }
    }

    private static void print() {
        String actual = String.join("", combined);
        if (actual.equals(target)) {
            out.add(String.join(" ", combined));
        }
    }
}
