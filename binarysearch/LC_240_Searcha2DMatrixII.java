package binarysearch;

public class LC_240_Searcha2DMatrixII {

    /*
     * TC: O(m + n) - where m is the number of rows and n is the number of columns
     * SC: O(1) - no extra space used for the algorithm
     */
    
    public static boolean searchMatrix(int[][] matrix, int target) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        int r = 0;
        int c = cols - 1;

        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] > target) {
                c--; // move left
            } else {
                r++; // move down
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[][] matrix1 = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        System.out.println("Search 5: " + searchMatrix(matrix1, 5));  // Expected: true
        System.out.println("Search 20: " + searchMatrix(matrix1, 20)); // Expected: false

        // Test Case 2: Single row
        int[][] matrix2 = {
            {1, 3, 5, 7, 9}
        };
        System.out.println("Search 7: " + searchMatrix(matrix2, 7));  // Expected: true

        // Test Case 3: Single column
        int[][] matrix3 = {
            {1},
            {2},
            {3},
            {4}
        };
        System.out.println("Search 2: " + searchMatrix(matrix3, 2));  // Expected: true

        // Test Case 4: Element not found
        int[][] matrix4 = {
            {1, 2},
            {3, 4}
        };
        System.out.println("Search 0: " + searchMatrix(matrix4, 0));  // Expected: false
    }
}
