package dynamicprogramming;

public class LC_72_EditDistance {

    /*
     * TC: O(m * n)
     * SC: O(m * n)
     * where m = length of word1, n = length of word2
     */

    static Integer[][] memo;

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new Integer[m][n];
        return solve(0, 0, word1, word2);
    }

    private static int solve(int i, int j, String word1, String word2) {
        if (i == word1.length()) {
            return word2.length() - j;
        }
        if (j == word2.length()) {
            return word1.length() - i;
        }
        if (memo[i][j] != null) {
            return memo[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            return solve(i + 1, j + 1, word1, word2);
        }

        int insert = 1 + solve(i, j + 1, word1, word2);
        int delete = 1 + solve(i + 1, j, word1, word2);
        int replace = 1 + solve(i + 1, j + 1, word1, word2);

        memo[i][j] = Math.min(insert, Math.min(delete, replace));
        return memo[i][j];
    }

    // Main method with test cases
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "ros"));       // Expected: 3
        System.out.println(minDistance("intention", "execution")); // Expected: 5
        System.out.println(minDistance("", ""));               // Expected: 0 (edge case)
        System.out.println(minDistance("a", ""));              // Expected: 1 (edge case)
        System.out.println(minDistance("", "abc"));            // Expected: 3 (edge case)
        System.out.println(minDistance("abc", "abc"));         // Expected: 0 (no edits needed)
        System.out.println(minDistance("abc", "yabd"));        // Expected: 2
    }
}
