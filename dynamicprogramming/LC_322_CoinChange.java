package dynamicprogramming;

import java.util.Arrays;

public class LC_322_CoinChange {

    /*
     * TC: O(n * m) - where n is the amount and m is the number of coins
     * SC: O(n) - for the dp array
     */

    public static int coinChange(int[] coins, int amount) {

        if (amount == 0)
            return 0;

        int[] dp = new int[amount + 1];

        // Fill dp array with a large value (amount + 1 is safe)
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        for (int currAmount = 1; currAmount <= amount; currAmount++) {
            for (int coin : coins) {
                if (coin <= currAmount) {
                    dp[currAmount] = Math.min(dp[currAmount], 1 + dp[currAmount - coin]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {

        testCoinChange(new int[] { 1, 2, 5 }, 11); // Expected: 3
        testCoinChange(new int[] { 2 }, 3); // Expected: -1
        testCoinChange(new int[] { 1, 2, 5 }, 0); // Expected: 0
        testCoinChange(new int[] { 2, 5, 10 }, 5); // Expected: 1
        testCoinChange(new int[] { 5 }, 3); // Expected: -1
        testCoinChange(new int[] { 3 }, 9); // Expected: 3
        testCoinChange(new int[] { 3 }, 7); // Expected: -1
        testCoinChange(new int[] {}, 7); // Expected: -1
        testCoinChange(new int[] { 1, 2, 5 }, 1000); // Expected: 200
    }

    private static void testCoinChange(int[] coins, int amount) {
        int result = coinChange(coins, amount);
        System.out.println("Coins: " + Arrays.toString(coins) +
                ", Amount: " + amount +
                " => Minimum coins needed: " + result);
    }

}
