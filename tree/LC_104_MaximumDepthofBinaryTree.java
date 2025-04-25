package tree;

public class LC_104_MaximumDepthofBinaryTree {

    // Definition for a binary tree node.
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * TC: O(n) - where n is the number of nodes in the tree
     * SC: O(h) - where h is the height of the tree (due to recursion stack)
     * The space complexity can be O(n) in the case of a skewed tree (like a linked
     * list)
     * and O(log n) in the case of a balanced tree.
     */

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {

        // Test Case 1: Tree with multiple levels
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Max Depth (Expected: 3): " + maxDepth(root1));

        // Test Case 2: Single node tree
        TreeNode root2 = new TreeNode(10);
        System.out.println("Max Depth (Expected: 1): " + maxDepth(root2));

        // Test Case 3: Empty tree
        TreeNode root3 = null;
        System.out.println("Max Depth (Expected: 0): " + maxDepth(root3));

        // Test Case 4: Skewed tree (like a linked list)
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(2);
        root4.right.right = new TreeNode(3);
        root4.right.right.right = new TreeNode(4);
        System.out.println("Max Depth (Expected: 4): " + maxDepth(root4));
    }
}
