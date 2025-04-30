package graph;

import java.util.*;

public class LC_994_RottingOranges {

    public static int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        // Count fresh oranges and enqueue all rotten ones, multi-source BFS
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    fresh++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        if (fresh == 0) {
            return 0; // No fresh oranges to begin with
        }

        int minutes = 0;
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean newRottingHappened = false;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        fresh--;
                        newRottingHappened = true;
                    }
                }
            }

            if (newRottingHappened) {
                minutes++;
            }
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        // Test case 1: Standard case
        int[][] grid1 = {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1}
        };
        System.out.println(orangesRotting(grid1)); // Expected: 4

        // Test case 2: All already rotten or empty
        int[][] grid2 = {
            {0, 2}
        };
        System.out.println(orangesRotting(grid2)); // Expected: 0

        // Test case 3: Impossible to rot all
        int[][] grid3 = {
            {2, 1, 1},
            {0, 1, 1},
            {1, 0, 1}
        };
        System.out.println(orangesRotting(grid3)); // Expected: -1

        // Edge case: Only fresh oranges, no rotten ones
        int[][] grid4 = {
            {1, 1, 1}
        };
        System.out.println(orangesRotting(grid4)); // Expected: -1

        // Edge case: Single cell fresh
        int[][] grid5 = {
            {1}
        };
        System.out.println(orangesRotting(grid5)); // Expected: -1

        // Edge case: Single cell rotten
        int[][] grid6 = {
            {2}
        };
        System.out.println(orangesRotting(grid6)); // Expected: 0
    }
}
