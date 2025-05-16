package backtracking;

public class LC_2698_FindthePunishmentNumberofanInteger {

    /**
     * TC: O(N) for each number from 1 to N, 
     * log(base 10)(n^2) digits in n^2 nad every digit has 2 possibilties to be included or not
     * so the total time complexity is O(N * 2^(log(n^2)))
     * 
     * SC: O(log(base 10)(n^2)) for the memoization array
     * recursion stack space : number of digits in n^2, log(base 10)(n^2)
     * so the total space complexity is O(log(base 10)(n^2) + log(base 10)(n^2))
     * 
     */

    private static boolean check(String str, int n, int idx, int currSum, Boolean[][] memo) {
        if (idx == str.length()) {
            return currSum == n;
        }

        if (currSum > n) {
            return false;
        }

        if (memo[idx][currSum] != null) {
            return memo[idx][currSum];
        }

        for (int j = idx; j < str.length(); j++) {
            String subStr = str.substring(idx, j + 1);
            int val = Integer.parseInt(subStr);

            if (check(str, n, j + 1, currSum + val, memo)) {
                memo[idx][currSum] = true;
                return true;
            }
        }

        memo[idx][currSum] = false;
        return false;
    }

    public static int punishmentNumber(int n) {
        int result = 0;

        for (int num = 1; num <= n; num++) {
            int squared = num * num;
            String str = String.valueOf(squared);

            Boolean[][] memo = new Boolean[str.length() + 1][num + 1];

            if (check(str, num, 0, 0, memo)) {
                result += squared;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(punishmentNumber(10)); // Expected: 182
        System.out.println(punishmentNumber(37)); // Expected: 1478
        System.out.println(punishmentNumber(1));  // Edge: 1 (1*1=1, and 1 == 1)
        System.out.println(punishmentNumber(0));  // Edge: 0
        System.out.println(punishmentNumber(100)); // Larger case
    }
}
