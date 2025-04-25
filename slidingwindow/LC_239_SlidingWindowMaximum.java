package slidingwindow;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class LC_239_SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> dq = new ArrayDeque<>(); // store indices so that you can remove the out of fixed k sized indices
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        result.add(nums[dq.peekFirst()]);

        for (int i = k; i < nums.length; i++) {

            // step 1: make space for "i" index [we can keep only those indices whose index
            // is > (i - k)]
            while (!dq.isEmpty() && dq.peekFirst() <= (i - k)) { // if index at front <= window size
                dq.pollFirst(); // poll from front
            }

            // step 2: poll if nums[i] >
            while (!dq.isEmpty() && nums[i] > nums[dq.peekLast()]) {
                dq.pollLast();
            }

            // step 3: add i to Deque
            dq.offerLast(i);

            // No need to check for valid window size, if already traversed from from i = 0
            // to k
            // //step 4: our window size is k, so add element to result
            // if (i >= k - 1) { // want to start adding to result from i == k - 1, and
            // continue for all i >= k - 1
            // result.add(nums[dq.getFirst()]); //same as peekFirst()
            // }

            result.add(nums[dq.getFirst()]);

        }

        int[] arr = new int[result.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        // Return the result as an array -> Java 8+
        // return result.stream().mapToInt(i->i).toArray();

        return arr;
    }

    public static void main(String[] args) {

        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
        // Expected: [3, 3, 5, 5, 6, 7]

        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(new int[] { 1 }, 1)));
        // Expected: [1]

        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(new int[] { 9, 11 }, 2)));
        // Expected: [11]

        System.out.println("Output: " + Arrays.toString(maxSlidingWindow(new int[] { 4, 3, 11, 2, 1, 5 }, 1)));
        // Expected: [4, 3, 11, 2, 1, 5]

    }
}
