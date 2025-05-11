package graph;

import java.util.*;

public class LC_399_EvaluateDivision {
    
    /*
     * TC: O(n + e) - where n is the number of nodes and e is the number of edges
     * SC: O(n)
     */

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, List<Pair<String, Double>>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());

            graph.get(u).add(new Pair<>(v, val));
            graph.get(v).add(new Pair<>(u, 1.0 / val));
        }

        double[] result = new double[queries.size()];
        int idx = 0;

        for (List<String> query : queries) {
            String src = query.get(0);
            String dest = query.get(1);

            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                result[idx++] = -1.0;
            } else {
                Set<String> visited = new HashSet<>();
                result[idx++] = dfs(graph, src, dest, visited, 1.0);
            }
        }

        return result;
    }

    private static double dfs(Map<String, List<Pair<String, Double>>> graph, String src, String dest,
                              Set<String> visited, double product) {

        if (visited.contains(src)) return -1.0;
        if (src.equals(dest)) return product;

        visited.add(src);

        for (Pair<String, Double> neighbor : graph.get(src)) {
            double res = dfs(graph, neighbor.getKey(), dest, visited, product * neighbor.getValue());
            if (res != -1.0) return res;
        }

        return -1.0;
    }

    public static void main(String[] args) {

        List<List<String>> equations = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("b", "c")
        );
        double[] values = {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(
            Arrays.asList("a", "c"),
            Arrays.asList("b", "a"),
            Arrays.asList("a", "e"),
            Arrays.asList("a", "a"),
            Arrays.asList("x", "x")
        );

        double[] result = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(result));  // Expected: [6.0, 0.5, -1.0, 1.0, -1.0]
    }

    

    // Custom Pair class since Java doesn't have javafx.util.Pair or kotlin.Pair by default
    static class Pair<K, V> {
        private final K key;
        private final V value;
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
    }
}
