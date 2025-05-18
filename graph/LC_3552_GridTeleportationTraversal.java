package graph;

import java.util.*;

public class LC_3552_GridTeleportationTraversal {

    /*
     * TC: O(M * N + K) - where M is the number of rows, N is the number of columns,
     * and K is the number of teleportation points.
     * 
     * SC: O(M * N + K) - for the distance array and mapping.
     */

    public int minMoves(String[] matrix) {
        int m = matrix.length;
        int n = matrix[0].length();

        Map<Character, List<int[]>> mapping = new HashMap<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                char ch = matrix[row].charAt(col);
                if (Character.isLetter(ch)) {
                    mapping.computeIfAbsent(ch, k -> new ArrayList<>())
                            .add(new int[] { row, col });

                    /*
                     * if (!mapping.containsKey(ch)) {
                     * mapping.put(ch, new ArrayList<>());
                     * }
                     * 
                     * mapping.get(ch).add(new int[] { row, col });
                     */
                }
            }
        }

        int[][] dist = new int[m][n];
        for (int[] rowArr : dist) {
            Arrays.fill(rowArr, Integer.MAX_VALUE);
        }
        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = 0;
        dq.add(new int[] { 0, 0 });

        Set<Character> used = new HashSet<>();
        int[] dr = { 1, 0, -1, 0 };
        int[] dc = { 0, 1, 0, -1 };

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0];
            int c = cur[1];
            int d = dist[r][c];

            if (r == m - 1 && c == n - 1) {
                return d;
            }

            // zero-cost teleport
            char ch = matrix[r].charAt(c);
            if (Character.isLetter(ch) && used.add(ch)) {
                for (int[] p : mapping.getOrDefault(ch, Collections.emptyList())) {
                    int rr = p[0], cc = p[1];
                    if (dist[rr][cc] > d) {
                        dist[rr][cc] = d;
                        dq.addFirst(new int[] { rr, cc });
                    }
                }
            }

            // cost-1 moves
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k], nc = c + dc[k];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n
                        && matrix[nr].charAt(nc) != '#'
                        && dist[nr][nc] > d + 1) {
                    dist[nr][nc] = d + 1;
                    dq.addLast(new int[] { nr, nc });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        LC_3552_GridTeleportationTraversal sol = new LC_3552_GridTeleportationTraversal();

        // Test 1: Example from prompt
        String[] matrix1 = { ".A", "CA" };
        System.out.println("Test 1: " + sol.minMoves(matrix1) + " (expected 1)");

        // Test 2: No possible path
        String[] matrix2 = { ".#", "#." };
        System.out.println("Test 2: " + sol.minMoves(matrix2) + " (expected -1)");

        // Test 3: Single cell start=end
        String[] matrix3 = { "." };
        System.out.println("Test 3: " + sol.minMoves(matrix3) + " (expected 0)");

        // Test 4: Simple 2x2 grid without teleport
        String[] matrix4 = { "..", ".." };
        System.out.println("Test 4: " + sol.minMoves(matrix4) + " (expected 2)");

        // Test 5: Teleport directly to end
        String[] matrix6 = { "A..", ".#.", "..A" };
        System.out.println("Test 6: " + sol.minMoves(matrix6) + " (expected 0)");
    }
}
