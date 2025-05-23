package string;

public class LC_38_CountandSay {

    /*
     * TC:
     */
    private static String count(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;

        while (i < s.length()) {
            char currChar = s.charAt(i);
            int count = 1;
            i++;
            while (i < s.length() && s.charAt(i) == currChar) {
                count++;
                i++;
            }
            sb.append(count).append(currChar);
        }
        return sb.toString();
    }

    // Main method for countAndSay sequence
    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String prev = countAndSay(n - 1);
        return count(prev);
    }

    /**
     * countAndSay(4)
     * → count(countAndSay(3))
     * → count(count(countAndSay(2)))
     * → count(count(count(countAndSay(1))))
     * → count(count(count("1")))
     * → count(count("11"))
     * → count("21")
     * → "1211"
     */

    /*
     * // Iterative approach
     * class Solution {
     * 
     * public String countAndSay(int n) {
     * 
     * if (n == 1) {
     * return "1";
     * }
     * 
     * String result = "1";
     * 
     * for (int i = 2; i <= n; i++) {
     * result = count(result);
     * }
     * 
     * return result;
     * 
     * }
     * 
     * 
     * 
     * private String count(String s) {
     * 
     * StringBuilder sb = new StringBuilder();
     * int i = 0;
     * 
     * while (i < s.length()) {
     * char currChar = s.charAt(i);
     * int count = 1;
     * i++;
     * while (i < s.length() && s.charAt(i) == currChar) {
     * count++;
     * i++;
     * }
     * sb.append(count).append(currChar);
     * }
     * return sb.toString();
     * }
     * }
     * 
     */

    public static void main(String[] args) {
        // Test cases
        System.out.println("n = 1: " + countAndSay(1)); // Expected: "1"
        System.out.println("n = 2: " + countAndSay(2)); // Expected: "11"
        System.out.println("n = 3: " + countAndSay(3)); // Expected: "21"
        System.out.println("n = 4: " + countAndSay(4)); // Expected: "1211"
        System.out.println("n = 5: " + countAndSay(5)); // Expected: "111221"
        System.out.println("n = 6: " + countAndSay(6)); // Expected: "312211"

        // Edge case
        System.out.println("n = 10: " + countAndSay(10)); // Valid large input check
    }
}
