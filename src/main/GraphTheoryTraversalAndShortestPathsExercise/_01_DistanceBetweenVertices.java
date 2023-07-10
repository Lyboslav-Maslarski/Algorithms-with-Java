package GraphTheoryTraversalAndShortestPathsExercise;

import java.util.*;

public class _01_DistanceBetweenVertices {
    public static int[][] graph;
    public static Map<Integer, Integer> indexMapper = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nodes = Integer.parseInt(sc.nextLine());
        int pairs = Integer.parseInt(sc.nextLine());

        graph = new int[nodes + 1][];

        for (int i = 1; i <= nodes; i++) {
            String[] edges = sc.nextLine().split(":");
            int vertex = Integer.parseInt(edges[0]);
            indexMapper.put(vertex, i);

            if (edges.length == 1) {
                graph[i] = new int[0];
            } else {
                graph[i] = Arrays.stream(edges[1].split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        }

        while (pairs-- > 0) {
            int[] relations = Arrays.stream(sc.nextLine().split("-"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int start = relations[0];
            int end = relations[1];

            System.out.printf("{%d, %d} -> ", start, end);

            int[] prev = new int[graph.length];
            Arrays.fill(prev, -1);

            bfs(graph, indexMapper.get(start), indexMapper.get(end), prev);

            List<Integer> path = new ArrayList<>();

            int parent = prev[indexMapper.get(end)];

            while (parent != -1) {
                path.add(parent);
                parent = prev[parent];
            }

            int size = path.isEmpty() ? -1 : path.size();
            System.out.println(size);
        }
    }

    private static void bfs(int[][] graph, Integer start, Integer end, int[] prev) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.offer(start);
        boolean[] visited = new boolean[graph.length + 1];
        visited[start] = true;

        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            if (Objects.equals(node, end)) {
                return;
            }
            for (int i = 0; i < graph[node].length; i++) {
                Integer child = indexMapper.get(graph[node][i]);
                if (!visited[child]) {
                    prev[child] = node;
                    visited[child] = true;
                    deque.offer(child);
                }
            }
        }
        prev[start] = -1;
    }
}
