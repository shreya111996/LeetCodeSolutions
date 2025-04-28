package backtracking;

import java.util.Arrays;

public class LC_31_NextPermutation {

    /**
     * TC: O(n) - where n is the length of the input array
     * [We traverse the array twice: once to find the first decreasing element and
     * once to reverse the suffix.]
     * 
     * SC: O(1) - in-place modification of the input array
     * 
     * REMEMBER: The next permutation is the next greater number that can be formed using (rearranging) the elements in the nums array.
     */

    public static void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i + 1]) { // until you find a decreasing element
            i--;
        }

        if (i >= 0) { 
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) { // finding the next greater element than at index i, starting from the last element
                j--;
            }
            swap(nums, i, j);
        }

        // reverse the elements after (i+1)th index in any case
        int start = i + 1;
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {1, 2, 3};
        nextPermutation(nums1);
        System.out.println("Next Permutation of [1,2,3]: " + Arrays.toString(nums1));  // [1,3,2]

        // Test Case 2
        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println("Next Permutation of [3,2,1]: " + Arrays.toString(nums2));  // [1,2,3]

        // Test Case 3
        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println("Next Permutation of [1,1,5]: " + Arrays.toString(nums3));  // [1,5,1]

        // Test Case 4
        int[] nums4 = {1, 3, 2};
        nextPermutation(nums4);
        System.out.println("Next Permutation of [1,3,2]: " + Arrays.toString(nums4));  // [2,1,3]

        // Test Case 5
        int[] nums5 = {2, 3, 1};
        nextPermutation(nums5);
        System.out.println("Next Permutation of [2,3,1]: " + Arrays.toString(nums5));  // [3,1,2]
    }
}
