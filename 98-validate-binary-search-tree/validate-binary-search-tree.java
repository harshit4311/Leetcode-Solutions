/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private long minVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        // Check left subtree
        if (!isValidBST(root.left)) return false;

        // Check current node
        if (minVal >= root.val) return false;

        // Update minVal
        minVal = root.val;

        // Check right subtree
        return isValidBST(root.right);
    }
}
