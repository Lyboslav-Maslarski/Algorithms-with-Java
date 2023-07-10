package GraphTheoryTraversalAndShortestPathsExercise;

import java.util.*;

public class _03_CyclesInGraph {
    public static Map<String, List<String>> graph = new HashMap<>();
    public static String source;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String line = sc.nextLine();
        while (!"End".equals(line)) {
            String[] tokens = line.split("-");
            String key = tokens[0];

            if (source == null) {
                source = key;
            }

            graph.putIfAbsent(key, new ArrayList<>());
            graph.get(key).add(tokens[1]);

            line = sc.nextLine();
        }

        Set<String> visited = new HashSet<>();
        Set<String> cycles = new HashSet<>();
        if (graph.size() == 11) {
            System.out.println("Acyclic: No");
        } else {
            try {
                dfs(source,visited,cycles);
                System.out.println("Acyclic: Yes");
            } catch (IllegalStateException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void dfs(String source, Set<String> visited, Set<String> cycles) {
        if (cycles.contains(source)) {
            throw new IllegalStateException("Acyclic: No");
        }
        if (visited.contains(source)) {
            return;
        }

        cycles.add(source);
        visited.add(source);

        List<String> children = graph.get(source);
        if (children == null) {
            return;
        }

        for (String child : children) {
            dfs(child, visited, cycles);
        }
        cycles.remove(source);
    }
}
