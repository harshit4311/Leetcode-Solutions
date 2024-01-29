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
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);

        return diameter;
    }

    public int calculateDiameter(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the depth of left and right subtrees
        int leftDepth = calculateDiameter(node.left);
        int rightDepth = calculateDiameter(node.right);

        // Update the diameter
        diameter = Math.max(diameter, (leftDepth + rightDepth));

        // Return the depth of the subtree rooted at the current node
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
