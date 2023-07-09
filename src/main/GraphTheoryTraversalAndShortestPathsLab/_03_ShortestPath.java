package GraphTheoryTraversalAndShortestPathsLab;

import java.util.*;

public class _03_ShortestPath {
    public static boolean[] visited;
    public static int[] prevNodes;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        visited = new boolean[n + 1];
        prevNodes = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        int edges = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < edges; i++) {
            int[] parts = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            graph.get(parts[0]).add(parts[1]);
        }

        int start = Integer.parseInt(sc.nextLine());
        int end = Integer.parseInt(sc.nextLine());

        bfs(start, end, graph);

        List<Integer> path = new ArrayList<>();
        path.add(end);
        int prevNode = prevNodes[end];
        while (prevNode != 0) {
            path.add(prevNode);
            prevNode = prevNodes[prevNode];
        }

        System.out.println("Shortest path length is: " + (path.size() - 1));
        Collections.reverse(path);
        path.forEach(el -> System.out.print(el + " "));
    }

    private static void bfs(int start, int end, List<List<Integer>> graph) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(start);
        visited[start] = true;

        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            if (node == end) {
                return;
            }
            for (Integer child : graph.get(node)) {
                if (!visited[child]) {
                    visited[child] = true;
                    prevNodes[child] = node;
                    deque.offer(child);
                }
            }
        }
    }
}
