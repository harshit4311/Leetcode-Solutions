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
    int sum = 0;

    public TreeNode bstToGst(TreeNode root) {
        reverseOrderTraversal(root);
        return root;
    }

    public void reverseOrderTraversal(TreeNode root) {
        if(root == null) {
            return;
        }
        
        // Traverse the right subtree first
        reverseOrderTraversal(root.right);

        // Update the node's value with the current sum        
        sum += root.val;
        root.val = sum;

        // Traverse the left subtree
        reverseOrderTraversal(root.left);

    }
}