package design;

import java.util.Stack;

public class LC_155_MinStack {

    /*
     * TC: O(1) for all operations (push, pop, top, getMin)
     * SC: O(N) - where N is the number of elements in the stack.
     */

    // MinStack implementation using a single stack of pairs [value, currentMin]
    static class MinStack {
        private Stack<int[]> st;

        public MinStack() {
            st = new Stack<>();
        }

        public void push(int val) {
            int minSoFar = st.isEmpty() ? val : Math.min(val, st.peek()[1]);
            st.push(new int[] { val, minSoFar });
        }

        public void pop() {
            st.pop();
        }

        public int top() {
            return st.peek()[0];
        }

        public int getMin() {
            return st.peek()[1];
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Basic operations
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Expected getMin: -3, Actual: " + minStack.getMin());
        minStack.pop();
        System.out.println("Expected top: 0, Actual: " + minStack.top());
        System.out.println("Expected getMin: -2, Actual: " + minStack.getMin());

        // Test Case 2: Duplicate minimum values
        MinStack minStack2 = new MinStack();
        minStack2.push(5);
        minStack2.push(2);
        minStack2.push(2);
        System.out.println("Expected getMin: 2, Actual: " + minStack2.getMin());
        minStack2.pop();
        System.out.println("Expected getMin: 2, Actual: " + minStack2.getMin());
        minStack2.pop();
        System.out.println("Expected getMin: 5, Actual: " + minStack2.getMin());

        // Edge Case: Single element stack
        MinStack minStack3 = new MinStack();
        minStack3.push(10);
        System.out.println("Expected top: 10, Actual: " + minStack3.top());
        System.out.println("Expected getMin: 10, Actual: " + minStack3.getMin());
    }
}
