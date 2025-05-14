package monotonicstack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_1765_MapofHighestPeak {

    /*
     * TC: O(m * n) - where m is the number of rows and n is the number of columns
     * SC: O(m * n) - for the output matrix and visited array
     * Space complexity can be reduced to O(1) if we fill the output matrix with a negative value
     * instead of using a separate visited array.
     * However, this would require additional checks to ensure we don't overwrite valid values.
     */

    public static int[][] highestPeak(int[][] isWater) {

        Queue<int[]> q = new LinkedList<>();
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] output = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        // Initialize with all water cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                    output[i][j] = 0;
                }
            }
        }

        int[] drow = {1, 0, -1, 0};
        int[] dcol = {0, 1, 0, -1};

        // Multi-source BFS
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int i = 0; i < 4; i++) {
                int newRow = currRow + drow[i];
                int newCol = currCol + dcol[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    q.offer(new int[]{newRow, newCol});
                    output[newRow][newCol] = output[currRow][currCol] + 1;
                    visited[newRow][newCol] = true;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] isWater1 = {
            {0, 1},
            {0, 0}
        };
        printMatrix(highestPeak(isWater1)); // Expected heights: [[1,0],[2,1]]

        int[][] isWater2 = {
            {0, 0, 1},
            {0, 0, 0},
            {1, 0, 0}
        };
        printMatrix(highestPeak(isWater2)); // Multi-source BFS

        int[][] isWater3 = {
            {1}
        };
        printMatrix(highestPeak(isWater3)); // [[0]]

        int[][] isWater4 = {
            {0}
        };
        printMatrix(highestPeak(isWater4)); // Only land, no water — behavior may vary

        int[][] isWater5 = {
            {0, 0},
            {0, 0}
        };
        printMatrix(highestPeak(isWater5)); // No water at all — result will be all 0s as nothing is marked
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
