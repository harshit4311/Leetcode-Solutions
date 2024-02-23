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
    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);

        // Both sides are null
        if(root.left == null && root.right == null) return 1;

        // Left side is null
        if(root.left == null) return rightDepth + 1;

        // Right side is null
        if(root.right == null) return leftDepth + 1;

        // Return the minimum of the two sides of none of them are null
        return Math.min(leftDepth, rightDepth) + 1;


    }
}