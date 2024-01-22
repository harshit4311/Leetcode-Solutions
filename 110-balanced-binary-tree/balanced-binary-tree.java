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
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        // Check if the tree is balanced at the current node
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }

        // Check if the left and right subtrees are balanced
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);

        // Return the maximum height of the left and right subtrees
        return Math.max(leftHeight, rightHeight) + 1;
    }
}