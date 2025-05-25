package array;

import java.util.Arrays;

public class LC_59_SpiralMatrixII {

    /*
     * TC: O(n^2) - we fill n^2 elements in the matrix
     * SC: O(1) - we use a output fixed-size matrix of size n x n, but it's not counted as extra space
     */

    public static int[][] generateMatrix(int n) {

        int left = 0;
        int top = 0;
        int bottom = n - 1;
        int right = n - 1;

        int num = 1;
        int[][] matrix = new int[n][n];

        while (num <= (n * n)) {

            for (int i = left; i <= right && num <= (n * n); i++) {
                matrix[top][i] = num++;
            }
            top++;

            for (int i = top; i <= bottom && num <= (n * n); i++) {
                matrix[i][right] = num++;
            }
            right--;

            for (int i = right; i >= left && num <= (n * n); i--) {
                matrix[bottom][i] = num++;
            }
            bottom--;

            for (int i = bottom; i >= top && num <= (n * n); i--) {
                matrix[i][left] = num++;
            }
            left++;

        }

        return matrix;
    }

    public static void main(String[] args) {

        // Helper to print matrices
        java.util.function.Consumer<int[][]> printMatrix = mat -> {
            for (int[] row : mat) {
                System.out.println(Arrays.toString(row));
            }
            System.out.println();
        };

        // Test Case 1: n = 1
        System.out.println("Spiral Matrix for n = 1:");
        printMatrix.accept(generateMatrix(1));

        // Test Case 2: n = 2
        System.out.println("Spiral Matrix for n = 2:");
        printMatrix.accept(generateMatrix(2));

        // Test Case 3: n = 3
        System.out.println("Spiral Matrix for n = 3:");
        printMatrix.accept(generateMatrix(3));

        // Test Case 4: n = 4
        System.out.println("Spiral Matrix for n = 4:");
        printMatrix.accept(generateMatrix(4));

        // Test Case 5: n = 5
        System.out.println("Spiral Matrix for n = 5:");
        printMatrix.accept(generateMatrix(5));
    }
}
