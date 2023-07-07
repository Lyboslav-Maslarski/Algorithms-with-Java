package RecursionAndBacktracking;

import java.util.Scanner;

public class Generating01Vectors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer[] arr = new Integer[n];

        fillArr(arr, 0);
    }

    private static void fillArr(Integer[] arr, int index) {
        if (index == arr.length) {
            printArr(arr);
            return;
        }
        for (int i = 0; i <= 1; i++) {
            arr[index] = i;
            fillArr(arr, index + 1);
        }
    }

    private static void printArr(Integer[] arr) {
        for (int num : arr) {
            System.out.print(num);
        }
        System.out.println();
    }
}
