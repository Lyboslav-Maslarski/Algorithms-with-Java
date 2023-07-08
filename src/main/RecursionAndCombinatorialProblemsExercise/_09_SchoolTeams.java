package RecursionAndCombinatorialProblemsExercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _09_SchoolTeams {
    public static String[] girls;
    public static String[] girlsCombine = new String[3];
    public static String[] boys;
    public static String[] boysCombine = new String[2];
    public static List<String> allGirls = new ArrayList<>();
    public static List<String> allBoys = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        girls = br.readLine().split(", ");
        boys = br.readLine().split(", ");

        combineGirls(0, 0);
        combineBoys(0, 0);

        StringBuilder sb = new StringBuilder();
        for (String girls : allGirls) {
            for (String boys : allBoys) {
                sb.append(girls).append(", ").append(boys).append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString().trim());
    }

    private static void combineGirls(int index, int start) {
        if (index == girlsCombine.length) {
            allGirls.add(String.join(", ", girlsCombine));
        } else {
            for (int i = start; i < girls.length; i++) {
                girlsCombine[index] = girls[i];
                combineGirls(index + 1, i + 1);
            }
        }
    }

    private static void combineBoys(int index, int start) {
        if (index == boysCombine.length) {
            allBoys.add(String.join(", ", boysCombine));
        } else {
            for (int i = start; i < boys.length; i++) {
                boysCombine[index] = boys[i];
                combineBoys(index + 1, i + 1);
            }
        }
    }
}
