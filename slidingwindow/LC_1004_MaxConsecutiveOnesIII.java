package slidingwindow;

public class LC_1004_MaxConsecutiveOnesIII {

    /**
     * n - length of the input array
     * TC: O(n) - each element is visited at most twice (once by right, once by
     * left)
     * SC: O(1) - no extra space used
     */

    public static int longestOnes(int[] nums, int k) {

        int n = nums.length;
        int zeroFlipped = 0;

        int left = 0;
        int right = 0;

        int maxLen = 0;

        while (right < n) {

            if (nums[right] == 0) {
                zeroFlipped++; // count how many zeros you've "flipped" in the current window
            }

            while (zeroFlipped > k) { // if you've flipped more than allowed (k), you shrink the window from the left
                                      // until the condition is valid again
                if (nums[left] == 0) {
                    zeroFlipped--;
                }
                left++;
            }

            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }

        return maxLen;

    }

    public static void main(String[] args) {

        System.out.println("Input: [1,1,1,0,0,0,1,1,1,1,0], k = 2 → Output: " +
                longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2)); // Expected: 6

        System.out.println("Input: [0,0,1,1,1,0,0], k = 0 → Output: " +
                longestOnes(new int[] { 0, 0, 1, 1, 1, 0, 0 }, 0)); // Expected: 3

        System.out.println("Input: [1,1,1,1], k = 2 → Output: " +
                longestOnes(new int[] { 1, 1, 1, 1 }, 2)); // Expected: 4

        System.out.println("Input: [0,0,0], k = 2 → Output: " +
                longestOnes(new int[] { 0, 0, 0 }, 2)); // Expected: 2

        System.out.println("Input: [], k = 1 → Output: " +
                longestOnes(new int[] {}, 1)); // Expected: 0

        System.out.println("Input: [1,0,1,0,1,0,1], k = 3 → Output: " +
                longestOnes(new int[] { 1, 0, 1, 0, 1, 0, 1 }, 3)); // Expected: 7

    }
}
