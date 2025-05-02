package tree;

public class LC_100_SameTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
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

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null && q == null) {
            return true;
        }
        
        // If one is null and the other is not, return false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        // Test 1: Identical trees
        TreeNode t1a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t1b = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println("Test 1 (Same Trees): " + isSameTree(t1a, t1b)); // true

        // Test 2: Different structure
        TreeNode t2a = new TreeNode(1, new TreeNode(2), null);
        TreeNode t2b = new TreeNode(1, null, new TreeNode(2));
        System.out.println("Test 2 (Different Structure): " + isSameTree(t2a, t2b)); // false

        // Test 3: Different values
        TreeNode t3a = new TreeNode(1, new TreeNode(2), new TreeNode(1));
        TreeNode t3b = new TreeNode(1, new TreeNode(1), new TreeNode(2));
        System.out.println("Test 3 (Different Values): " + isSameTree(t3a, t3b)); // false

        // Test 4: Both null trees
        TreeNode t4a = null;
        TreeNode t4b = null;
        System.out.println("Test 4 (Both Null): " + isSameTree(t4a, t4b)); // true

        // Test 5: One tree is null
        TreeNode t5a = new TreeNode(0);
        TreeNode t5b = null;
        System.out.println("Test 5 (One Null): " + isSameTree(t5a, t5b)); // false
    }
}
