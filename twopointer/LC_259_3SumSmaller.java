package twopointer;

import java.util.Arrays;

public class LC_259_3SumSmaller {

    /*
     * TC: O(n^2) - we sort the array in O(n log n) and then use a two-pointer technique which takes O(n^2)
     * SC: O(1) - no extra space used for the algorithm
     */

    public static int threeSumSmaller(int[] nums, int target) {

        if (nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int count = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum < target) {
                    count += (k - j);
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = {-2, 0, 1, 3};
        int target1 = 2;
        System.out.println("Output (Expected 2): " + threeSumSmaller(nums1, target1));

        // Test Case 2: All positive
        int[] nums2 = {1, 1, 1, 1};
        int target2 = 5;
        System.out.println("Output (Expected 4): " + threeSumSmaller(nums2, target2));

        // Test Case 3: Mixed positive and negative
        int[] nums3 = {-1, 2, 1, -4};
        int target3 = 2;
        System.out.println("Output (Expected 3): " + threeSumSmaller(nums3, target3));

        // Test Case 4: Fewer than 3 elements
        int[] nums4 = {1, 2};
        int target4 = 3;
        System.out.println("Output (Expected 0): " + threeSumSmaller(nums4, target4));

        // Test Case 5: Large values
        int[] nums5 = {100, 200, 300, 400};
        int target5 = 1000;
        System.out.println("Output (Expected 4): " + threeSumSmaller(nums5, target5));
    }
}
