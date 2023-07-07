package CombinatorialProblems;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_PermutationsWithRepetitions {
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
        Set<String> permutes = new HashSet<>();
        permutes.add(elements[index]);
        for (int i = index + 1; i < elements.length; i++) {
            if (!permutes.contains(elements[i])) {
                swap(index, i);
                permute(index + 1);
                swap(index, i);
                permutes.add(elements[i]);
            }
        }
    }

    private static void swap(int index, int i) {
        String temp = elements[index];
        elements[index] = elements[i];
        elements[i] = temp;
    }
}
