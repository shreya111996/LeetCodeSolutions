package array;

public class LC_3046_SplittheArray {

    /*
     * TC: O(N) - where N is the number of elements in the input array.
     * SC: O(1)
     * 
     */

    static class Solution {
        public boolean isPossibleToSplit(int[] nums) {
            int[] arr = new int[101]; // constraint: 1 <= nums[i] <= 100

            for (int num : nums) {
                arr[num]++;
                if (arr[num] > 2) {
                    return false;
                }
            }

            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Test Case 1: Valid case with each number <= 2 occurrences
        int[] nums1 = {1, 2, 2, 1};
        System.out.println(sol.isPossibleToSplit(nums1)); // Expected: true

        // Test Case 2: Invalid case - number 2 appears 3 times
        int[] nums2 = {1, 2, 2, 2};
        System.out.println(sol.isPossibleToSplit(nums2)); // Expected: false

        // Test Case 3: Edge case - single element
        int[] nums3 = {5};
        System.out.println(sol.isPossibleToSplit(nums3)); // Expected: true

        // Test Case 4: Edge case - two identical elements
        int[] nums4 = {10, 10};
        System.out.println(sol.isPossibleToSplit(nums4)); // Expected: true

        // Test Case 5: Edge case - three different elements
        int[] nums5 = {3, 4, 5};
        System.out.println(sol.isPossibleToSplit(nums5)); // Expected: true

        // Test Case 6: Edge case - three same elements
        int[] nums6 = {6, 6, 6};
        System.out.println(sol.isPossibleToSplit(nums6)); // Expected: false
    }
}
