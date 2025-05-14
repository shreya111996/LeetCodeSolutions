package monotonicstack;

import java.util.HashSet;
import java.util.Stack;

public class LC_316_RemoveDuplicateLetters {

    /* 
     * TC: O(n) - where n is the number of characters in the string 
     * SC: O(n) - since we are using a stack to store the characters
     */

    public static String removeDuplicateLetters(String s) {
        HashSet<Character> seen = new HashSet<>();
        Stack<Character> st = new Stack<>();
        int[] lastOccur = new int[26];

        for (int i = 0; i < s.length(); i++) {
            lastOccur[s.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!seen.contains(ch)) {
                while (!st.isEmpty() &&
                        ch < st.peek() && // curr char is lesser than peek
                        lastOccur[st.peek() - 'a'] > i) { // and there exists another occur of peek which has higher indexing than the curr char
                    seen.remove(st.pop()); // safely remove and pop from stack
                }
                seen.add(ch);
                st.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder(st.size());
        for (Character c : st) {
            sb.append(c);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(removeDuplicateLetters("cbacdcbc")); // Output: "acdb"
        System.out.println(removeDuplicateLetters("bcabc"));     // Output: "abc"
        System.out.println(removeDuplicateLetters("abacb"));     // Output: "abc"
        System.out.println(removeDuplicateLetters("bbcaac"));    // Output: "bac"
        System.out.println(removeDuplicateLetters("abacabad"));  // Output: "abcd"
        System.out.println(removeDuplicateLetters("cdadabcc"));  // Output: "adbc"
        System.out.println(removeDuplicateLetters("ecbacba"));   // Output: "eacb"
        System.out.println(removeDuplicateLetters("leetcode"));  // Output: "letcod"

        // Edge cases
        System.out.println(removeDuplicateLetters(""));          // Output: ""
        System.out.println(removeDuplicateLetters("a"));         // Output: "a"
        System.out.println(removeDuplicateLetters("aaaa"));      // Output: "a"
    }
}
