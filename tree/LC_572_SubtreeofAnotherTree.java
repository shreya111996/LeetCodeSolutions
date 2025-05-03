package tree;

public class LC_572_SubtreeofAnotherTree {

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
     * TC: O(n * m) - where n is the number of nodes in the root tree and m is the
     * number of nodes in the subRoot tree
     * SC: O(n + m) - where n is the number of nodes in the root tree and m is the
     * number of nodes in the subRoot tree
     */

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }
        if (isSame(root, subRoot)) { // check from every node if it is same as subRoot
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSame(TreeNode node, TreeNode subRoot) {

        if (node == null && subRoot == null) {
            return true;
        }
        if (node == null || subRoot == null || node.val != subRoot.val) {
            return false;
        }

        return isSame(node.left, subRoot.left) && isSame(node.right, subRoot.right);
    }

    public static void main(String[] args) {
        // Test 1: subRoot is a subtree
        TreeNode root1 = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5));
        TreeNode subRoot1 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println("Test 1 (Is Subtree): " + isSubtree(root1, subRoot1)); // true

        // Test 2: subRoot not present
        TreeNode root2 = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)),
                new TreeNode(5));
        TreeNode subRoot2 = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println("Test 2 (Not Subtree): " + isSubtree(root2, subRoot2)); // false

        // Test 3: root is null
        TreeNode root3 = null;
        TreeNode subRoot3 = new TreeNode(1);
        System.out.println("Test 3 (Root Null): " + isSubtree(root3, subRoot3)); // false

        // Test 4: subRoot is null
        TreeNode root4 = new TreeNode(1);
        TreeNode subRoot4 = null;
        System.out.println("Test 4 (SubRoot Null): " + isSubtree(root4, subRoot4)); // false

        // Test 5: Both null
        TreeNode root5 = null;
        TreeNode subRoot5 = null;
        System.out.println("Test 5 (Both Null): " + isSubtree(root5, subRoot5)); // false
    }
}
