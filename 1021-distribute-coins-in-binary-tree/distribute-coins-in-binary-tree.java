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
    int ans = 0;

    public int distributeCoins(TreeNode root) {    
        countMoves(root);
        return ans;
    }

    public int countMoves(TreeNode root) {
        if(root == null) return 0;

        int left = countMoves(root.left);
        int right = countMoves(root.right);

        // Sum of absolute values of excess coins from left and right subtrees
        // These represent the moves required to balance the left and right subtrees
        ans += Math.abs(left) + Math.abs(right);

        // Return the excess coins of the current node after keeping one coin to itself(current node)
        return left + right + root.val - 1;
    }
}