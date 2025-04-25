package tree;

// Definition for a binary tree node.
class TreeNode {
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

public class LC_543_DiameterofBinaryTree {

    /* 
     * TC: O(n) - where n is the number of nodes in the tree
     * SC: O(h) - where h is the height of the tree (due to recursion stack)
     * The space complexity can be O(n) in the case of a skewed tree (like a linked list)
     * and O(log n) in the case of a balanced tree.
     */
    
    private int diameter = 0; // instance variable to track maximum diameter

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0; // Edge case: empty tree
        }
        solve(root);
        return diameter;
    }

    private int solve(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = solve(node.left);
        int rightHeight = solve(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        LC_543_DiameterofBinaryTree obj = new LC_543_DiameterofBinaryTree();

        // Test Case 1: Normal case
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        System.out.println("Diameter (Expected 3): " + obj.diameterOfBinaryTree(root1));

        // Test Case 2: Single node (edge case)
        LC_543_DiameterofBinaryTree obj2 = new LC_543_DiameterofBinaryTree();
        TreeNode root2 = new TreeNode(1);
        System.out.println("Diameter (Expected 0): " + obj2.diameterOfBinaryTree(root2));

        // Test Case 3: Empty tree (edge case)
        LC_543_DiameterofBinaryTree obj3 = new LC_543_DiameterofBinaryTree();
        System.out.println("Diameter (Expected 0): " + obj3.diameterOfBinaryTree(null));

        // Test Case 4: Skewed tree (all left)
        LC_543_DiameterofBinaryTree obj4 = new LC_543_DiameterofBinaryTree();
        TreeNode root4 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), null);
        System.out.println("Diameter (Expected 3): " + obj4.diameterOfBinaryTree(root4));

        // Test Case 5: Skewed tree (all right)
        LC_543_DiameterofBinaryTree obj5 = new LC_543_DiameterofBinaryTree();
        TreeNode root5 = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        System.out.println("Diameter (Expected 3): " + obj5.diameterOfBinaryTree(root5));
    }
}
