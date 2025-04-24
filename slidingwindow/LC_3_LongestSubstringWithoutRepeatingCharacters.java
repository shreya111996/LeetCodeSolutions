package slidingwindow;

import java.util.HashSet;

public class LC_3_LongestSubstringWithoutRepeatingCharacters {

    /** 
     * n - length of the input string
     * TC: O(n) - each character is visited at most twice (once by right, once by left)
     * SC: O(k) - where k is the size of the character set (at most, the number of unique characters in the substring)
     * In the worst case, k = min(n, charset size) → e.g., 26 for lowercase English letters
     */


    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> unique = new HashSet<>();

        int n = s.length();

        int left = 0;
        int right = 0;
        int maxLen = 0;

        while (right < n) {

            while (left < right && unique.contains(s.charAt(right))) { //clean up logic inside, to ensure no duplicates
                unique.remove(s.charAt(left));
                left++;
            }

            unique.add(s.charAt(right)); //after removing duplicates, add char to window
            maxLen = Math.max(right - left + 1, maxLen);

            right++;
        }

        return maxLen;

    }

    public static void main(String[] args) {

        System.out.println("Input: \"abcabcbb\" → Output: " + lengthOfLongestSubstring("abcabcbb")); // Expected: 3 ("abc")
        System.out.println("Input: \"bbbbb\" → Output: " + lengthOfLongestSubstring("bbbbb"));       // Expected: 1 ("b")
        System.out.println("Input: \"pwwkew\" → Output: " + lengthOfLongestSubstring("pwwkew"));     // Expected: 3 ("wke")
        System.out.println("Input: \"\" → Output: " + lengthOfLongestSubstring(""));                 // Expected: 0 (empty string)
        System.out.println("Input: \" \" → Output: " + lengthOfLongestSubstring(" "));               // Expected: 1 (single space)
        System.out.println("Input: \"dvdf\" → Output: " + lengthOfLongestSubstring("dvdf"));         // Expected: 3 ("vdf")
        System.out.println("Input: \"abba\" → Output: " + lengthOfLongestSubstring("abba"));         // Expected: 2 ("ab" or "ba")
        System.out.println("Input: \"abcdefg\" → Output: " + lengthOfLongestSubstring("abcdefg"));   // Expected: 7 (all unique)
        System.out.println("Input: \"abcabcbbxyzxyz\" → Output: " + lengthOfLongestSubstring("abcabcbbxyzxyz")); // Expected: 4 ("bxyz")

    }
}


/** Why "while" loop inside the outer "while" is necessary:

if only removes one duplicate, but you may need to remove multiple characters to make the window valid. So while is the right choice to clean the window completely

Real Example: "abccba"
Let’s say you're at:

left = 0

right = 3

s.charAt(right) is 'c'

And unique = {'a', 'b', 'c'}

If you use if:

Only 'a' gets removed.

But 'c' is still in the set, so the window is still invalid.

You move on and add 'c' again, which breaks the uniqueness invariant.

If you use while:

'a', 'b' are removed one by one.

Eventually 'c' is removed too.

Now 'c' is safe to re-add.

Window is clean before expansion.
 */