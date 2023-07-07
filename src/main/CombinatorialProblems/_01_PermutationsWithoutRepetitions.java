package CombinatorialProblems;

import java.util.Scanner;

public class _01_PermutationsWithoutRepetitions {
    static String[] elements;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        elements = sc.nextLine().split("\\s+");

        permute(0);
    }

    private static void permute(int index) {
        if (index == elements.length) {
            System.out.println(String.join(" ", elements));
            return;
        }

        permute(index + 1);

        for (int i = index + 1; i < elements.length; i++) {
            swap(index, i);
            permute(index + 1);
            swap(index, i);
        }
    }

    private static void swap(int index, int i) {
        String temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }
}
