package tree;

public class LC_226_InvertBinaryTree {

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

    /*
     * TC: O(n) - where n is the number of nodes in the tree
     * SC: O(h) - where h is the height of the tree (due to recursion stack)
     * The space complexity can be O(n) in the case of a skewed tree (like a linked
     * list)
     * and O(log n) in the case of a balanced tree.
     */

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    /*
     * Iterative version-
     * if (root == null) {
            return null;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while (!q.isEmpty()) {

            TreeNode curr = q.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;

            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }

        return root;
     */

    // Helper method to print in-order traversal
    public static void printInOrder(TreeNode root) {
        if (root == null)
            return;
        printInOrder(root.left);
        System.out.print(root.val + " ");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        // Test 1: Normal binary tree
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        System.out.println("Original Tree Inorder:");
        printInOrder(root);
        TreeNode inverted = invertTree(root);
        System.out.println("\nInverted Tree Inorder:");
        printInOrder(inverted);

        // Test 2: Single node tree
        TreeNode single = new TreeNode(1);
        System.out.println("\n\nSingle Node Tree Inorder:");
        printInOrder(single);
        TreeNode singleInverted = invertTree(single);
        System.out.println("\nInverted Single Node Tree Inorder:");
        printInOrder(singleInverted);

        // Test 3: Empty tree
        TreeNode empty = null;
        TreeNode emptyInverted = invertTree(empty);
        System.out.println("\n\nEmpty Tree Test Passed: " + (emptyInverted == null));
    }
}
