package dynamicprogramming;

public class LC_740_DeleteandEarn {

    /*
     * TC: O(n + m) - where n is the number of elements in nums and m is the max element in nums
     * SC: O(m) - for memoization
     */

    // Recursive + Memoization Approach
    static class Solution {
        int[] count;
        Integer[] memo;
        int maxNum;

        public int deleteAndEarn(int[] nums) {
            count = new int[10001];
            memo = new Integer[10001];
            maxNum = 0;

            for (int num : nums) {
                count[num]++;
                maxNum = Math.max(num, maxNum);
            }

            return solve(0);
        }

        private int solve(int idx) {
            if (idx > maxNum) {
                return 0;
            }

            if (memo[idx] != null) {
                return memo[idx];
            }

            int take = idx * count[idx] + solve(idx + 2);
            int skip = solve(idx + 1);

            memo[idx] = Math.max(take, skip);
            return memo[idx];
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Basic test cases
        System.out.println(sol.deleteAndEarn(new int[]{3, 4, 2})); // Expected: 6
        System.out.println(sol.deleteAndEarn(new int[]{2, 2, 3, 3, 3, 4})); // Expected: 9

        // Edge case: all same elements
        System.out.println(sol.deleteAndEarn(new int[]{5, 5, 5, 5})); // Expected: 20

        // Edge case: non-consecutive values
        System.out.println(sol.deleteAndEarn(new int[]{1, 3, 5, 7, 9})); // Expected: 25

        // Large values near max limit
        System.out.println(sol.deleteAndEarn(new int[]{9999, 10000, 10000})); // Expected: 20000
    }
}

/*
Iterative House Robber-based version:

class Solution {

    public int deleteAndEarn(int[] nums) {
        int[] count = new int[10001]; // 0 to 10^4

        for (int num: nums)  {
            count[num]++;
        }

        int include = 0;
        int exclude = 0;

        for (int i = 0; i < 10001; i++) {
            int nextInclude = exclude + count[i] * i;
            int nextExclude = Math.max(include, exclude);

            include = nextInclude;
            exclude = nextExclude;
        }

        return Math.max(include, exclude);
    }
}
*/
