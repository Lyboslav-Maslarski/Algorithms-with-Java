package GraphTheoryTraversalAndShortestPathsExercise;

import java.util.*;

public class _03_CyclesInGraph {
    public static Map<String, List<String>> graph = new HashMap<>();
    public static String source;
    public static Set<String> visited = new HashSet<>();
    public static Set<String> cycles = new HashSet<>();

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
            graph.putIfAbsent(tokens[1], new ArrayList<>());
            graph.get(key).add(tokens[1]);

            line = sc.nextLine();
        }

        try {
            dfs(source);
            if (graph.size() != visited.size()) {
                System.out.println("Acyclic: No");
            } else {
                System.out.println("Acyclic: Yes");
            }
        } catch (IllegalStateException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void dfs(String source) {
        if (cycles.contains(source)) {
            throw new IllegalStateException("Acyclic: No");
        }
        if (visited.contains(source)) {
            return;
        }

        cycles.add(source);
        visited.add(source);

        List<String> children = graph.get(source);

        for (String child : children) {
            dfs(child);
        }
        cycles.remove(source);
    }
}
