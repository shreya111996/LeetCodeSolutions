package hashtable;

import java.util.*;

public class LC_243_ShortestWordDistance {

    /*
     * TC: O(n) - where n is the number of elements in the array
     * SC: O(1) - since we are not using any extra space
     */

    // Optimal one-pass solution using two pointers

    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        
        int idx1 = -1;
        int idx2 = -1;
        int minDist = wordsDict.length;

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                idx1 = i;
            } else if (wordsDict[i].equals(word2)) {
                idx2 = i;
            }

            if (idx1 != -1 && idx2 != -1) {
                minDist = Math.min(minDist, Math.abs(idx1 - idx2));
                if (minDist == 1) return 1;
            }
        }

        return minDist;
    }

    /*
    // Brute-force map-based solution
    public static int shortestDistance(String[] wordsDict, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                map.putIfAbsent(word1, new ArrayList<>());
                map.get(word1).add(i);
            }

            if (wordsDict[i].equals(word2)) {
                map.putIfAbsent(word2, new ArrayList<>());
                map.get(word2).add(i);
            }
        }

        List<Integer> values1 = map.get(word1);
        List<Integer> values2 = map.get(word2);
        int min = Integer.MAX_VALUE;

        for (int val1 : values1) {
            for (int val2 : values2) {
                min = Math.min(min, Math.abs(val1 - val2));
            }
        }

        return min;
    }
    */

    public static void main(String[] args) {
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        
        // Test case 1: Normal case
        System.out.println(shortestDistance(words, "coding", "practice")); // Output: 3

        // Test case 2: Multiple occurrences of word1 or word2
        System.out.println(shortestDistance(words, "makes", "coding")); // Output: 1

        // Edge case: word1 and word2 adjacent
        System.out.println(shortestDistance(new String[]{"a", "b"}, "a", "b")); // Output: 1

        // Edge case: words at the ends
        System.out.println(shortestDistance(new String[]{"a", "x", "x", "x", "b"}, "a", "b")); // Output: 4

        // Edge case: word1 appears once, word2 multiple times
        System.out.println(shortestDistance(new String[]{"a", "b", "b", "b", "c"}, "a", "c")); // Output: 4
    }
}
