package dynamicprogramming;

public class LC_198_HouseRobber {

    /* 
     * TC: O(n), n - is the number of houses
     * SC: O(n) - for memoization 
    */

    // Helper method: top-down DP with memoization
    private static int solve(int idx, int[] nums, Integer[] memo) {
        if (idx >= nums.length) {
            return 0;
        }

        if (memo[idx] != null) {
            return memo[idx];
        }

        int pick = nums[idx] + solve(idx + 2, nums, memo);
        int notPick = solve(idx + 1, nums, memo);

        memo[idx] = Math.max(pick, notPick);
        return memo[idx];
    }

    // Main method to be called
    public static int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length + 1]; // Only need up to nums.length
        return solve(0, nums, memo);
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println(rob(new int[]{1, 2, 3, 1}));        // Expected: 4
        System.out.println(rob(new int[]{2, 7, 9, 3, 1}));     // Expected: 12
        System.out.println(rob(new int[]{2, 1, 1, 2}));        // Expected: 4
        System.out.println(rob(new int[]{0}));                 // Expected: 0
        System.out.println(rob(new int[]{1}));                 // Expected: 1
        System.out.println(rob(new int[]{1, 3}));              // Expected: 3
        System.out.println(rob(new int[]{}));                  // Expected: 0 (edge case - empty array)
    }
}
