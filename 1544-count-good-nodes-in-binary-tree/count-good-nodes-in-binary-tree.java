class Solution {
    public int goodNodes(TreeNode root) {
        // Start DFS from the root. 
        // Initially, the maximum value seen so far is the root's own value.
        return dfs(root, root.val);
    }

    private int dfs(TreeNode node, int maxSoFar) {
        // Base case: If we hit a null node, it contributes 0 good nodes
        if (node == null) {
            return 0;
        }

        int goodNodeCount = 0;

        // If the current node's value is greater than or equal to the maximum 
        // value we've encountered on this path so far, it's a "Good Node"!
        if (node.val >= maxSoFar) {
            goodNodeCount = 1;
            // Update the maximum value for the next generation (children)
            maxSoFar = node.val; 
        }

        // Recursively count good nodes in the left and right subtrees, 
        // passing down the updated maxSoFar.
        goodNodeCount += dfs(node.left, maxSoFar);
        goodNodeCount += dfs(node.right, maxSoFar);

        return goodNodeCount;
    }
}