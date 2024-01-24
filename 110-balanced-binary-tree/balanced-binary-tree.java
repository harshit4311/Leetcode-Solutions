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
        int result = checkHeight(root);

        if(result != -1) {return true;}
        else {return false;}
    }

    public static int checkHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftHeight = checkHeight(root.left);
        if (leftHeight == -1) {
            return -1;  // Left subtree is not balanced
        }

        int rightHeight = checkHeight(root.right);
        if (rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;  // Right subtree is not balanced or current node is not balanced
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}