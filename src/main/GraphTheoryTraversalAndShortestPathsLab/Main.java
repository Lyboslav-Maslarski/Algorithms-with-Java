package GraphTheoryTraversalAndShortestPathsLab;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            if (line.trim().equals("")) {
                graph.add(new ArrayList<>());
            } else {
                List<Integer> list = Arrays.stream(line.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
                graph.add(list);
            }
        }

        List<Deque<Integer>> connectedComponents = getConnectedComponents(graph);

        for (Deque<Integer> component : connectedComponents) {
            System.out.print("Connected component: ");
            for (Integer integer : component) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    public static List<Deque<Integer>> getConnectedComponents(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        List<Deque<Integer>> result = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                result.add(new ArrayDeque<>());
                dfs(i, graph, visited, result);
            }
        }

        return result;
    }

    private static void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Deque<Integer>> result) {
        if (!visited[node]) {
            visited[node] = true;

            for (Integer child : graph.get(node)) {
                dfs(child, graph, visited, result);
            }
            result.get(result.size() - 1).offer(node);
        }
    }

    public static Collection<String> topSort(Map<String, List<String>> graph) {
        Map<String, Integer> dependencies = getDependencies(graph);

        List<String> sorted = new ArrayList<>();

        while (!graph.isEmpty()) {
            String current = graph.keySet().stream()
                    .filter(k -> dependencies.get(k) == 0)
                    .findFirst().orElse(null);
            if (current == null) {
                break;
            }

            for (String s : graph.get(current)) {
                dependencies.put(s, dependencies.get(s) - 1);
            }

            sorted.add(current);
            graph.remove(current);
        }

        if (!graph.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return sorted;
    }

    private static Map<String, Integer> getDependencies(Map<String, List<String>> graph) {
        Map<String, Integer> dependencies = new LinkedHashMap<>();

        for (Map.Entry<String, List<String>> node : graph.entrySet()) {
            dependencies.putIfAbsent(node.getKey(), 0);
            for (String str : node.getValue()) {
                dependencies.putIfAbsent(str, 0);
                dependencies.put(str, dependencies.get(str) + 1);
            }
        }

        return dependencies;
    }
}
