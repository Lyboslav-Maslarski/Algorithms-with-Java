package ExamPreparation.Exam24July2022;

import java.util.Scanner;

public class Stairs {
    public static long[] memory;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int steps = Integer.parseInt(sc.nextLine());
        memory = new long[steps + 1];

        System.out.println(permute(steps));
    }

    private static long permute(int steps) {
        if (steps == 1) {
            return 1;
        }
        if (steps == 2) {
            return 2;
        }
        if (memory[steps] != 0) {
            return memory[steps];
        }
        return memory[steps] = permute(steps - 1) + permute(steps - 2);
    }
}
