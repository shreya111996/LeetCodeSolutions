package dynamicprogramming;

public class LC_518_CoinChangeII {

    public static int change(int amount, int[] coins) {

        /*
         * TC: O(n * m) - where n is the amount and m is the number of coins
         * SC: O(n * m) - for the dp array
         */

        int rows = coins.length + 1;
        int cols = amount + 1;

        int[][] dp = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            dp[i][0] = 1; // for amount = 0, there is exactly 1 way to make the amount whatever the given
                          // coins are
        }

        // by default Java initializes cell values by 0, so not necessary to explicit 0
        for (int i = 1; i < cols; i++) {
            dp[0][i] = 0; // For any amount to make, if you have no coins, there are 0 ways to make the
                          // amount
        }

        for (int row = 1; row < rows; row++) {

            for (int col = 1; col < cols; col++) {

                if (col - coins[row - 1] >= 0) { // only if the subproblem exists try to add it into the solution
                    dp[row][col] = dp[row - 1][col] + dp[row][col - coins[row - 1]];
                }

                else {
                    dp[row][col] = dp[row - 1][col]; // otherwise just go one level up (row - 1), to fetch the no. of
                                                     // ways
                }
            }
        }

        return dp[rows - 1][cols - 1];

        /**
         * 
         * Space Optimized Version : SC: O(n) - where n is the amount
         * 
         * 
         * int[] dp = new int[amount + 1];
         * dp[0] = 1; // 1 way to make amount 0: pick no coins
         * 
         * for (int coin : coins) {
         * for (int j = coin; j <= amount; j++) {
         * dp[j] += dp[j - coin];
         * }
         * }
         * 
         * return dp[amount];
         * 
         */
    }

    public static void main(String[] args) {

        System.out.println(change(5, new int[] { 1, 2, 5 })); // Expected output: 4
        System.out.println(change(3, new int[] { 2 })); // Expected output: 0
        System.out.println(change(10, new int[] { 10 })); // Expected output: 1
        System.out.println(change(0, new int[] { 1, 2, 3 })); // Expected output: 1
        System.out.println(change(5, new int[] { 1, 2, 3 })); // Expected output: 5
    }

}
