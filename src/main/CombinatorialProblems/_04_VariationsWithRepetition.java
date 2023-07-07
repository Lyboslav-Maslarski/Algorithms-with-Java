package CombinatorialProblems;

import java.util.Scanner;

public class _04_VariationsWithRepetition {
    static String[] elements;
    static String[] variations;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        elements = sc.nextLine().split("\\s+");
        int n = sc.nextInt();
        variations = new String[n];

        variate(0);
    }

    private static void variate(int index) {
        if (index == variations.length) {
            System.out.println(String.join(" ", variations));
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            variations[index] = elements[i];
            variate(index + 1);
        }
    }
}
