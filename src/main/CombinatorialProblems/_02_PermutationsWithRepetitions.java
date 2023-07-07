package CombinatorialProblems;

import java.util.Scanner;

public class _02_PermutationsWithRepetitions {
    static String[] elements;
    static String[] currentElements;
    static boolean[] isUsed;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        elements = sc.nextLine().split("\\s+");
        currentElements = new String[elements.length];
        isUsed = new boolean[elements.length];

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            printResult(currentElements);
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                currentElements[index] = elements[i];
                permute(index + 1);
                isUsed[i] = false;
            }
        }
    }

    private static void printResult(String[] currentElements) {
        System.out.println(String.join(" ", currentElements));
    }
}
