package tree;

import java.util.List;
import java.util.Arrays;

public class LC_559_MaximumDepthofNaryTree {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }

    /*
     * TC: O(n) - where n is the number of nodes in the tree
     * SC: O(h) - where h is the height of the tree (due to recursion stack)
     * The space complexity can be O(n) in the case of a skewed tree (like a linked
     * list) and O(log n) in the case of a balanced tree.
     * The iterative approach using a queue would have the same time complexity of
     * O(n)
     * but the space complexity would be O(w) where w is the maximum width of the
     * tree.
     * The maximum width of a tree can be at most n/2 in the case of a complete
     * binary tree.
     * In the case of a skewed tree, the maximum width would be O(1).
     * 
     */
    static int maxDepth = 0;

    public static int maxDepth(Node root) {
        if (root == null)
            return 0;
        maxDepth = 0;
        helper(root, 1); // start depth at 1
        return maxDepth;
    }

    private static void helper(Node node, int depth) {
        if (node == null)
            return;
        maxDepth = Math.max(maxDepth, depth);
        if (node.children != null) {
            for (Node child : node.children) {
                helper(child, depth + 1);
            }
        }
    }

    /*
     * Iterative approach using a queue-
     * 
     * public int maxDepth(Node root) {
     * 
     * if (root == null) {
     * return 0;
     * }
     * 
     * int depth = 0;
     * 
     * Queue<Node> q = new LinkedList<>();
     * q.offer(root);
     * 
     * while (!q.isEmpty()) {
     * 
     * int size = q.size();
     * 
     * for (int i = 0; i < size; i++) {
     * Node curr = q.poll();
     * for (Node child : curr.children) {
     * q.offer(child);
     * }
     * }
     * depth++;
     * 
     * }
     * 
     * return depth;
     * 
     * }
     * 
     */

    public static void main(String[] args) {
        // Test 1: Tree with 3 levels
        Node root1 = new Node(1, Arrays.asList(
                new Node(2),
                new Node(3, Arrays.asList(new Node(6), new Node(7))),
                new Node(4),
                new Node(5)));
        System.out.println("Test 1 (Depth = 3): " + maxDepth(root1)); // 3

        // Test 2: Single node tree
        Node root2 = new Node(10);
        System.out.println("Test 2 (Depth = 1): " + maxDepth(root2)); // 1

        // Test 3: Null root
        Node root3 = null;
        System.out.println("Test 3 (Depth = 0): " + maxDepth(root3)); // 0

        // Test 4: Deep nested child
        Node root4 = new Node(1, Arrays.asList(
                new Node(2, Arrays.asList(
                        new Node(3, Arrays.asList(
                                new Node(4)))))));
        System.out.println("Test 4 (Depth = 4): " + maxDepth(root4)); // 4
    }
}
