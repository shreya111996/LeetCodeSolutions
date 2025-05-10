package binarysearch;

import java.util.*;

public class LC_697_DegreeofanArray {

    /*
     * TC: O(n)
     * SC: O(n)
     */

    public static int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Integer> firstIndexMap = new HashMap<>();
        Map<Integer, Integer> lastIndexMap = new HashMap<>();

        int maxFreq = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            firstIndexMap.putIfAbsent(num, i);  // store first occurrence
            lastIndexMap.put(num, i);           // update last occurrence

            maxFreq = Math.max(maxFreq, freqMap.get(num));
        }

        for (int num : freqMap.keySet()) {
            if (freqMap.get(num) == maxFreq) {
                int length = lastIndexMap.get(num) - firstIndexMap.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        // Test case 1: Example from LeetCode
        System.out.println(findShortestSubArray(new int[]{1, 2, 2, 3, 1})); // Output: 2

        // Test case 2: Multiple elements with same max frequency
        System.out.println(findShortestSubArray(new int[]{1,2,2,3,1,4,2})); // Output: 6

        // Test case 3: Single element array
        System.out.println(findShortestSubArray(new int[]{5})); // Output: 1

        // Test case 4: All elements are the same
        System.out.println(findShortestSubArray(new int[]{4,4,4,4})); // Output: 4

        // Test case 5: Degree formed by element in middle
        System.out.println(findShortestSubArray(new int[]{1,2,3,3,2,1,1})); // Output: 3
    }
}
