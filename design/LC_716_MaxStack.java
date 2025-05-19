package design;

import java.util.*;

public class LC_716_MaxStack {

    /*
     * TC: O(1) for push, pop, top, peekMax
     * TC: O(log N) for popMax
     * SC: O(N) - where N is the number of elements in the stack.
     */

    // Doubly-linked list node
    static class Node {
        Node prev, next;
        int val;
        Node(int val) { this.val = val; }
    }

    // MaxStack implementation
    static class MaxStack {
        private final Node head, tail;
        private final TreeMap<Integer, List<Node>> sortedMap;

        public MaxStack() {
            head = new Node(0);
            tail = new Node(0);
            head.next = tail;
            tail.prev = head;
            sortedMap = new TreeMap<>();
        }

        public void push(int x) {
            Node n = new Node(x);
            // insert at tail
            n.prev = tail.prev;
            tail.prev.next = n;
            tail.prev = n;
            n.next = tail;
            // record in map
            if (!sortedMap.containsKey(x)) {
                sortedMap.put(x, new ArrayList<>());
            }
            sortedMap.get(x).add(n);
        }

        public int pop() {
            Node n = tail.prev;
            removeNode(n);
            List<Node> lst = sortedMap.get(n.val);
            lst.remove(lst.size() - 1);
            if (lst.isEmpty()) {
                sortedMap.remove(n.val);
            }
            return n.val;
        }

        public int top() {
            return tail.prev.val;
        }

        public int peekMax() {
            return sortedMap.lastKey();
        }

        public int popMax() {
            int max = sortedMap.lastKey();
            List<Node> lst = sortedMap.get(max);
            Node n = lst.remove(lst.size() - 1);
            removeNode(n);
            if (lst.isEmpty()) {
                sortedMap.remove(max);
            }
            return max;
        }

        private void removeNode(Node n) {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Basic functionality ===");
        MaxStack stack = new MaxStack();
        stack.push(5);
        stack.push(1);
        stack.push(5);
        System.out.println("top() -> " + stack.top() + " (expected 5)");
        System.out.println("popMax() -> " + stack.popMax() + " (expected 5)");
        System.out.println("top() -> " + stack.top() + " (expected 1)");
        System.out.println("peekMax() -> " + stack.peekMax() + " (expected 5)");
        System.out.println("pop() -> " + stack.pop() + " (expected 1)");
        System.out.println("top() -> " + stack.top() + " (expected 5)");

        System.out.println("\n=== Single-element edge case ===");
        MaxStack single = new MaxStack();
        single.push(10);
        System.out.println("pop() -> " + single.pop() + " (expected 10)");

        System.out.println("\n=== Duplicate-values edge case ===");
        MaxStack dup = new MaxStack();
        dup.push(2);
        dup.push(2);
        System.out.println("peekMax() -> " + dup.peekMax() + " (expected 2)");
        System.out.println("popMax() -> " + dup.popMax() + " (expected 2)");
        System.out.println("peekMax() -> " + dup.peekMax() + " (expected 2)");
        System.out.println("pop() -> " + dup.pop() + " (expected 2)");
    }
}
