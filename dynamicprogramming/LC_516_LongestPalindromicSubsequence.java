package dynamicprogramming;

public class LC_516_LongestPalindromicSubsequence {

    static class Solution {

        /* 
         * TC: O(N^2) - where N is the length of the input string.
         * SC: O(N^2) - for the memoization table.
         */

        Integer[][] memo;

        private int solve(int i, int j, String s) {
            if (i > j) {
                return 0;
            }

            if (i == j) { // length 1 string is always a palindrome
                return 1;
            }

            if (memo[i][j] != null) {
                return memo[i][j];
            }

            if (s.charAt(i) == s.charAt(j)) {
                memo[i][j] = 2 + solve(i + 1, j - 1, s);
            } else {
                int movei = solve(i + 1, j, s);
                int movej = solve(i, j - 1, s);
                memo[i][j] = Math.max(movei, movej);
            }

            return memo[i][j];
        }

        public int longestPalindromeSubseq(String s) {
            int n = s.length();
            memo = new Integer[n][n];
            return solve(0, n - 1, s);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test cases
        System.out.println(sol.longestPalindromeSubseq("bbbab")); // Expected: 4
        System.out.println(sol.longestPalindromeSubseq("cbbd")); // Expected: 2
        System.out.println(sol.longestPalindromeSubseq("a")); // Expected: 1
        System.out.println(sol.longestPalindromeSubseq("abcde")); // Expected: 1
        System.out.println(sol.longestPalindromeSubseq("aaaabaaa"));// Expected: 7

        // Edge cases
        System.out.println(sol.longestPalindromeSubseq("")); // Expected: 0
        System.out.println(sol.longestPalindromeSubseq("abacdfgdcaba")); // Expected: 5
    }
}
