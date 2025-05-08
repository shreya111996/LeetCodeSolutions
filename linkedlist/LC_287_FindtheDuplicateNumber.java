package linkedlist;

public class LC_287_FindtheDuplicateNumber {

    /**
     * TC: O(n) - where n is the number of elements in the array
     * SC: O(1) - no extra space used
     */

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        // First phase: detect the intersection point
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Second phase: find the entrance to the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or fast
    }

    public static void main(String[] args) {
        // Test Case 1: Simple duplicate
        int[] nums1 = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate(nums1)); // 2

        // Test Case 2: Multiple elements, one duplicate
        int[] nums2 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums2)); // 3

        // Test Case 3: Duplicate is the smallest number
        int[] nums3 = {1, 1};
        System.out.println(findDuplicate(nums3)); // 1

        // Test Case 4: Duplicate is the largest number
        int[] nums4 = {2, 5, 9, 6, 9, 3, 8, 9, 7, 1};
        System.out.println(findDuplicate(nums4)); // 9
    }
}
