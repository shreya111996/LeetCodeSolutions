package slidingwindow;

public class LC_1358_NumberofSubstringsContainingAllThreeCharacters {

    private static boolean hasRequiredChars(int[] freqMap) {
        for (int x : freqMap) {
            if (x <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * TC: O(n) - where n is the length of the input string
     * SC: O(1) - no extra space used [array does not grow with the input size]
     */


    public static int numberOfSubstrings(String s) {
        
        int[] freqMap = new int[3];
        int left = 0;
        int right = 0;
        int subStrs = 0;

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            freqMap[rightChar - 'a']++;

            while (hasRequiredChars(freqMap)) {
                subStrs++;
                if (right < s.length() - 1) {
                    subStrs += (s.length() - right - 1);
                }
                char leftChar = s.charAt(left);
                freqMap[leftChar - 'a']--;
                left++;
            }

            right++;
        }

        return subStrs;
    }

    public static void main(String[] args) {
        // Basic tests
        System.out.println(numberOfSubstrings("abc"));           // 1
        System.out.println(numberOfSubstrings("aaacb"));         // 3
        System.out.println(numberOfSubstrings("abcabc"));        // 10

        // Edge cases
        System.out.println(numberOfSubstrings("aaa"));           // 0 (no 'b' or 'c')
        System.out.println(numberOfSubstrings("aabbcc"));        // 3
        System.out.println(numberOfSubstrings("ababbbcaaaac"));  // 19
        System.out.println(numberOfSubstrings("a"));             // 0
        System.out.println(numberOfSubstrings("ab"));            // 0
        System.out.println(numberOfSubstrings("aabcbcabcabc"));  // 31
    }
}
