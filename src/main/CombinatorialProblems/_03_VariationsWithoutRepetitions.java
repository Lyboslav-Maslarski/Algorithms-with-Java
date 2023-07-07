package CombinatorialProblems;

import java.util.Scanner;

public class _03_VariationsWithoutRepetitions {
    static String[] elements;
    static String[] variations;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        elements = sc.nextLine().split("\\s+");
        int n = sc.nextInt();
        variations = new String[n];

        used = new boolean[elements.length];

        variate(0);
    }

    private static void variate(int index) {
        if (index == variations.length) {
            System.out.println(String.join(" ", variations));
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!used[i]) {
                used[i] = true;
                variations[index] = elements[i];
                variate(index + 1);
                used[i] = false;
            }
        }
    }
}
