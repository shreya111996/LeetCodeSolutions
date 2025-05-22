package twopointer;

import java.util.Arrays;

public class LC_16_3Sum_Closest {

    /*
     * TC: O(n^2)
     * SC: O(1)
     */

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int prevDiff = Integer.MAX_VALUE;
        int closestSum = 0;

        for (int i = 0; i < nums.length - 2; i++) {

            int first = nums[i];
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {

                int sum = first + nums[j] + nums[k];
                int diff = Math.abs(target - sum);

                if (diff < prevDiff) {
                    closestSum = sum;
                    prevDiff = diff;
                }

                if (sum > target) {
                    k--;
                } else {
                    j++;
                }

            }

        }

        return closestSum;

    }

    public static void main(String[] args) {

        // Basic test case
        System.out.println(threeSumClosest(new int[] { -1, 2, 1, -4 }, 1)); // Expected: 2

        // Exact match exists
        System.out.println(threeSumClosest(new int[] { 0, 1, 2 }, 3)); // Expected: 3

        // All positive
        System.out.println(threeSumClosest(new int[] { 1, 1, 1, 1 }, 5)); // Expected: 3

        // All negative
        System.out.println(threeSumClosest(new int[] { -3, -2, -5, -4 }, -1)); // Expected: -2

        // Large range
        System.out.println(threeSumClosest(new int[] { 1000, -1000, -1000, 0, 2, 1 }, 1)); // Expected: Close to 1

        // Edge case: minimum length input
        System.out.println(threeSumClosest(new int[] { 1, 1, -1 }, 0)); // Expected: 1

    }
}
