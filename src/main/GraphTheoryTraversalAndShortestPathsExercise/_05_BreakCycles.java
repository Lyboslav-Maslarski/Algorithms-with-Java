package GraphTheoryTraversalAndShortestPathsExercise;

import java.util.*;
import java.util.stream.Collectors;

public class _05_BreakCycles {
    public static Map<String, List<String>> graph = new TreeMap<>();
    public static List<String> edgesToRemove = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.trim().equals("")) {
                break;
            }

            String[] tokens = line.split(" -> ");
            String node = tokens[0];

            graph.putIfAbsent(node, new ArrayList<>());

            List<String> children = Arrays.stream(tokens[1].split(" ")).collect(Collectors.toList());
            graph.get(node).addAll(children);
        }

        graph.values().forEach(Collections::sort);

        for (String source : graph.keySet()) {
            List<String> destinations = new ArrayList<>(graph.get(source));

            for (String destination : destinations) {
                graph.get(source).remove(destination);
                graph.get(destination).remove(source);

                boolean hasCycle = hasCycle(source, destination);

                if (hasCycle) {
                    edgesToRemove.add(String.format("%s - %s", source, destination));
                } else {
                    graph.get(source).add(destination);
                    graph.get(destination).remove(source);
                }
            }
        }

        System.out.println("Edges to remove: " + edgesToRemove.size());
        edgesToRemove.forEach(System.out::println);
    }

    private static boolean hasCycle(String source, String destination) {
        Deque<String> deque = new ArrayDeque<>();
        List<String> visited = new ArrayList<>();

        deque.offer(source);
        visited.add(source);

        while (!deque.isEmpty()) {
            String node = deque.poll();
            if (destination.equals(node)) {
                return true;
            }

            for (String child : graph.get(node)) {
                if (!visited.contains(child)) {
                    deque.offer(child);
                    visited.add(child);
                }
            }
        }
        return false;
    }
}
