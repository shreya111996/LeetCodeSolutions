package dynamicprogramming;

public class LC_213_HouseRobberII {

    /*
     * TC: O(n) - where n is the number of houses
     * SC: O(n) - for memoization
     */

    // Helper method: solves subproblem for a range [start, end)
    private static int solve(int start, int end, int[] nums, Integer[] memo) {
        
        if (start >= end) {
            return 0;
        }

        if (memo[start] != null) {
            return memo[start];
        }

        int pick = nums[start] + solve(start + 2, end, nums, memo);
        int notPick = solve(start + 1, end, nums, memo);

        memo[start] = Math.max(pick, notPick);
        return memo[start];
    }

    // Main method: handles circular house arrangement
    public static int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        Integer[] memo1 = new Integer[nums.length];
        Integer[] memo2 = new Integer[nums.length];

        int max1 = solve(0, nums.length - 1, nums, memo1); // Exclude last house
        int max2 = solve(1, nums.length, nums, memo2);     // Exclude first house

        return Math.max(max1, max2);
    }

    // Test cases
    public static void main(String[] args) {
        System.out.println(rob(new int[]{2, 3, 2}));           // Expected: 3
        System.out.println(rob(new int[]{1, 2, 3, 1}));        // Expected: 4
        System.out.println(rob(new int[]{1, 2, 3}));           // Expected: 3
        System.out.println(rob(new int[]{1}));                 // Expected: 1 (edge case: single house)
        System.out.println(rob(new int[]{1, 3}));              // Expected: 3 (edge case: two houses)
        System.out.println(rob(new int[]{0, 0, 0}));           // Expected: 0
        System.out.println(rob(new int[]{200, 3, 140, 20, 10})); // Expected: 340
    }
}
