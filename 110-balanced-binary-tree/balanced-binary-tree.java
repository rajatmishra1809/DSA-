class Solution {
    public boolean isBalanced(TreeNode root) {
        // If the helper returns -1, the tree is unbalanced
        return checkHeight(root) != -1;
    }

    private int checkHeight(TreeNode node) {
        // Base case: An empty tree has a height of 0 and is balanced
        if (node == null) {
            return 0;
        }

        // 1. Check the left subtree
        int leftHeight = checkHeight(node.left);
        if (leftHeight == -1) return -1; // Already unbalanced below us

        // 2. Check the right subtree
        int rightHeight = checkHeight(node.right);
        if (rightHeight == -1) return -1; // Already unbalanced below us

        // 3. Check current node balance
        // If the height difference is greater than 1, this node is unbalanced
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // If balanced, return the actual height of this node's subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }
}