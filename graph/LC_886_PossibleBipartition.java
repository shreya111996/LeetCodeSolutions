package graph;

import java.util.*;

public class LC_886_PossibleBipartition {

    /*
     * TC: O(n + e) - where n is the number of nodes and e is the number of edges
     * SC: O(n)
     */

    // Union-Find (Disjoint Set Union) Approach

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        
        int[] parent = new int[n + 1];
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
            adjList.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            adjList.get(dislike[0]).add(dislike[1]);
            adjList.get(dislike[1]).add(dislike[0]);
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> neighbors = adjList.get(i);
            for (int neigh : neighbors) {
                if (find(i, parent) == find(neigh, parent)) {
                    return false;
                }
                union(neighbors.get(0), neigh, parent);
            }
        }

        return true;
    }

    private static int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    private static void union(int x, int y, int[] parent) {
        int p = find(x, parent);
        int q = find(y, parent);
        parent[p] = q;
    }

    public static void main(String[] args) {
        // Test 1: Example from LeetCode
        int[][] dislikes1 = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(possibleBipartition(4, dislikes1)); // true

        // Test 2: Cannot bipartition
        int[][] dislikes2 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(possibleBipartition(3, dislikes2)); // false

        // Test 3: No dislikes
        int[][] dislikes3 = {};
        System.out.println(possibleBipartition(1, dislikes3)); // true

        // Test 4: Single conflict loop
        int[][] dislikes4 = {{1, 2}, {2, 3}, {3, 4}, {4, 1}};
        System.out.println(possibleBipartition(4, dislikes4)); // false

        // Test 5: Multiple disjoint sets
        int[][] dislikes5 = {{1, 2}, {3, 4}};
        System.out.println(possibleBipartition(4, dislikes5)); // true
    }

    /*
    // BFS Coloring Approach (Graph is Bipartite if we can 2-color it)
    public boolean possibleBipartition(int n, int[][] dislikes) {

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            adjList.get(dislike[0]).add(dislike[1]);
            adjList.get(dislike[1]).add(dislike[0]);
        }

        int[] color = new int[n + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {
            if (color[i] == -1) {
                if (!bfs(color, i, adjList)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean bfs(int[] color, int src, List<List<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        color[src] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neigh : adjList.get(curr)) {
                if (color[curr] == color[neigh]) {
                    return false;
                }
                if (color[neigh] == -1) {
                    color[neigh] = 1 - color[curr];
                    q.add(neigh);
                }
            }
        }
        return true;
    }
    */
}
