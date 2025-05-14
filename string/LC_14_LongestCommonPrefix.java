package string;

public class LC_14_LongestCommonPrefix {

    /*
     * TC: O(n * m) - where n is the number of strings and m is the length of the shortest string
     * SC: O(1)
     */

    public static String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;

        for (String str : strs) {
            minLen = Math.min(str.length(), minLen);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < minLen; i++) {
            char curr = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j - 1].charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(curr);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // "fl"
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));   // ""
        System.out.println(longestCommonPrefix(new String[]{"interview", "internet", "internal"})); // "inte"
        System.out.println(longestCommonPrefix(new String[]{"a"})); // "a"
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"})); // "a"
        System.out.println(longestCommonPrefix(new String[]{"abc", "abc", "abc"})); // "abc"

        // Edge cases
        System.out.println(longestCommonPrefix(new String[]{""})); // ""
        System.out.println(longestCommonPrefix(new String[]{"", "abc"})); // ""
        System.out.println(longestCommonPrefix(new String[]{"abc", ""})); // ""
    }
}
