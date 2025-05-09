package hashtable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LC_448_FindAllNumbersDisappearedinanArray {

    /*
     * TC: O(n) - where n is the number of elements in the array
     * SC: O(1) - since we are modifying the input array in place
     */
    
    // Method 1: In-place negative marking
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        // First pass: Mark visited indices as negative
        for (int i = 0; i < n; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0) {
                nums[idx] = -nums[idx];
            }
        }

        // Second pass: Collect indices with positive values (i.e., missing numbers)
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }

    /*
    // Method 2: Cyclic sort-based swap approach
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correctIndex = nums[i] - 1;
            if (nums[i] != nums[correctIndex]) {
                swap(nums, i, correctIndex);
            } else {
                i++;
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                result.add(j + 1);
            }
        }

        return result;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
    */

    /*
    // Method 3: HashSet-based solution
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            seen.add(num);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!seen.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }
    */

    public static void main(String[] args) {
        int[] input1 = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Missing: " + findDisappearedNumbers(Arrays.copyOf(input1, input1.length))); // [5,6]

        int[] input2 = {1, 2, 3, 4, 5};
        System.out.println("Missing: " + findDisappearedNumbers(Arrays.copyOf(input2, input2.length))); // []

        int[] input3 = {2, 2, 2, 2};
        System.out.println("Missing: " + findDisappearedNumbers(Arrays.copyOf(input3, input3.length))); // [1,3,4]

        int[] input4 = {1, 2, 3, 4};
        System.out.println("Missing: " + findDisappearedNumbers(Arrays.copyOf(input4, input4.length))); // []

        int[] input5 = {};
        System.out.println("Missing: " + findDisappearedNumbers(Arrays.copyOf(input5, input5.length))); // []
    }
}
