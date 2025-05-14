package monotonicstack;

import java.util.HashSet;
import java.util.Stack;

public class LC_1081_SmallestSubsequenceofDistinctCharacters {

    /*
     * TC: O(n) - where n is the number of characters in the string
     * SC: O(n) - since we are using a stack to store the characters
     */

    public static String smallestSubsequence(String s) {

        HashSet<Character> seen = new HashSet<>();
        int[] lastOccur = new int[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            lastOccur[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!seen.contains(ch)) {
                while (!st.isEmpty() &&
                        ch < st.peek() &&
                        lastOccur[st.peek() - 'a'] > i) {
                    seen.remove(st.pop());
                }

                seen.add(ch);
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder(st.size());
        for (char ch : st) {
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(smallestSubsequence("bcabc"));        // Output: "abc"
        System.out.println(smallestSubsequence("cbacdcbc"));     // Output: "acdb"
        System.out.println(smallestSubsequence("cdadabcc"));     // Output: "adbc"
        System.out.println(smallestSubsequence("ecbacba"));      // Output: "eacb"
        System.out.println(smallestSubsequence("leetcode"));     // Output: "letcod"

        // Edge cases
        System.out.println(smallestSubsequence("a"));            // Output: "a"
        System.out.println(smallestSubsequence("aaaaa"));        // Output: "a"
        System.out.println(smallestSubsequence("abcabcabc"));    // Output: "abc"
        System.out.println(smallestSubsequence("zxyzzxzyx"));    // Output: "xyz"
        System.out.println(smallestSubsequence(""));             // Output: ""
    }
}
