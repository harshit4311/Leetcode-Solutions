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
    public int sumNumbers(TreeNode root) {
        return dfsSum(root, 0); // sum is initially 0
    }

    public int dfsSum(TreeNode root, int sum) {
        if(root == null) return 0;

        sum = (sum * 10) + root.val;

        if(root.left == null && root.right == null) {
            return sum;
        }

        return dfsSum(root.left, sum) + dfsSum(root.right, sum);
    }
}