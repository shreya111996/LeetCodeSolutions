package string;

import java.util.*;

public class LC_916_WordSubsets {

    private static boolean compare(int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq2[i] > freq1[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * TC: O(N * L1 + M * L2), where:
     * - N = length of words2
     * - L1 = average length of words in words2
     * - M = length of words1
     * - L2 = average length of words in words1
     * 
     * Building the max frequency array from words2 takes O(N * L1),
     * and checking each word in words1 takes O(M * L2).
     * 
     * SC: O(1) — we use fixed-size arrays of length 26 for character frequencies.
     */

    public static List<String> wordSubsets(String[] words1, String[] words2) {

        int[] freq = new int[26];

        for (String word : words2) {
            int[] intermediateFreq = new int[26];
            for (char ch : word.toCharArray()) {
                intermediateFreq[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                freq[i] = Math.max(freq[i], intermediateFreq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : words1) {
            int[] wordFreq = new int[26];
            for (char ch : word.toCharArray()) {
                wordFreq[ch - 'a']++;
            }
            if (compare(wordFreq, freq)) {
                result.add(word);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        // Example 1
        String[] words1a = {"amazon","apple","facebook","google","leetcode"};
        String[] words2a = {"e","o"};
        System.out.println("Expected: [facebook, google, leetcode]");
        System.out.println("Output:   " + wordSubsets(words1a, words2a));

        // Example 2
        String[] words1b = {"amazon","apple","facebook","google","leetcode"};
        String[] words2b = {"lc","eo"};
        System.out.println("Expected: [leetcode]");
        System.out.println("Output:   " + wordSubsets(words1b, words2b));

        // Example 3
        String[] words1c = {"acaac","cccbb","aacbb","caacc","bcbbb"};
        String[] words2c = {"c","cc","b"};
        System.out.println("Expected: [cccbb]");
        System.out.println("Output:   " + wordSubsets(words1c, words2c));

        // Edge Case: Empty words2
        String[] words1d = {"abc","def"};
        String[] words2d = {};
        System.out.println("Expected: [abc, def]");
        System.out.println("Output:   " + wordSubsets(words1d, words2d));

        // Edge Case: All words1 are universal
        String[] words1e = {"aaa", "aaab", "aaaab"};
        String[] words2e = {"a"};
        System.out.println("Expected: [aaa, aaab, aaaab]");
        System.out.println("Output:   " + wordSubsets(words1e, words2e));

        // Edge Case: No universal string
        String[] words1f = {"abc","xyz"};
        String[] words2f = {"aaaa"};
        System.out.println("Expected: []");
        System.out.println("Output:   " + wordSubsets(words1f, words2f));
    }
}
