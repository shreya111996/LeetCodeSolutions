package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_90_SubsetsII {

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
    

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<Integer> innerList = new ArrayList<>();
        Arrays.sort(nums); // Sorting is necessary so that duplicates come together
        bt(0, nums, innerList);
        return result;
    }

    private void bt(int index, int[] nums, List<Integer> innerList) {
        result.add(new ArrayList<>(innerList));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) { // Skip duplicates
                continue;
            }
            innerList.add(nums[i]);
            bt(i + 1, nums, innerList);
            innerList.remove(innerList.size() - 1);
        }
    }

    /*
     * If we just wrote:
     * 
     * if (nums[i] == nums[i-1]) continue;
     * 
     * Wrong -> It would skip the first duplicate even at a fresh level, which is
     * wrong —
     * we still want to choose the first appearance.
     * 
     * i > index ensures:
     * 
     * At the start of a level, you are allowed to pick the first duplicate.
     * If it's later in the loop and duplicate is found, then skip.
     */

    public static void main(String[] args) {
        LC_90_SubsetsII obj = new LC_90_SubsetsII();

        // Test Case 1
        int[] nums1 = { 1, 2, 2 };
        System.out.println("Subsets with duplicates for [1,2,2]: " + obj.subsetsWithDup(nums1));

        // Test Case 2
        LC_90_SubsetsII obj2 = new LC_90_SubsetsII();
        int[] nums2 = { 1, 2, 2, 3 };
        System.out.println("Subsets with duplicates for [1,2,2,3]: " + obj2.subsetsWithDup(nums2));

        // Test Case 3
        LC_90_SubsetsII obj3 = new LC_90_SubsetsII();
        int[] nums3 = { 0 };
        System.out.println("Subsets with duplicates for [0]: " + obj3.subsetsWithDup(nums3));
    }
}
