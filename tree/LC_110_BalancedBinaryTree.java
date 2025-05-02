package tree;

public class LC_110_BalancedBinaryTree {

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

    /*
     * TC: O(n) - where n is the number of nodes in the tree
     * SC: O(h) - where h is the height of the tree (due to recursion stack)
     * The space complexity can be O(n) in the case of a skewed tree (like a linked
     * list)
     * and O(log n) in the case of a balanced tree.
     */

    static boolean balance = true;

    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        height(root);
        return balance;
    }

    private static int height(TreeNode node) {
        if (node == null)
            return 0;

        int leftH = height(node.left);
        int rightH = height(node.right);

        if (Math.abs(leftH - rightH) > 1) {
            balance = false;
            return 0; // Early return if unbalanced
        }

        return Math.max(leftH, rightH) + 1;
    }

    public static void main(String[] args) {
        // Test 1: Balanced Tree
        TreeNode root1 = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        balance = true;
        System.out.println("Is Tree 1 Balanced? " + isBalanced(root1)); // true

        // Test 2: Unbalanced Tree
        TreeNode root2 = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(3,
                                new TreeNode(4),
                                null),
                        null),
                null);
        balance = true;
        System.out.println("Is Tree 2 Balanced? " + isBalanced(root2)); // false

        // Test 3: Empty Tree
        TreeNode root3 = null;
        balance = true;
        System.out.println("Is Tree 3 Balanced? " + isBalanced(root3)); // true

        // Test 4: Single Node Tree
        TreeNode root4 = new TreeNode(1);
        balance = true;
        System.out.println("Is Tree 4 Balanced? " + isBalanced(root4)); // true
    }
}
