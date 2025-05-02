package slidingwindow;

public class LC_1876_SubstringsofSizeThreewithDistinctCharacters {

    /**
     * n - length of the input string
     * TC: O(n) - each character is visited at most once
     * SC: O(1) - no extra space used
     */

    public static int countGoodSubstrings(String s) {

        int count = 0;

        for (int i = 0; i < s.length() - 2; i++) {

            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);

            if (a != b && b != c && a != c) {
                count++;
            }
        }

        return count;
    }

    /**
     * for (int i = 0; i <= s.length() - 3; i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            set.add(s.charAt(i + 1));
            set.add(s.charAt(i + 2));
            if (set.size() == 3) {
                count++;
            }
        }
     * 
     */

    public static void main(String[] args) {

        // Test cases
        System.out.println(countGoodSubstrings("xyzzaz")); // Output: 1 ("xyz")
        System.out.println(countGoodSubstrings("aababcabc")); // Output: 4 ("bab", "abc", "bca", "cab")
        System.out.println(countGoodSubstrings("abc")); // Output: 1
        System.out.println(countGoodSubstrings("aaa")); // Output: 0
        System.out.println(countGoodSubstrings("")); // Output: 0
        System.out.println(countGoodSubstrings("ab")); // Output: 0
        System.out.println(countGoodSubstrings("abcdef")); // Output: 4 ("abc", "bcd", "cde", "def")
    }
}
