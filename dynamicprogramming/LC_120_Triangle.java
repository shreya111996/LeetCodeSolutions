package dynamicprogramming;

import java.util.*;

public class LC_120_Triangle {

    /* 
     * TC: O(N^2) where N is the number of rows
     * SC: O(N^2) for memoization
    */

    // Top-down memoized recursive solution 
    static Integer[][] memo;

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        memo = new Integer[n][n];
        return solve(0, 0, triangle);
    }

    private static int solve(int row, int col, List<List<Integer>> triangle) {
        if (memo[row][col] != null) return memo[row][col];
        int path = triangle.get(row).get(col);
        if (row < triangle.size() - 1) {
            path += Math.min(
                    solve(row + 1, col, triangle),
                    solve(row + 1, col + 1, triangle));
        }
        memo[row][col] = path;
        return path;
    }

    // Bottom-up dynamic programming solution
    // public static int minimumTotal(List<List<Integer>> triangle) {
    //     int n = triangle.size();
    //     int[] dp = new int[n];

    //     for (int i = 0; i < n; i++) {
    //         dp[i] = triangle.get(n - 1).get(i); // last row
    //     }

    //     for (int row = n - 2; row >= 0; row--) {
    //         for (int col = 0; col <= row; col++) {
    //             dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
    //         }
    //     }

    //     return dp[0];
    // }

    public static void main(String[] args) {
        List<List<Integer>> triangle1 = new ArrayList<>();
        triangle1.add(Arrays.asList(2));
        triangle1.add(Arrays.asList(3, 4));
        triangle1.add(Arrays.asList(6, 5, 7));
        triangle1.add(Arrays.asList(4, 1, 8, 3));

        List<List<Integer>> triangle2 = new ArrayList<>();
        triangle2.add(Arrays.asList(-10));

        List<List<Integer>> triangle3 = new ArrayList<>();
        triangle3.add(Arrays.asList(1));
        triangle3.add(Arrays.asList(2, 3));

        System.out.println("Minimum Total Path (Test 1): " + minimumTotal(triangle1)); // Expected: 11
        System.out.println("Minimum Total Path (Test 2): " + minimumTotal(triangle2)); // Expected: -10
        System.out.println("Minimum Total Path (Test 3): " + minimumTotal(triangle3)); // Expected: 3
    }
}
