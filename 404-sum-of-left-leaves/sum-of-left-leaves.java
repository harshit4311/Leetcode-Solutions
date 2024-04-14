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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            // Checking if the node is a leaf node
            if(node.left != null && node.left.left == null && node.left.right == null) {
                sum += node.left.val;
            }

            // Pushing the right child first so it pops first 
            if(node.right != null) stack.add(node.right);
            if(node.left != null) stack.add(node.left);
        }

        return sum;
    }
}