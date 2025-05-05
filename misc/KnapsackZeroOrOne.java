package misc;

public class KnapsackZeroOrOne {

    /*
     * TC: O(n * W) - where n is the number of items and W is the maximum weight
     * capacity
     * SC: O(n * W) - for the memoization table
     */

    private static int solve(int[] val, int[] wt, int idx, int rem, Integer[][] memo) {
        if (idx == wt.length) {
            return 0;
        }

        if (memo[idx][rem] != null) {
            return memo[idx][rem];
        }

        int notPicked = solve(val, wt, idx + 1, rem, memo);

        int picked = Integer.MIN_VALUE;
        if (wt[idx] <= rem) {
            picked = val[idx] + solve(val, wt, idx + 1, rem - wt[idx], memo);
        }

        memo[idx][rem] = Math.max(notPicked, picked);

        return memo[idx][rem];
    }

    static int knapsack(int W, int[] val, int[] wt) {
        Integer[][] memo = new Integer[val.length][W + 1];
        return solve(val, wt, 0, W, memo);
    }

    public static void main(String[] args) {
        // Test Case 1: Basic Case
        int[] val1 = {60, 100, 120};
        int[] wt1 = {10, 20, 30};
        int W1 = 50;
        System.out.println(knapsack(W1, val1, wt1)); // Expected: 220

        // Test Case 2: Capacity less than smallest item
        int[] val2 = {50, 60};
        int[] wt2 = {5, 6};
        int W2 = 2;
        System.out.println(knapsack(W2, val2, wt2)); // Expected: 0

        // Test Case 3: Single item fits
        int[] val3 = {10};
        int[] wt3 = {5};
        int W3 = 5;
        System.out.println(knapsack(W3, val3, wt3)); // Expected: 10

        // Test Case 4: Single item doesn't fit
        int[] val4 = {10};
        int[] wt4 = {6};
        int W4 = 5;
        System.out.println(knapsack(W4, val4, wt4)); // Expected: 0

        // Test Case 5: Empty inputs
        int[] val5 = {};
        int[] wt5 = {};
        int W5 = 10;
        System.out.println(knapsack(W5, val5, wt5)); // Expected: 0

        // Test Case 6: Exact fit with all items
        int[] val6 = {15, 10, 45};
        int[] wt6 = {10, 10, 30};
        int W6 = 50;
        System.out.println(knapsack(W6, val6, wt6)); // Expected: 70

        // Test Case 7: Multiple items, but best option is to skip heavier ones
        int[] val7 = {20, 5, 10, 40, 15, 25};
        int[] wt7 = {1, 2, 3, 8, 7, 4};
        int W7 = 10;
        System.out.println(knapsack(W7, val7, wt7)); // Expected: 60
    }
}
