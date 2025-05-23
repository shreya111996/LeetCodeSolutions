package dynamicprogramming;

public class LC_221_MaximalSquare {

    /*
     * TC: O(m * n) - where m is the number of rows and n is the number of columns in the matrix
     * SC: O(m * n)
     */

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int maxSide = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 1 + Math.min(dp[i][j - 1],
                                        Math.min(dp[i - 1][j - 1], dp[i - 1][j]));
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        return maxSide * maxSide;
    }

    public static void main(String[] args) {
        // Test case 1: Basic case
        char[][] matrix1 = {
            {'1', '0', '1', '0', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '1', '1', '1', '1'},
            {'1', '0', '0', '1', '0'}
        };
        System.out.println("Expected: 4, Output: " + maximalSquare(matrix1));

        // Test case 2: All zeros
        char[][] matrix2 = {
            {'0', '0'},
            {'0', '0'}
        };
        System.out.println("Expected: 0, Output: " + maximalSquare(matrix2));

        // Test case 3: All ones
        char[][] matrix3 = {
            {'1', '1'},
            {'1', '1'}
        };
        System.out.println("Expected: 4, Output: " + maximalSquare(matrix3));

        // Test case 4: Single cell matrix with 1
        char[][] matrix4 = {
            {'1'}
        };
        System.out.println("Expected: 1, Output: " + maximalSquare(matrix4));

        // Test case 5: Single cell matrix with 0
        char[][] matrix5 = {
            {'0'}
        };
        System.out.println("Expected: 0, Output: " + maximalSquare(matrix5));
    }
}
