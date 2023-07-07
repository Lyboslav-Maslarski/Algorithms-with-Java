package RecursionAndBacktracking;

import java.util.Scanner;

public class RecursiveDrawing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printFigure(n);
    }

    private static void printFigure(int n) {
        if (n == 0) {
            return;
        }
        printLineOfChars('*', n);
        printFigure(n - 1);
        printLineOfChars('#', n);
    }

    private static void printLineOfChars(char c, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
        System.out.println();
    }
}
