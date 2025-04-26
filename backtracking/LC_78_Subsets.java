package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC_78_Subsets {

    /**
     * TC: O(n * 2^n) - where n is the length of the input array
     * [Each number can either be included or excluded, giving 2^n total subsets. 
     * Since each subset copy takes O(n) time at most, the overall work becomes O(n * 2^n).]
     * 
     * SC: O(n) - for the recursion stack
     * 
     * The space complexity can be O(n) in the case of a skewed tree (like a linked list)
     * and O(log n) in the case of a balanced tree.
     */

    private List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>(); // Reset before each use
        backtrack(0, nums, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, int[] nums, List<Integer> current) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) { 
            current.add(nums[i]);
            backtrack(i + 1, nums, current);
            current.remove(current.size() - 1);
        }
    }

    /**The solution guarantees no duplicate subsets because at each recursion level, 
     * we only move forward through the array (i = index) without revisiting previous elements, 
     * ensuring unique combination building. */

    public static void main(String[] args) {
        LC_78_Subsets solution = new LC_78_Subsets();

        // Test Case 1
        int[] nums1 = {1, 2, 3};
        System.out.println("Subsets of [1,2,3]: " + solution.subsets(nums1));
        
        // Test Case 2
        int[] nums2 = {0};
        System.out.println("Subsets of [0]: " + solution.subsets(nums2));
        
        // Test Case 3
        int[] nums3 = {1, 2};
        System.out.println("Subsets of [1,2]: " + solution.subsets(nums3));
        
        // Test Case 4
        int[] nums4 = {};
        System.out.println("Subsets of []: " + solution.subsets(nums4));
    }
}
