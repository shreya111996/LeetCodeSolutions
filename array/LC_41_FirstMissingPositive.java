package array;

public class LC_41_FirstMissingPositive {

    /*
     * TC: O(n) - we traverse the array a constant number of times
     * SC: O(1) - we do not use any extra space for the algorithm
     */

    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {

            /*
             * only care about elements > 0 & <= n
             * if element is not at correct position [element i should be present at i - 1
             * position]
             * swap elements at nums[i] and nums[nums[i] - 1]
             */

            while (nums[i] > 0 && nums[i] <= n
                    && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {

        int[] test1 = { 1, 2, 0 }; // Missing: 3
        int[] test2 = { 3, 4, -1, 1 }; // Missing: 2
        int[] test3 = { 7, 8, 9, 11, 12 }; // Missing: 1
        int[] test4 = { 1, 1 }; // Missing: 2
        int[] test5 = {}; // Missing: 1
        int[] test6 = { 2 }; // Missing: 1
        int[] test7 = { 1 }; // Missing: 2
        int[] test8 = { 2, 1 }; // Missing: 3

        System.out.println(firstMissingPositive(test1)); // 3
        System.out.println(firstMissingPositive(test2)); // 2
        System.out.println(firstMissingPositive(test3)); // 1
        System.out.println(firstMissingPositive(test4)); // 2
        System.out.println(firstMissingPositive(test5)); // 1
        System.out.println(firstMissingPositive(test6)); // 1
        System.out.println(firstMissingPositive(test7)); // 2
        System.out.println(firstMissingPositive(test8)); // 3
    }
}
