package binarysearch;

import java.util.Arrays;

public class LC_704_BinarySearch {

    public static int search(int[] nums, int target) {

        /**
         * TC: O(log n) - where n is the length of the input array
         * SC: O(1) - no extra space used
         */

        if (nums.length == 1 && nums[0] == target) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        testSearch(new int[] { -1, 0, 3, 5, 9, 12 }, 9); // Expected: 4
        testSearch(new int[] { -1, 0, 3, 5, 9, 12 }, 2); // Expected: -1
        testSearch(new int[] { 5 }, 5); // Expected: 0
        testSearch(new int[] { 5 }, 3); // Expected: -1
        testSearch(new int[] { 1, 3, 5, 7, 9 }, 1); // Expected: 0
        testSearch(new int[] { 1, 3, 5, 7, 9 }, 9); // Expected: 4
        testSearch(new int[] {}, 5); // Expected: -1
    }

    private static void testSearch(int[] nums, int target) {
        int result = search(nums, target);
        System.out.println("Input array: " + Arrays.toString(nums) +
                ", Target: " + target +
                ", Result Index: " + result);
    }
}
