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
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> postOrderStack = new Stack<>();
        stack.push(root);

        // Perform post-order traversal and store nodes in postOrderStack
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            postOrderStack.push(node);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }

        // Process nodes in post-order
        while (!postOrderStack.isEmpty()) {
            TreeNode node = postOrderStack.pop();

            // Check if left child is a leaf and matches the target
            if (node.left != null && node.left.left == null && node.left.right == null && node.left.val == target) {
                node.left = null;
            }

            // Check if right child is a leaf and matches the target
            if (node.right != null && node.right.left == null && node.right.right == null && node.right.val == target) {
                node.right = null;
            }
        }

        // After first pass, check if root itself should be deleted
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }

        return root;
    }
}
