package backtracking;

import java.util.ArrayList;
import java.util.List;

public class LC_46_Permutations {

    /**
     * TC: O(n * n!) - where n is the length of the input array
     * [Each number can be placed in n! different ways, and for each arrangement,
     * we need to copy the current permutation which takes O(n) time.]
     * 
     * SC: O(n) - for the recursion stack
     * 
     * The space complexity can be O(n) in the case of a skewed tree (like a linked list)
     * and O(log n) in the case of a balanced tree.
     */

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> current) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return; // Hey, I am done with this path. No need to continue any further steps here!
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            backtrack(nums, used, current);
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        LC_46_Permutations obj = new LC_46_Permutations();

        // Test Case 1
        int[] nums1 = { 1, 2, 3 };
        System.out.println("Permutations of [1,2,3]: " + obj.permute(nums1));

        // Test Case 2
        LC_46_Permutations obj2 = new LC_46_Permutations();
        int[] nums2 = { 0, 1 };
        System.out.println("Permutations of [0,1]: " + obj2.permute(nums2));

        // Test Case 3
        LC_46_Permutations obj3 = new LC_46_Permutations();
        int[] nums3 = { 1 };
        System.out.println("Permutations of [1]: " + obj3.permute(nums3));
    }
}
