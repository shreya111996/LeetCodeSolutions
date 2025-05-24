package string;

public class LC_2697_LexicographicallySmallestPalindrome {

    // Method to convert a string into the lexicographically smallest palindrome
    public static String makeSmallestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (ch[i] != ch[j]) {
                char min = (char) Math.min(ch[i], ch[j]);
                ch[i] = min;
                ch[j] = min;
            }
            i++;
            j--;
        }

        return new String(ch);
    }

    public static void main(String[] args) {
        // Test Case 1: Already a palindrome
        System.out.println(makeSmallestPalindrome("madam")); // Output: "madam"

        // Test Case 2: Needs one replacement
        System.out.println(makeSmallestPalindrome("egcfe")); // Output: "efcfe"

        // Test Case 3: Needs multiple replacements
        System.out.println(makeSmallestPalindrome("abcd")); // Output: "abba"

        // Test Case 4: All different characters
        System.out.println(makeSmallestPalindrome("zyxwv")); // Output: "vxyxv"

        // Test Case 5: Single character
        System.out.println(makeSmallestPalindrome("a")); // Output: "a"

        // Test Case 6: Empty string
        System.out.println(makeSmallestPalindrome("")); // Output: ""

        // Test Case 7: Even length string
        System.out.println(makeSmallestPalindrome("baca")); // Output: "baab"
    }
}
