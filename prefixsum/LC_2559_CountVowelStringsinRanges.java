package prefixsum;

public class LC_2559_CountVowelStringsinRanges {

    // Helper method to check if both first and last characters are vowels
    private static boolean isVowel(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowelChar(first) && isVowelChar(last);
    }

    private static boolean isVowelChar(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    /*
     * TC: O(N + Q) - where N is the number of words and Q is the number of queries.
     * SC: O(N) - for the prefix sum array.
     */

    public static int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length];
        int[] output = new int[queries.length];

        prefix[0] = isVowel(words[0]) ? 1 : 0;

        for (int i = 1; i < words.length; i++) {
            prefix[i] = prefix[i - 1] + (isVowel(words[i]) ? 1 : 0);
        }

        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            output[i] = prefix[end] - (start > 0 ? prefix[start - 1] : 0);
        }

        return output;
    }

    public static void main(String[] args) {
        String[] words1 = { "aba", "bcb", "ece", "aa", "e" };
        int[][] queries1 = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
        int[] result1 = vowelStrings(words1, queries1);
        printResult(result1); // Expected: [2, 3, 0]

        String[] words2 = { "a", "e", "i", "o", "u" };
        int[][] queries2 = { { 0, 4 }, { 1, 3 }, { 2, 2 } };
        int[] result2 = vowelStrings(words2, queries2);
        printResult(result2); // Expected: [5, 3, 1]

        String[] words3 = { "apple", "banana", "orange", "umbrella" };
        int[][] queries3 = { { 0, 2 }, { 1, 3 } };
        int[] result3 = vowelStrings(words3, queries3);
        printResult(result3); // Expected: [1, 1]

        // Edge case: single word
        String[] words4 = { "e" };
        int[][] queries4 = { { 0, 0 } };
        int[] result4 = vowelStrings(words4, queries4);
        printResult(result4); // Expected: [1]
    }

    private static void printResult(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
