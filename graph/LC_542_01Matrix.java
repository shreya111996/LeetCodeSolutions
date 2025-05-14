package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC_542_01Matrix {

    /*
     * TC: O(m * n) - where m is the number of rows and n is the number of columns
     * SC: O(m * n) - for the output matrix and visited array
     * Space complexity can be reduced to O(1) if we fill the output matrix with a negative value
     * instead of using a separate visited array.
     * However, this would require additional checks to ensure we don't overwrite valid values.
     */

    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] output = new int[m][n];
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[] drow = new int[]{1, 0, -1, 0};
        int[] dcol = new int[]{0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            for (int i = 0; i < 4; i++) {
                int newRow = currRow + drow[i];
                int newCol = currCol + dcol[i];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n &&
                    !visited[newRow][newCol]) {
                    
                    q.offer(new int[]{newRow, newCol});
                    output[newRow][newCol] = output[currRow][currCol] + 1;
                    visited[newRow][newCol] = true;
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };
        printMatrix(updateMatrix(mat1));  // Expected: [[0,0,0],[0,1,0],[1,2,1]]

        int[][] mat2 = {
            {0, 1, 1},
            {1, 1, 1},
            {1, 1, 0}
        };
        printMatrix(updateMatrix(mat2));  // Expected: [[0,1,2],[1,2,1],[2,1,0]]

        int[][] mat3 = {
            {1}
        };
        printMatrix(updateMatrix(mat3));  // Expected: [[0]] (no 0 exists, but depends on problem constraints)

        int[][] mat4 = {
            {0}
        };
        printMatrix(updateMatrix(mat4));  // Expected: [[0]]

        int[][] mat5 = {
            {1, 1},
            {1, 1}
        };
        printMatrix(updateMatrix(mat5));  // Expected: depends on spec — likely all 0's unless unreachable
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
    }
}
