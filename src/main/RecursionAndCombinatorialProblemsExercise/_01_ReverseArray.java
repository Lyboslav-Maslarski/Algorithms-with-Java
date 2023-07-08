package RecursionAndCombinatorialProblemsExercise;

import java.util.Scanner;

public class _01_ReverseArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] elements = sc.nextLine().split("\\s+");

        printArr(elements, elements.length - 1);
    }

    private static void printArr(String[] elements, int index) {
        if (index < 0) {
            return;
        }
        System.out.print(elements[index] + " ");
        printArr(elements, index - 1);
    }
}
