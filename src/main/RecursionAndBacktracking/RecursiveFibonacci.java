package RecursionAndBacktracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RecursiveFibonacci {
    static Map<Integer, Long> memory = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibonacci(n));
    }

    private static long fibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        if (memory.containsKey(n)) {
            return memory.get(n);
        }
        memory.put(n, fibonacci(n - 1) + fibonacci(n - 2));
        return memory.get(n);
    }
}
