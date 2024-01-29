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
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        calculateMaxPathSum(root);
        return maxSum;
    }

    public int calculateMaxPathSum(TreeNode root){
        if(root == null){
            return 0;
        }

        // Calculate the sum of the Left Subtree
        int leftSum = (Math.max(0, calculateMaxPathSum(root.left)));

        // Calculate the sum of the Right Subtree
        int rightSum = (Math.max(0, calculateMaxPathSum(root.right)));

        // Updating the maxSum
        maxSum = Math.max(maxSum, leftSum + rightSum + root.val);

        return Math.max(leftSum, rightSum) + root.val;
    }
}