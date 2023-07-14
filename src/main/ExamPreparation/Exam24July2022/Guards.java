package ExamPreparation.Exam24July2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Guards {
    public static int[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int nodes = Integer.parseInt(reader.readLine());
        int edges = Integer.parseInt(reader.readLine());

        graph = new int[nodes + 1][nodes + 1];
        visited = new boolean[nodes + 1];

        for (int i = 1; i <= edges; i++) {
            int[] edge = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int from = edge[0];
            int to = edge[1];
            graph[from][to] = 1;
        }

        int start = Integer.parseInt(reader.readLine());

        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            int node = deque.poll();
            for (int i = 0; i < graph[node].length; i++) {
                if (graph[node][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    deque.offer(i);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString().trim());
    }
}
