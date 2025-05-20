package dynamicprogramming;

public class LC_1143_LongestCommonSubsequence {

    /*
     * TC: O(m * n)
     * SC: O(m * n)
     * where:
     *   m = length of text1,
     *   n = length of text2.
     *
     */

    static Integer[][] memo;

    public static int longestCommonSubsequence(String text1, String text2) {

        int len1 = text1.length();
        int len2 = text2.length();

        memo = new Integer[len1][len2];

        return solve(0, 0, text1, text2);
    }

    private static int solve(int start1, int start2, String text1, String text2) {

        if (start1 == text1.length() || start2 == text2.length()) {
            return 0;
        }

        if (memo[start1][start2] != null) {
            return memo[start1][start2];
        }

        if (text1.charAt(start1) == text2.charAt(start2)) {
            memo[start1][start2] = 1 + solve(start1 + 1, start2 + 1, text1, text2);
        } else {
            int nextStart1 = solve(start1 + 1, start2, text1, text2);
            int nextStart2 = solve(start1, start2 + 1, text1, text2);
            memo[start1][start2] = Math.max(nextStart1, nextStart2);
        }

        return memo[start1][start2];
    }

    public static void main(String[] args) {

        // Basic tests
        System.out.println(longestCommonSubsequence("abcde", "ace")); // Output: 3
        System.out.println(longestCommonSubsequence("abc", "abc")); // Output: 3
        System.out.println(longestCommonSubsequence("abc", "def")); // Output: 0

        // Edge cases
        System.out.println(longestCommonSubsequence("", "abc")); // Output: 0
        System.out.println(longestCommonSubsequence("abc", "")); // Output: 0
        System.out.println(longestCommonSubsequence("", "")); // Output: 0

        // Larger test
        System.out.println(longestCommonSubsequence("AGGTAB", "GXTXAYB")); // Output: 4 (GTAB)
    }
}
