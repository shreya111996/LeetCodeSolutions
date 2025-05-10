package binarysearch;

public class LC_540_SingleElementinaSortedArray {

    /* 
     * TC: O(log n)
     * SC: O(1)
     */

    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == nums[mid - 1]) {
                if ((right - mid) % 2 == 0) {
                    right = mid - 2;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                if ((right - mid) % 2 == 0) {
                    left = mid + 2;
                } else {
                    right = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        // Basic test case
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8})); // 2

        // Single element
        System.out.println(singleNonDuplicate(new int[]{1})); // 1

        // Element in the middle
        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,4,4,5,5})); // 3

        // Element at end
        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,3,3,4})); // 4

        // Element at start
        System.out.println(singleNonDuplicate(new int[]{0,1,1,2,2,3,3})); // 0
    }
}
