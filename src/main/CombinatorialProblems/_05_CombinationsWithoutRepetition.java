package CombinatorialProblems;

import java.util.Scanner;

public class _05_CombinationsWithoutRepetition {
    static String[] elements;
    static String[] variations;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        elements = sc.nextLine().split("\\s+");
        int n = sc.nextInt();
        variations = new String[n];

        combinations(0, 0);
    }

    private static void combinations(int index, int start) {
        if (index == variations.length) {
            System.out.println(String.join(" ", variations));
            return;
        }

        for (int i = start; i < elements.length; i++) {
            variations[index] = elements[i];
            combinations(index + 1, i + 1);
        }
    }
}
