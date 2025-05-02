package slidingwindow;

public class LC_424_LongestRepeatingCharacterReplacement {

    /**
     * n - length of the input string
     * TC: O(n) - each character is visited at most twice (once by right, once by
     * left)
     * SC: O(1) - no extra space used
     */

    public static int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;

        int maxFreq = 0;
        int[] freqMap = new int[26];
        int maxLen = 0;

        while (right < s.length()) {

            char rightChar = s.charAt(right);
            freqMap[rightChar - 'A']++;
            maxFreq = Math.max(maxFreq, freqMap[rightChar - 'A']);

            int charsToBeChanged = (right - left + 1) - maxFreq;

            if (charsToBeChanged > k) {
                char leftChar = s.charAt(left);
                freqMap[leftChar - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {

        System.out.println("Input: \"ABAB\", k = 2 -> Output: " + characterReplacement("ABAB", 2)); // 4
        System.out.println("Input: \"AABABBA\", k = 1 -> Output: " + characterReplacement("AABABBA", 1)); // 4
        System.out.println("Input: \"AAAA\", k = 2 -> Output: " + characterReplacement("AAAA", 2)); // 4
        System.out.println("Input: \"ABCDE\", k = 1 -> Output: " + characterReplacement("ABCDE", 1)); // 2
        System.out.println("Input: \"\", k = 1 -> Output: " + characterReplacement("", 1)); // 0
        System.out.println("Input: \"A\", k = 0 -> Output: " + characterReplacement("A", 0)); // 1
        System.out.println("Input: \"ABBB\", k = 2 -> Output: " + characterReplacement("ABBB", 2)); // 4
    }
}
