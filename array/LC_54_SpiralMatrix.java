package array;

import java.util.*;

public class LC_54_SpiralMatrix {

    /*
     * TC: O(m * n) - where m is the number of rows and n is the number of columns in the matrix
     * SC: O(1) - we are using a list to store the output, but it does not count towards space complexity
     */

    public static List<Integer> spiralOrder(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> output = new ArrayList<>();

        int left = 0; // start of col
        int top = 0; // start of row

        int right = n - 1; // end of col
        int bottom = m - 1; // end of row

        int total = m * n;

        while (total > 0) {

            for (int i = left; i <= right && total > 0; i++) {
                output.add(matrix[top][i]);
                total--;
            }
            top++;

            for (int i = top; i <= bottom && total > 0; i++) {
                output.add(matrix[i][right]);
                total--;
            }
            right--;

            for (int i = right; i >= left && total > 0; i--) {
                output.add(matrix[bottom][i]);
                total--;
            }
            bottom--;

            for (int i = bottom; i >= top && total > 0; i--) {
                output.add(matrix[i][left]);
                total--;
            }
            left++;
        }

        return output;
    }

    public static void main(String[] args) {

        // Test Case 1: Standard matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Spiral order: " + spiralOrder(matrix1)); // [1,2,3,6,9,8,7,4,5]

        // Test Case 2: Single row
        int[][] matrix2 = {
            {1, 2, 3, 4}
        };
        System.out.println("Spiral order: " + spiralOrder(matrix2)); // [1,2,3,4]

        // Test Case 3: Single column
        int[][] matrix3 = {
            {1},
            {2},
            {3}
        };
        System.out.println("Spiral order: " + spiralOrder(matrix3)); // [1,2,3]

        // Test Case 4: 1x1 matrix
        int[][] matrix4 = {
            {42}
        };
        System.out.println("Spiral order: " + spiralOrder(matrix4)); // [42]

        // Test Case 5: Rectangular matrix (more rows)
        int[][] matrix5 = {
            {1, 2},
            {3, 4},
            {5, 6}
        };
        System.out.println("Spiral order: " + spiralOrder(matrix5)); // [1,2,4,6,5,3]

        // Test Case 6: Rectangular matrix (more columns)
        int[][] matrix6 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        System.out.println("Spiral order: " + spiralOrder(matrix6)); // [1,2,3,4,8,7,6,5]
    }
}
