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
    public TreeNode searchBST(TreeNode root, int val) {
        // If the root is null or the root's value is equal to the target, return the root
        if (root == null || root.val == val) {
            return root;
        }

        // If the target is less than the root's value, search in the left subtree
        if (val < root.val) {
            return searchBST(root.left, val);
        }

        // If the target is greater than the root's value, search in the right subtree
        else {
            return searchBST(root.right, val);
        }
    }
}
