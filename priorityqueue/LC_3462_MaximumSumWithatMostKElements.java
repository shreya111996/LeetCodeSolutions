package priorityqueue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LC_3462_MaximumSumWithatMostKElements {

    private static void fillRow(int[] row, int limit, PriorityQueue<Integer> pq) {
        // Add the 'min(limit, row.length)' largest elements from the row into the heap
        int count = Math.min(limit, row.length);
        for (int i = row.length - 1; i >= row.length - count; i--) {
            pq.offer(row[i]);
        }
    }
    
    /* 
    * TC: O(n * log(k)) - where n is the total number of elements in the grid
    * SC: O(k) - for the priority queue to store the top k elements
    * k is the number of elements we want to extract from the grid 
     */

    public static long maxSum(int[][] grid, int[] limits, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < limits.length; i++) {
            int[] row = grid[i];
            int limit = limits[i];
            Arrays.sort(row); // Sort each row to access the largest elements
            fillRow(row, limit, pq);
        }

        // Keep only the top k largest values in the heap
        while (pq.size() > k) {
            pq.poll();
        }

        long sum = 0L;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }

    public static void main(String[] args) {
        // Test 1: Example case
        int[][] grid1 = {{1, 2}, {3, 4}};
        int[] limits1 = {1, 2};
        int k1 = 2;
        System.out.println(maxSum(grid1, limits1, k1)); // Expected: 7 (2 from first row, 4 and 3 from second -> top 2 are 4 and 3)

        // Test 2: Limit exceeds row length
        int[][] grid2 = {{1}, {5, 6}};
        int[] limits2 = {1, 3};
        int k2 = 2;
        System.out.println(maxSum(grid2, limits2, k2)); // Expected: 11 (6 and 5)

        // Test 3: k greater than total extracted values
        int[][] grid3 = {{1, 9}, {2}};
        int[] limits3 = {2, 1};
        int k3 = 5;
        System.out.println(maxSum(grid3, limits3, k3)); // Expected: 12 (9, 1, 2)

        // Test 4: All limits are zero
        int[][] grid4 = {{1, 2}, {3, 4}};
        int[] limits4 = {0, 0};
        int k4 = 2;
        System.out.println(maxSum(grid4, limits4, k4)); // Expected: 0

        // Test 5: Single row, single element
        int[][] grid5 = {{10}};
        int[] limits5 = {1};
        int k5 = 1;
        System.out.println(maxSum(grid5, limits5, k5)); // Expected: 10
    }
}
