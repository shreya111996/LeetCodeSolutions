package dynamicprogramming;



public class LC_931_MinimumFallingPathSum {

    /**
     * TC: O(N^2)
     * SC: O(N^2) for memoization
     * 
     * The function uses recursion with memoization to find the minimum falling path sum.
     * It explores three possible paths from the current cell: directly below, left diagonal,
     * and right diagonal, and returns the minimum sum.
     */

    static Integer[][] memo;

    private static int solve(int[][] matrix, int row, int col) {
        if (col < 0 || col >= matrix[0].length) {
            return Integer.MAX_VALUE;
        }

        if (row == matrix.length - 1) { // base case: last row
            return matrix[row][col];
        }

        if (memo[row][col] != null) {
            return memo[row][col];
        }

        int leftDiag = solve(matrix, row + 1, col - 1);
        int rightDiag = solve(matrix, row + 1, col + 1);
        int below = solve(matrix, row + 1, col);

        memo[row][col] = Math.min(leftDiag, Math.min(rightDiag, below)) + matrix[row][col];
        return memo[row][col];
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new Integer[n][n];
        int minPathSum = Integer.MAX_VALUE;

        for (int col = 0; col < n; col++) {
            minPathSum = Math.min(minPathSum, solve(matrix, 0, col));
        }

        return minPathSum;
    }

    public static void main(String[] args) {

        int[][] matrix1 = {
            {2, 1, 3},
            {6, 5, 4},
            {7, 8, 9}
        };
        System.out.println("Test 1 (Expected 13): " + minFallingPathSum(matrix1));

        int[][] matrix2 = {
            {-19, 57},
            {-40, -5}
        };
        System.out.println("Test 2 (Expected -59): " + minFallingPathSum(matrix2));

        int[][] matrix3 = {
            {100}
        };
        System.out.println("Edge Test (Expected 100): " + minFallingPathSum(matrix3));

        int[][] matrix4 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };
        System.out.println("Test 4 (Expected 22): " + minFallingPathSum(matrix4));
    }

}
