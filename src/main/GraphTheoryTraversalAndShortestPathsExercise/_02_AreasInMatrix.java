package GraphTheoryTraversalAndShortestPathsExercise;

import java.util.*;

public class _02_AreasInMatrix {
    public static boolean[] visitedNode;

    public static class Edge {
        int[] source;
        int[] destination;

        public Edge(int sRow, int sCol) {
            this.source = new int[]{sRow, sCol};
        }

        public void setDestination(int dRow, int dCol) {
            this.destination = new int[]{dRow, dCol};
        }
    }

    public static char[][] matrix;
    public static boolean[][] visited;
    public static List<Edge> graph = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = Integer.parseInt(sc.nextLine());
        matrix = new char[rows][];
        visited = new boolean[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().toCharArray();
            visited[i] = new boolean[matrix[i].length];
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!visited[i][j]) {
                    dfs(i, j, matrix[i][j]);
                }
            }
        }

        visitedNode = new boolean[graph.size()];

        Map<Character, Integer> areas = new TreeMap<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visitedNode[i]) {
                Edge edge = graph.get(i);
                char key = matrix[edge.source[0]][edge.source[1]];
                areas.putIfAbsent(key, 0);
                areas.put(key, areas.get(key) + 1);
                bfs(i);
            }
        }

        System.out.println("Areas: " + areas.values().stream().mapToInt(e -> e).sum());

        for (Map.Entry<Character, Integer> entry : areas.entrySet()) {
            System.out.printf("Letter '%c' -> %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static void bfs(int source) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(source);

        visitedNode[source] = true;

        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            Edge edge = graph.get(node);
            if (edge.destination != null) {
                visitedNode[node + 1] = true;
                deque.offer(node + 1);
            }
        }
    }

    private static void dfs(int row, int col, char symbol) {
        visited[row][col] = true;

        Edge edge = new Edge(row, col);
        graph.add(edge);

        if (isInBounds(row, col + 1) && !visited[row][col + 1] && matrix[row][col + 1] == symbol) {
            graph.get(graph.size() - 1).setDestination(row, col + 1);
            dfs(row, col + 1, symbol);
        }
        if (isInBounds(row, col - 1) && !visited[row][col - 1] && matrix[row][col - 1] == symbol) {
            graph.get(graph.size() - 1).setDestination(row, col - 1);
            dfs(row, col - 1, symbol);
        }
        if (isInBounds(row + 1, col) && !visited[row + 1][col] && matrix[row + 1][col] == symbol) {
            graph.get(graph.size() - 1).setDestination(row + 1, col);
            dfs(row + 1, col, symbol);
        }
        if (isInBounds(row - 1, col) && !visited[row - 1][col] && matrix[row - 1][col] == symbol) {
            graph.get(graph.size() - 1).setDestination(row - 1, col);
            dfs(row - 1, col, symbol);
        }
    }

    private static boolean isInBounds(int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}